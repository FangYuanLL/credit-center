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
        /*selectOne()方法依靠xml文件namespace获取xml文件映射方法slectAuditById*/
        audit = sqlSession.selectOne("com.example.creditcenter.Dao.AuditMapper.selectAuditById", 1);
        System.out.println(audit.toString());
        //sqlSession.close();
        return audit;
    }

    @ChoseDataSource("read")
    public int insertAudit(Audit audit){
        SqlSession sqlSession = getSqlSession();
        int flag = sqlSession.insert("com.example.creditcenter.Dao.AuditMapper.insertAudit",audit);
        return flag;
    }
}
