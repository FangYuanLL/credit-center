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
        Audit audit = new Audit();
        audit.setId(2);
        audit.setUserid(3);
        audit.setResult("98");
        audit.setTime(""+System.currentTimeMillis());
        return auditServiceImpl.insertAudit(audit);
    }


}
