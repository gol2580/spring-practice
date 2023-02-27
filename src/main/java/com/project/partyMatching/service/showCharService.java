package com.project.partyMatching.service;

import com.project.partyMatching.dto.MemberDTO;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface showCharService {

    public List<Map<String, Object>> showCharExec(HttpSession sesion);

}
