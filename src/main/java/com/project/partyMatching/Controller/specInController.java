package com.project.partyMatching.Controller;

import com.project.partyMatching.dto.CharDTO;
import com.project.partyMatching.dto.SpecDTO;
import com.project.partyMatching.service.charInService;
import com.project.partyMatching.service.specInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.project.partyMatching.service.specInService;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/specIn/*")
public class specInController {

        @Autowired
        specInService specInService;

        //클라이언트 주소 : http://localhost:8080/charIn/charIn.do
        @RequestMapping("/specIn.do")
        public String specIn() {
            // views/party/specIn.jsp로 이동
            return "/party/specIn";
        }

        @RequestMapping("/specInExec.do")
        public ModelAndView charInExec(@ModelAttribute SpecDTO dto, HttpSession session) {
            specInService.specInExec(dto, session);
            ModelAndView mav = new ModelAndView();
            //로그인 안 했을 경우의 예외처리 필요!!
            mav.setViewName("/index");
            mav.addObject("id",session.getAttribute("ID"));

            return mav;
        }



}

