package com.project.partyMatching.dao;

import com.project.partyMatching.dto.CharDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class charDAOImpl implements  charDAO{

    @Autowired //sql - mybatis 실행객체
    SqlSession sqlSession;

    @Override
    public void charInExec(CharDTO dto) {
        sqlSession.selectOne("com.project.partyMatching.mapper.UserMapper.charIn", dto);
    }

    @Override
    public List<Map<String, Object>> showChar() {
        return sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.showChar");
    }
}
