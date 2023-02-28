package com.project.partyMatching.dao;

import com.project.partyMatching.dto.SpecDTO;

import java.util.List;
import java.util.Map;

public interface specDAO {
    public void specIn(SpecDTO dto);
    public List<Map<String, Object>> showSpec();
    public void matchingExec(SpecDTO dto);
}
