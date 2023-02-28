package com.project.partyMatching.mapper;

import com.project.partyMatching.dto.MemberDTO;
import com.project.partyMatching.dto.SpecDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Vector;

//DAO
@Mapper
@Repository
public interface UserMapper {

    public void testInsert();
    public String loginCheck(MemberDTO dto);
    public void charIn(MemberDTO dto);
    public Map showChar();
    public void specIn(SpecDTO dto);
    public Map showSpec();

    public Map getMatching_L(SpecDTO dto);
    public Map getMatching_De(SpecDTO dto);
    public Map getMatching_Du(SpecDTO dto);
    public Map getMatching_W(SpecDTO dto);
    public Map getMatching_H(SpecDTO dto);

    public void updatePC_L(Map map);
}
