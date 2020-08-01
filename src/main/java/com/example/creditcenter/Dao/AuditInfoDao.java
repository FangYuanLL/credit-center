package com.example.creditcenter.Dao;


import com.example.creditcenter.Model.Audit;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class AuditInfoDao extends BaseDao {


    @ChoseDataSource("read")
    public Audit selectAuditById(Integer id){
        Audit audit = null;
        SqlSession sqlSession = getSqlSession();
        /*selectOne()方法依靠xml文件namespace获取xml文件映射方法slectAuditById*/
        System.out.println("enter");
        audit = sqlSession.selectOne("com.example.creditcenter.Dao.AuditMapper.selectAuditById", id);
        System.out.println("after");
        System.out.println(audit.getId()+":"+audit.getTime());
        return audit;
    }

    @ChoseDataSource("read")
    public int insertAudit(Audit audit){
        SqlSession sqlSession = getSqlSession();
        int flag = 0;
        flag = sqlSession.insert("com.example.creditcenter.Dao.AuditMapper.insertAudit",audit);
        return flag;
    }

    @ChoseDataSource("read")
    public int UpdateAudit(Audit audit){
        SqlSession sqlSession = getSqlSession();
        int flag = -1;
        flag = sqlSession.update("com.example.creditcenter.Dao.AuditMapper.updateAudit",audit);
        return flag;
    }
}
