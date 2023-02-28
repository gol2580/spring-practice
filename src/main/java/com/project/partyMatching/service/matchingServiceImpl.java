package com.project.partyMatching.service;

import com.project.partyMatching.dao.specDAO;
import com.project.partyMatching.dto.SpecDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    public void matchingExec(SpecDTO dto) {
        specDAO.matchingExec(dto);
    }
}
