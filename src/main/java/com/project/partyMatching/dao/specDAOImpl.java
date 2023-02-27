package com.project.partyMatching.dao;

import com.project.partyMatching.dto.SpecDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class specDAOImpl implements specDAO{

    @Autowired
    SqlSession sqlSession;

    @Override
    public void specIn(SpecDTO dto) {
        sqlSession.selectOne("com.project.partyMatching.mapper.UserMapper.specIn",dto);
    }
}
