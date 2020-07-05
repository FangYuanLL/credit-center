package com.example.creditcenter.Controller;

import com.example.creditcenter.Service.ServiceIMPL.AuditServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RequestMapping(value = "/Audit")
public class AuditController {

    @Autowired
    private AuditServiceImpl auditServiceImpl;

    @ResponseBody
    @RequestMapping(value = "/select")
    public Object SelectById(){
        return auditServiceImpl.selectAuditById(1);
    }


}