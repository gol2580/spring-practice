package com.project.partyMatching.service;

import com.project.partyMatching.dto.CharDTO;
import com.project.partyMatching.dto.MemberDTO;

import javax.servlet.http.HttpSession;


public interface charInService {

    public void charInExec(CharDTO dto, HttpSession session);

}
