package com.project.partyMatching.Controller;

import com.project.partyMatching.dto.MemberDTO;
import com.project.partyMatching.service.loginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

//SqlSession, HttpSession, ModelAndView class, GetMapping annotation 자료 첨부

// /member url로 접속 시 해당 클래스로 매핑 : 모든 매핑이 /member를 상속
@RequestMapping("/member/*")
@Controller
public class loginController {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    loginService loginService;

    //클라이언트가 요청할 경로
   @RequestMapping("login.do")
    // /view/member/login.jsp로 이동
    public String login() {
        System.out.println("login()까지는 호출함");


        //Controller 클래스의 메소드 : String return값이 view의 이름으로 사용됨
        return "/member/login";
    }

    @RequestMapping("login_check.do")
    public ModelAndView loginCheck(@ModelAttribute MemberDTO dto, HttpSession session) {
        String id = loginService.loginCheck(dto, session);
        ModelAndView mav = new ModelAndView();
        if(id!=null) {
            // /view/member/index.jsp로 이동
            mav.setViewName("/member/index"); //로그인 성공 시 뷰의 이름
            mav.addObject("id",id);
            mav.addObject("msg","success");
        } else { //로그인 실패
            mav.setViewName("/member/login"); //다시 로그인 창으로
            mav.addObject("msg","error");
        }
        return mav;
    }

    //@RequestMapping("")
    public ModelAndView logout(HttpSession session, ModelAndView mav) {
        loginService.logout(session);
        //mav를 인자로 받을 지 vs 로컬로 new 할 지?
        mav.setViewName("/member/login");
        mav.addObject("msg","logout");
        return mav;
    }
}
