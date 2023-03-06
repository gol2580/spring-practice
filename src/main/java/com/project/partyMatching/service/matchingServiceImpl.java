package com.project.partyMatching.service;

import com.project.partyMatching.dao.specDAO;
import com.project.partyMatching.dto.SpecDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class matchingServiceImpl implements matchingService{
    @Autowired
    specDAO specDAO;
    @Override
    public List<Map<String, Object>> showParty(HttpSession session) {
        List<Map<String, Object>> specList = new ArrayList<Map<String, Object>>();
        specList = specDAO.showSpec();
        try {
            specList = specDAO.showSpec();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return specList;
    }

    @Override
    public Map<String, Object> matchingExec(SpecDTO dto) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("leaderName",dto.getLeaderName());
        map.put("bossName",dto.getBossName());
        System.out.println("leadName = "+dto.getLeaderName());
        System.out.println("bossName = "+dto.getBossName());
        //server, numOfChar를 담은 map 반환
        map=specDAO.getSpec(dto,map);
        System.out.println("getSpec sucess!");
        //leaderName, bossName, numOfChar, userArray, server를 담은 map을 반환
        map = specDAO.getUserList(dto,map);
        System.out.println("getUserList success!");
        //DB table 업데이트
        specDAO.updateCP(map);
        specDAO.updateP(map);
        return map;
    }
}
