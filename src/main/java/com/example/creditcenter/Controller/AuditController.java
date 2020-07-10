package com.example.creditcenter.Controller;

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

    private static Logger log = Logger.getLogger(AuditController.class);

    @Autowired
    private AuditServiceImpl auditServiceImpl;

    @ResponseBody
    @RequestMapping(value = "/select")
    public Object SelectById(){

        log.error("----before exec sql---"+DbContextHolder.getDataSource());

        return auditServiceImpl.selectAuditById(1);

        //log.error("----after exec sql---"+DbContextHolder.getDataSource());
        // aduit;
    }


}
