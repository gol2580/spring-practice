package com.project.partyMatching.service;

import com.project.partyMatching.dto.SpecDTO;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface matchingService {
    public List<Map<String, Object>> showParty(HttpSession session);
    public void matchingExec(SpecDTO dto);
}
