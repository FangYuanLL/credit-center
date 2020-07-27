package com.example.creditcenter;

import com.example.creditcenter.Model.Audit;
import com.example.creditcenter.Service.ServiceIMPL.AuditServiceImpl;
import com.example.creditcenter.Utils.RetResponse;
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
    public void TestInsert(){

        Audit audit = new Audit();
        audit.setId(2);
        audit.setUserid(3);
        audit.setResult("98");
        audit.setTime(""+System.currentTimeMillis());
        audit.setSerialnumber("18827415919");
        audit.setPlatform(21);
        auditService.insertAudit(audit);
        //System.out.println(RetResponse.pack(200,"success",audit).toString());
    }

}


