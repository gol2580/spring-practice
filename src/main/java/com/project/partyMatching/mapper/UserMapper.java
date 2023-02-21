package com.project.partyMatching.mapper;

import com.project.partyMatching.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//DAO
@Mapper
@Repository
public interface UserMapper {

    public void testInsert();
    public String loginCheck(MemberDTO dto);
}
