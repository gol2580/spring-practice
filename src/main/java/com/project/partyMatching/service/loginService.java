package com.project.partyMatching.service;

import com.project.partyMatching.dto.MemberDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface loginService {
    public String loginCheck(MemberDTO dto, HttpSession session);
    public void logout(HttpSession session);
}
