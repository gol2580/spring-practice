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
        System.out.println("leadName = "+dto.getLeaderName());
        System.out.println("bossName = "+dto.getBossName());
        specDAO.getSpec(dto);
        map.put("server",dto.getSserver());
        //leaderName, bossName, numOfChar, userArray, server를 담은 map을 반환
        map = specDAO.getUserList(dto);
        specDAO.updateCP(map);
        specDAO.updateP(map);
        return map;
    }
}
