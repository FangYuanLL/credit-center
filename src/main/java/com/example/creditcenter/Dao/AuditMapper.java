package com.example.creditcenter.Dao;

import com.example.creditcenter.Model.Audit;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditMapper {

    @ChoseDataSource("read")
    Audit selectAuditById(Integer id);
}
