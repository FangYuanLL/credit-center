package com.example.creditcenter.Service.ServiceIMPL;

import com.example.creditcenter.Dao.AuditInfoDao;
//import com.example.creditcenter.Dao.AuditMapper;
import com.example.creditcenter.Dao.ChoseDataSource;
import com.example.creditcenter.Model.Audit;
import com.example.creditcenter.Service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuditServiceImpl implements AuditService {

    //@Autowired
    //AuditMapper auditMapper;

    @Autowired
    AuditInfoDao auditInfoDao;

    @Override
    public Audit selectAuditById(Integer id) {
        return auditInfoDao.selectAuditById();
    }

    @Override
    public int insertAudit(Audit audit) {
        return auditInfoDao.insertAudit(audit);
    }
}
