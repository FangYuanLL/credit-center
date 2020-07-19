package com.example.creditcenter.Controller;

import com.example.creditcenter.Dao.AuditInfoDao;
import com.example.creditcenter.Dao.DbContextHolder;
import com.example.creditcenter.Model.Audit;
import com.example.creditcenter.Service.ServiceIMPL.AuditServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
@RequestMapping(value = "/Audit")
public class AuditController {

    @Autowired
    private AuditServiceImpl auditServiceImpl;


    public static  Logger Log = Logger.getLogger(AuditController.class);

    @ResponseBody
    @RequestMapping(value = "/select")
    public Object SelectById(){
        //Log.trace("asjkasm;as");//只有log.error打印出来了
        //return auditServiceImpl.selectAuditById(1);
        //Audit audit = new Audit();
        //audit.setId(2);
        //audit.setUserid(3);
        //audit.setResult("98");
        //audit.setTime(""+System.currentTimeMillis());
        //audit.setSerialnumber("18827415919");
        //audit.setPlatform(21);
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
        return 1;
    }

    class SafeThread extends Thread{

        private Date date = new Date(System.currentTimeMillis());
        private Audit audit = new Audit(4, "55",date.toString() , "18827415919", 21);

        @Override
        public void run() {
            System.out.println("thread1.run");
            System.out.println("thread return:"+auditServiceImpl.insertAudit(audit));
        }
    }


}
