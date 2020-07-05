package com.example.creditcenter.Service.ServiceIMPL;

import com.example.creditcenter.Dao.AuditMapper;
import com.example.creditcenter.Model.Audit;
import com.example.creditcenter.Service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    AuditMapper auditMapper;

    @Override
    public Audit selectAuditById(Integer id) {
        return auditMapper.selectAuditById(id);
    }
}
