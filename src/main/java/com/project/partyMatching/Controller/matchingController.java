package com.project.partyMatching.Controller;


import com.project.partyMatching.dto.SpecDTO;
import com.project.partyMatching.service.matchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/matching/*")
public class matchingController {

    @Autowired
    matchingService matchingService;

    //http://localhost:8080/matching/showParty.do
    @RequestMapping("showParty.do")
    public ModelAndView matchingController(HttpSession session) {
        List<Map<String, Object>> specList = new ArrayList<Map<String, Object>>();
        specList = matchingService.showParty(session);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("party/matching");
        mav.addObject("specList",specList);
        return mav;
    }

    //http://localhost:8080/matching/matchingExec.do?leaderName=bv
    @RequestMapping("matchingExec.do")
    public ModelAndView matchingExec(@ModelAttribute SpecDTO dto, HttpSession session) {
        matchingService.matchingExec(dto);
        ModelAndView mav = new ModelAndView();
        return mav;
    }

}
