package com.example.creditcenter;

import com.example.creditcenter.Model.Audit;
import com.example.creditcenter.Service.ServiceIMPL.AuditServiceImpl;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.util.Date;


@SpringBootTest
class CreditCenterApplicationTests {

    @Rule
    public ContiPerfRule rule = new ContiPerfRule();


    @Test
    void contextLoads() {
    }

    @Autowired
    AuditServiceImpl auditService;

    /**
     *保证幂等性
     * 方法1：使用数据库字段的唯一索引，但是字段必须能够代表这条记录
     *
     * 方法2: 使用加锁的方式进行确保重复提交无效
     **/

    @Test
    @PerfTest(invocations = 10)
    public void TestInsert(){
        SafeThread thread1 = new SafeThread();
        SafeThread thread2 = new SafeThread();
        SafeThread thread3 = new SafeThread();
        SafeThread thread4 = new SafeThread();
        SafeThread thread5 = new SafeThread();
        SafeThread thread6 = new SafeThread();
        SafeThread thread7 = new SafeThread();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        //Date date = new Date(System.currentTimeMillis());
        //Audit audit = new Audit(4, "55",date.toString() , "18827415919", 21);
        //auditService.insertAudit(audit);
    }

    class SafeThread extends Thread{

        private Date date = new Date(System.currentTimeMillis());
        private Audit audit = new Audit(4, "55",date.toString() , "18827415919", 21);

        @Override
        public void run() {
            System.out.println("thread1.run");
            System.out.println("thread return:"+auditService.insertAudit(audit));
        }
    }

}


