package com.example.creditcenter.Service.ServiceIMPL;

import com.example.creditcenter.Dao.AuditInfoDao;
//import com.example.creditcenter.Dao.AuditMapper;
import com.example.creditcenter.Dao.ChoseDataSource;
import com.example.creditcenter.Model.Audit;
import com.example.creditcenter.Service.AuditService;
import com.example.creditcenter.Utils.CheckSync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuditServiceImpl implements AuditService {

    private static final Object LOCK = new Object();

    @Autowired
    AuditInfoDao auditInfoDao;

    @Override
    public Audit selectAuditById(Integer id) {
        System.out.println(auditInfoDao.selectAuditById(id).getTime());
        return auditInfoDao.selectAuditById(id);
    }

    @Override
    public int insertAudit(Audit audit) {
        int ModeCode = -100;
        synchronized (LOCK){
            boolean flag = CheckSync.CheckDuplicate(audit);
            if (flag == false){
                System.out.println("11111");
                if (audit == null){
                    System.out.println("null");
                }
                ModeCode = auditInfoDao.insertAudit(audit);
                System.out.println("thread:"+ModeCode);
            }
        }
        return ModeCode;
    }

    @Transactional("readTransactionManager")
    @Override
    public int updateAudit(Audit audit) {
        int flag =  auditInfoDao.UpdateAudit(audit);
        int i = 9/0;
        return flag;
    }


}
