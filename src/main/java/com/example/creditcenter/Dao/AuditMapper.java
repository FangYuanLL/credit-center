package com.example.creditcenter.Dao;

import com.example.creditcenter.Model.Audit;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditMapper {
    //Audit selectAuditById(Integer id);
    @ChoseDataSource("master")
    Audit selectAuditById(Integer id);
}