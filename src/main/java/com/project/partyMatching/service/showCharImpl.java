package com.project.partyMatching.service;

import com.project.partyMatching.dao.charDAO;
import com.project.partyMatching.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class showCharImpl implements showCharService{

    @Autowired
    charDAO charDAO;

    @Override
    public List<Map<String, Object>> showCharExec(HttpSession session) {
        List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
        try{
            userList=charDAO.showChar();
        } catch (Exception e) {e.printStackTrace();}
        return userList;
    }
}
