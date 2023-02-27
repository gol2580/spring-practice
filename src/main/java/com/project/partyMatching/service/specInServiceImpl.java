package com.project.partyMatching.service;

import com.project.partyMatching.dao.specDAO;
import com.project.partyMatching.dto.SpecDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.partyMatching.dao.specDAO;
import javax.servlet.http.HttpSession;

@Service
public class specInServiceImpl implements specInService{
    @Autowired
     specDAO specDAO;

    @Override
    public void specInExec(SpecDTO dto, HttpSession session) {
        if(session.getAttribute("ID")==null) {
            //로그인페이지로
        } else {
            String ID = (String)session.getAttribute("ID");
            dto.setLeaderName(ID);
        }
        specDAO.specIn(dto);
    }


}
