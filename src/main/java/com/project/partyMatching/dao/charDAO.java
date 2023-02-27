package com.project.partyMatching.dao;

import com.project.partyMatching.dto.CharDTO;
import com.project.partyMatching.dto.MemberDTO;

import java.util.List;
import java.util.Map;

public interface charDAO {
    public void charInExec(CharDTO dto);
    public List<Map<String, Object>> showChar();
}
