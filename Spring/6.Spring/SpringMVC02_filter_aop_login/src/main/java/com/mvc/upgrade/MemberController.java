package com.mvc.upgrade;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.dto.MemberDto;
import com.mvc.upgrade.model.service.MemberService;

@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	// loginform.do라는 명령을 받으면
	@RequestMapping("/loginform.do")
	// String 타입의 loginForm() 매소드를 실행하며
	public String loginForm() {
		// logger.info를 통해 콘솔에 'LOGIN FORM'을 알려주며
		logger.info("LOGIN FORM");
		// 'mvclogin'창 (view)를 리턴해줌
		return "mvclogin";
	}
	
	@RequestMapping(value="/ajaxlogin.do", method=RequestMethod.POST)
	public Map<String, Boolean> ajaxLogin(HttpSession session, @RequestBody MemberDto dto){
		// @RequestBody : 요청으로 넘어오는 객체(데이터)를 자바 객체로 바꾸어 주는 역할
		// 현재는 데이터가 json 객체이므로 json객체를 자바 객체로 바꾸어 줌
		logger.info("LOGIN");
		
		MemberDto res = service.login(dto);		
		
		return null;
	}
	
}
