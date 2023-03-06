package com.project.partyMatching.Controller;


import com.project.partyMatching.dto.SpecDTO;
import com.project.partyMatching.service.matchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
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
    @ResponseBody
    @RequestMapping(value="matchingExec.do", produces="application/json;charset=UTF-8", method=RequestMethod.POST)
    public ModelAndView matchingExec(@RequestBody SpecDTO dto) {
        try {
            System.out.println(URLDecoder.decode(dto.getBossName(), "UTF-8"));
            System.out.println(URLDecoder.decode(dto.getLeaderName(), "UTF-8"));
        } catch (Exception e) {e.printStackTrace();}
        Map<String,Object> map = matchingService.matchingExec(dto);
        System.out.println("matching service success");
        System.out.println(map);
        ModelAndView mav = new ModelAndView();
        if(map.get("userArray")!=null) {
            mav.addObject("leaderName",map.get("leaderName"));
            mav.addObject("bossName",map.get("bossName"));
            mav.addObject("server",map.get("server"));
            mav.addObject("userArray",map.get("userArray"));
            mav.addObject("success","success");
        } else {
            mav.addObject("error","매칭되는 파티원이 없습니다.");
        }
        mav.setViewName("party/matching");
        return mav;
    }

}
