package com.example.creditcenter;

import com.example.creditcenter.Model.Audit;
import com.example.creditcenter.Service.ServiceIMPL.AuditServiceImpl;
import org.databene.contiperf.PerfTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreditCenterApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    AuditServiceImpl auditService;

    @Test
    @PerfTest(invocations = 1,threads = 1)
    public void TestInsert(){
        Audit audit = new Audit(3,"55",System.currentTimeMillis()+"");
        auditService.insertAudit(audit);
    }

}
