package com.project.partyMatching.service;

import com.project.partyMatching.dto.SpecDTO;

import javax.servlet.http.HttpSession;

public interface specInService {
    public void specInExec(SpecDTO dto, HttpSession session);
}
