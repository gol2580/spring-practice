package com.project.partyMatching.dao;

import com.project.partyMatching.dto.SpecDTO;
import com.project.partyMatching.dto.partyDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class specDAOImpl implements specDAO{

    @Autowired
    SqlSession sqlSession;

    @Override
    public void specIn(SpecDTO dto) {
        sqlSession.selectOne("com.project.partyMatching.mapper.UserMapper.specIn",dto);
    }
    @Override
    public List<Map<String, Object>> showSpec() {
        return sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.showSpec");
    }

    @Override
    public void matchingExec(SpecDTO dto) {
        String bossName = dto.getBossName();
        List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
        Map<String, Object> nicknames = new HashMap<String, Object>();
        nicknames.put("leaderName",dto.getLeaderName());
        switch (bossName) {
            case "lucid" :
                //sql 리턴타입은 해당히는 닉네임 전부 담은 List임, 근데 여기에는 하나하나 담을지.. 고민해야함
                nicknames.put("nickname",sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_L",dto));
                break;
            case "demian" :
                sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_De",dto);
                break;
            case "djunkel" :
                sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_Du",dto);
                break;
            case "will" :
                sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_W",dto);
                break;
            case "hilla" :
                sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_H",dto);
                break;
        }

    }

    @Override
    public Map<String, Object> getUserList(SpecDTO dto,Map<String, Object> map) {
        String bossName = dto.getBossName();
        //leaderName, bossName, numOfChar, userArray를 담은 map을 반환
        switch (bossName) {
            case "lucid" :
                map.put("userArray",sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_L",map));
                break;
            case "demian" :
                map.put("userArray",sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_De",map));
                break;
            case "djunkel" :
                map.put("userArray",sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_Du",map));
                break;
            case "will" :
                map.put("userArray",sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_W",map));
                break;
            case "hilla" :
                map.put("userArray",sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_H",map));
                break;
        }
        return map;
    }

    @Override
    public void updateCP(Map<String, Object> map) {
        partyDTO party = new partyDTO();
        party.setLeaderName((String)map.get("leaderName"));
        System.out.println("updateCP called");
        System.out.println("map : "+map);
        String sql = "";
        switch ((String)map.get("bossName")) {
            case "lucid" :
                sql="com.project.partyMatching.mapper.UserMapper.updatePC_L";
                break;
            case "demian" :
                sql="com.project.partyMatching.mapper.UserMapper.updatePC_De";
                break;
            case "djunkel" :
                sql="com.project.partyMatching.mapper.UserMapper.updatePC_Du";
                break;
            case "will" :
                sql="com.project.partyMatching.mapper.UserMapper.updatePC_W";
                break;
            case "hilla" :
                sql="com.project.partyMatching.mapper.UserMapper.updatePC_H";
                break;
        }
        for(String nickname :(ArrayList<String>)map.get("userArray")) {
            party.setNickname(nickname);
            sqlSession.selectOne(sql,party);
        }
    }

    @Override
    public Map<String ,Object> getSpec(SpecDTO dto, Map<String, Object> map) {
        map.put("server",sqlSession.selectOne("com.project.partyMatching.mapper.UserMapper.getSpec",dto));
        System.out.println("getSpec success");
        map.put("numOfChar",sqlSession.selectOne("com.project.partyMatching.mapper.UserMapper.getSpecNum",dto));
        System.out.println("getSpecNum success");
        return map;
    }

    @Override
    public void updateP(Map<String, Object> map) {
        sqlSession.selectOne("updateP",map);
    }
}
