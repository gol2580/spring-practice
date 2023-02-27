package com.project.partyMatching.mapper;

import com.project.partyMatching.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

//DAO
@Mapper
@Repository
public interface UserMapper {

    public void testInsert();
    public String loginCheck(MemberDTO dto);
    public void charIn(MemberDTO dto);
    public Map showChar();
}
