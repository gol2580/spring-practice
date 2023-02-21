package com.project.partyMatching.Controller;

import com.project.partyMatching.dto.MemberDTO;
import com.project.partyMatching.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
//SqlSession, HttpSession, ModelAndView class 자료 첨부

@RequestMapping("/view/member/*")
@Controller
public class loginController {

    @Autowired
    loginService loginService;

    //@RequestMapping()
    @Autowired
    public String login() {return "/view.member/login.do";}

    //@RequestMapping()
    public ModelAndView loginCheck(@ModelAttribute MemberDTO dto, HttpSession session) {
        String id = loginService.loginCheck(dto, session);
        ModelAndView mav = new ModelAndView();
        if(id!=null) {
            mav.setViewName("");
            mav.addObject("");
        }
        return mav;
    }

    public ModelAndView logout(HttpSession session, ModelAndView mav) {
        loginService.logout(session);
        mav.setViewName("");
        mav.addObject("");
        return mav;
    }
}
