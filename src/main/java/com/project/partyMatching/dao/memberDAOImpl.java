package com.project.partyMatching.dao;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.project.partyMatching.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;

@Repository  //이 구현클래스를 DAO Bean으로 등록
public class memberDAOImpl implements memberDAO{
    @Autowired //sql - mybatis 실행객체
    SqlSession sqlSession;

    @Override
    public String loginCheck(MemberDTO dto) {
        //sql문 호출, 인자전달  -->  serviceImpl에서 호출
        return sqlSession.selectOne(
                "com.project.partyMatching.mapper.UserMapper.loginCheck"
        , dto);
    }

    @Override
    public MemberDTO viewMember(MemberDTO dto) {
        return sqlSession.selectOne(
                "com.project.partyMatching.mapper.UserMapper.loginCheck"
                , dto);
    }

    @Override
    public void logout(HttpSession session) {

    }
}
