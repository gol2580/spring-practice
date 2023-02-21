package com.project.partyMatching.service;

import com.project.partyMatching.dao.memberDAO;
import com.project.partyMatching.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class loginServiceImpl  implements loginService{

    @Autowired
    memberDAO memberDAO;

    @Override
    public String loginCheck(MemberDTO dto, HttpSession session) {
        //쿼리문 실행 -> 세션변수 저장위해 ID 받아냄
        String ID = memberDAO.loginCheck(dto);
        //HttpSession 유지위한 세션변수 저장
        if(ID!=null) { session.setAttribute("userID", dto.getId()); }
        return ID;
    }

    @Override
    public void logout(HttpSession session) {
        session.invalidate(); //로그아웃 : 세션초기화
    }
}
