package com.project.partyMatching.service;

import com.project.partyMatching.dao.charDAO;
import com.project.partyMatching.dao.memberDAO;
import com.project.partyMatching.dto.CharDTO;
import com.project.partyMatching.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class charInServiceImpl implements charInService{

    @Autowired
    charDAO charDAO;

    @Override
    public void charInExec(CharDTO dto, HttpSession session) {

        if(session.getAttribute("ID")==null) {
            //로그인페이지로
        }
        String ID = (String)session.getAttribute("ID");
        dto.setID(ID);
        System.out.println("ID = " + ID);

        charDAO.charInExec(dto);

    }
}
