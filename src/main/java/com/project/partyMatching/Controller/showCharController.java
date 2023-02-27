package com.project.partyMatching.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.project.partyMatching.service.showCharService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/showChar/*")
@Controller
public class showCharController {
    @Autowired
    showCharService showCharService;

    @RequestMapping("showChar.do")
    public ModelAndView showChar(HttpSession session) {
        List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
        userList = showCharService.showCharExec(session);


        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/showChar");
        mav.addObject("userList",userList);
        return mav;
    }



}
