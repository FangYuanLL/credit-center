package com.example.creditcenter.Service;

import com.example.creditcenter.Dao.ChoseDataSource;
import com.example.creditcenter.Model.Audit;

import java.lang.annotation.Inherited;

public interface AuditService {


    Audit selectAuditById(Integer id);
}
