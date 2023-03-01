package com.project.partyMatching.mapper;

import com.project.partyMatching.dto.MemberDTO;
import com.project.partyMatching.dto.SpecDTO;
import com.project.partyMatching.dto.partyDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
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
    //nickname list를 받음
    public List getMatching_L(Map map);
    public List getMatching_De(Map map);
    public List getMatching_Du(Map map);
    public List getMatching_W(Map map);
    public List getMatching_H(Map map);

    public void updatePC_L(Map map);
    public void updatePC_Du(Map map);
    public void updatePC_De(Map map);
    public void updatePC_W(Map map);
    public void updatePC_H(Map map);

    public void updateP(Map map);

    public void getSpec(SpecDTO dto);
}
