package com.project.partyMatching.dao;

import com.project.partyMatching.dto.MemberDTO;

import javax.servlet.http.HttpSession;

public interface memberDAO {
    public String loginCheck(MemberDTO dto);
    public MemberDTO viewMember(MemberDTO dto);
    public void logout(HttpSession session);
}
