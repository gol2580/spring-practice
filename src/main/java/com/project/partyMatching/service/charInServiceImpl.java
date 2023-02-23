package com.project.partyMatching.service;

import com.project.partyMatching.dao.memberDAO;
import com.project.partyMatching.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class charInServiceImpl implements charInService{

    @Autowired
    memberDAO memberDAO;

    @Override
    public String charInExec(MemberDTO dto) {
        String nickname = memberDAO.charInExec(dto);
        return nickname;
    }
}
