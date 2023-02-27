package com.project.partyMatching.Controller;

import com.project.partyMatching.dto.CharDTO;
import com.project.partyMatching.dto.MemberDTO;
import com.project.partyMatching.service.charInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/charIn/*")
public class charInController {

    @Autowired
    charInService charInService;

    //클라이언트 주소 : http://localhost:8080/charIn/charIn.do
    @RequestMapping("/charIn.do")
    public String charIn() {
        // views/member/charIn.jsp로 이동
        return "/member/charIn";
    }

    @RequestMapping("/charInExec.do")
    public ModelAndView charInExec(@ModelAttribute CharDTO dto, HttpSession session) {
        charInService.charInExec(dto, session);
        String nickname = dto.getNickname();
        ModelAndView mav = new ModelAndView();
        //로그인 안 했을 경우의 예외처리 필요!!
        if(nickname!=null) {
            mav.addObject("nickname",nickname);
            mav.setViewName("/index");
        } else {
            mav.addObject("nickname","error");
            //뷰이동X, error인 경우 alert 띄우기
            mav.setViewName("/member/charIn");
        }
        return mav;
    }



}
