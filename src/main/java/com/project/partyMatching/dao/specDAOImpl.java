package com.project.partyMatching.dao;

import com.project.partyMatching.dto.SpecDTO;
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
            case "루시드" :
                //sql 리턴타입은 해당히는 닉네임 전부 담은 List임, 근데 여기에는 하나하나 담을지.. 고민해야함
                nicknames.put("nickname",sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_L",dto));
                break;
            case "데미안" :
                sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_De",dto);
                break;
            case "듄켈" :
                sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_Du",dto);
                break;
            case "윌" :
                sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_W",dto);
                break;
            case "힐라" :
                sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_H",dto);
                break;
        }

    }

    @Override
    public Map<String, Object> getUserList(SpecDTO dto) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("leaderName",dto.getLeaderName());
        String bossName = dto.getBossName();
        map.put("bossName",dto.getBossName());
        map.put("numOfChar",dto.getNumOfChar());
        //leaderName, bossName, numOfChar, userArray를 담은 map을 반환
        switch (bossName) {
            case "루시드" :
                map.put("userArray",sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_L",map));
                break;
            case "데미안" :
                map.put("userArray",sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_L",map));
                break;
            case "듄켈" :
                map.put("userArray",sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_L",map));
                break;
            case "윌" :
                map.put("userArray",sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_L",map));
                break;
            case "힐라" :
                map.put("userArray",sqlSession.selectList("com.project.partyMatching.mapper.UserMapper.getMatching_L",map));
                break;
        }
        return map;
    }

    @Override
    public void updateCP(Map<String, Object> map) {
        switch ((String)map.get("bossName")) {
            case "루시드" :
                sqlSession.selectOne("com.project.partyMatching.mapper.UserMapper.updatePC_L",map);
                break;
            case "데미안" :
                sqlSession.selectOne("com.project.partyMatching.mapper.UserMapper.updatePC_De",map);
                break;
            case "듄켈" :
                sqlSession.selectOne("com.project.partyMatching.mapper.UserMapper.updatePC_Du",map);
                break;
            case "윌" :
                sqlSession.selectOne("com.project.partyMatching.mapper.UserMapper.updatePC_W",map);
                break;
            case "힐라" :
                sqlSession.selectOne("com.project.partyMatching.mapper.UserMapper.updatePC_H",map);
                break;
        }
    }

    @Override
    public void getSpec(SpecDTO dto) {
        sqlSession.selectOne("com.project.partyMatching.mapper.UserMapper.getSpec",dto);
    }

    @Override
    public void updateP(Map<String, Object> map) {
        sqlSession.selectOne("updateP",map);
    }
}
