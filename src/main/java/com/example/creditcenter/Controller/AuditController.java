package com.example.creditcenter.Controller;

import com.example.creditcenter.Dao.AuditInfoDao;
import com.example.creditcenter.Dao.DbContextHolder;
import com.example.creditcenter.Model.Audit;
import com.example.creditcenter.Service.ServiceIMPL.AuditServiceImpl;
import com.example.creditcenter.Utils.Result;
import com.example.creditcenter.Utils.RetResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;


@Controller
@RequestMapping(value = "/Audit")
public class AuditController {

    @Autowired
    private AuditServiceImpl auditServiceImpl;


    public static  Logger Log = Logger.getLogger(AuditController.class);

    @ResponseBody
    @RequestMapping(value = "/select")
    public Object SelectById(){
        Audit audit = auditServiceImpl.selectAuditById(55);
        Result<Audit> auditResult = RetResponse.pack(200,"success",audit);
        System.out.println(auditResult.getCode());
        return auditResult;
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public Object UpdateAudit(){
        Audit audit = new Audit(56,5,"0","11","11",11);
        int flag = auditServiceImpl.updateAudit(audit);
        return flag;
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
