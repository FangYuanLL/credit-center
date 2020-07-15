package com.example.creditcenter.Dao;


import com.example.creditcenter.Model.Audit;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class AuditInfoDao extends BaseDao {


    @ChoseDataSource("read")
    public Audit selectAuditById(){
        Audit audit = null;
        SqlSession sqlSession = getSqlSession();
        audit = sqlSession.selectOne("com.example.creditcenter.Dao.AuditMapper.selectAuditById", 1);
        System.out.println(audit.toString());
        //sqlSession.close();
        return audit;
    }
}
