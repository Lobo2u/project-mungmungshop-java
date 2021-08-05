package com.myspring.petshop.myPage.member.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.petshop.member.vo.MemberVO;
import com.myspring.petshop.myPage.member.service.MyPageMemberService;

@Controller
public class MyPageMemberControllerImpl implements MyPageMemberController {
	@Autowired
	private MyPageMemberService myPageMemberService;
	@Autowired
	private MemberVO memberVO;
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	
	@Override
	@RequestMapping(value ="/myPage/pwCertify.do", method = RequestMethod.GET)
	public String pwCertifyForm() throws Exception {
		
		return "pwCertify";
	}
	
	@Override
	@RequestMapping(value ="/myPage/newPW.do", method = RequestMethod.GET)
	public String newPwForm() throws Exception {
		
		return "newPW";
	}
	
	@Override
	@RequestMapping(value = "/myPage/infoCertify.do", method = RequestMethod.GET)
	public String infoCertifyForm() throws Exception {


		return "infoCertify";
	}
	
	@Override
	@RequestMapping(value = "/myPage/quit.do", method = RequestMethod.GET)
	public String quitForm() throws Exception {


		return "quit";
	}
	
	@Override
	@RequestMapping(value = "/myPage/infoModify.do", method = RequestMethod.GET)
	public ModelAndView InfoModifyForm(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		memberVO = (MemberVO) session.getAttribute("member");
		
		ModelAndView mav = new ModelAndView("infoModify");
		mav.addObject("memberVO", memberVO);

		return mav;
	}
	
	@Override
	@RequestMapping(value = "/myPage/getInfoModify.do", method = RequestMethod.POST)
	public ResponseEntity getInfoModify(@RequestParam("member_pw") String member_pw, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		memberVO = (MemberVO) session.getAttribute("member");
		boolean passMatch = passEncoder.matches(member_pw, memberVO.getMember_pw());
		
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		if(passMatch) {
			message = "<script>";
			message += "location.href='" + request.getContextPath() + "/myPage/infoModify.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		}
		else {
			message = "<script>";
			message += "alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');";
			message += "location.href='" + request.getContextPath() + "/myPage/infoCertify.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.BAD_REQUEST);
		}
		
		return resEnt;
	}
	
	@Override
	@RequestMapping(value = "/myPage/getNewPw.do", method = RequestMethod.POST)
	public ResponseEntity getNewPw(@RequestParam("member_pw") String member_pw, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		memberVO = (MemberVO) session.getAttribute("member");
		boolean passMatch = passEncoder.matches(member_pw, memberVO.getMember_pw());
		
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		if(passMatch) {
			message = "<script>";
			message += "location.href='" + request.getContextPath() + "/myPage/newPW.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		}
		else {
			message = "<script>";
			message += "alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');";
			message += "location.href='" + request.getContextPath() + "/myPage/pwCertify.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.BAD_REQUEST);
		}
		
		return resEnt;
	}
	
	@Override
	@RequestMapping(value = "/myPage/modPw.do", method = RequestMethod.POST)
	public ResponseEntity modPw(@RequestParam("member_pw") String member_pw, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		memberVO = (MemberVO) session.getAttribute("member");
	
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		boolean passMatch = passEncoder.matches(member_pw, memberVO.getMember_pw());
		
		if(passMatch) {
			message = "<script>";
			message += "alert('���� ��й�ȣ�� �ٸ� ��й�ȣ�� �������ּ���.');";
			message += "location.href='" + request.getContextPath() + "/myPage/newPW.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.BAD_REQUEST);
		}
		
		else {
			try {
				member_pw = passEncoder.encode(member_pw);
				memberVO.setMember_pw(member_pw);
				myPageMemberService.modPw(memberVO);
				session.removeAttribute("member");
				message = "<script>";
				message += "alert('������ �Ϸ�Ǿ����ϴ�.�ٽ� �α��� ���ּ���.');";
				message += "location.href='" + request.getContextPath() + "/login.do';";
				message += " </script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
			}catch(Exception e) {
				message = "<script>";
				message += "alert('������ �߻��Ͽ����ϴ�.');";
				message += "location.href='" + request.getContextPath() + "/myPage/pwCertify.do';";
				message += " </script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.BAD_REQUEST);
				e.printStackTrace();
			}
		}
		
		return resEnt;
	}
	
	
	@Override
	@RequestMapping(value = "/myPage/modifyInfo.do", method = RequestMethod.POST)
	public ResponseEntity modifyInfo(@ModelAttribute("member") MemberVO member, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		memberVO = (MemberVO) session.getAttribute("member");
		int member_num = memberVO.getMember_num();
		member.setMember_num(member_num);
		
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		try {
			myPageMemberService.modifyInfo(member);
			session.removeAttribute("member");
			message = "<script>";
			message += "alert('ȸ�� ���� ������ �Ϸ��Ͽ����ϴ�.�ٽ� �α��� ���ּ���.');";
			message += "location.href='" + request.getContextPath() + "/login.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		}catch(Exception e) {
			message = "<script>";
			message += "alert('������ �߻��Ͽ����ϴ�.');";
			message += "location.href='" + request.getContextPath() + "/myPage/infoModify.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return resEnt;
	}
	
	@Override
	@RequestMapping(value = "/myPage/removeMember.do", method = RequestMethod.POST)
	public ResponseEntity removeMember(@RequestParam("member_pw") String member_pw, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		memberVO = (MemberVO) session.getAttribute("member");
		
		boolean passMatch = passEncoder.matches(member_pw, memberVO.getMember_pw());
		
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		if(!passMatch) {
			message = "<script>";
			message += "alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �õ����ּ���.');";
			message += "location.href='" + request.getContextPath() + "/myPage/quit.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.BAD_REQUEST);
		}else {
			try {
				myPageMemberService.removeMember(memberVO);
				session.removeAttribute("member");
				message = "<script>";
				message += "alert('ȸ�� Ż�� �Ϸ��Ͽ����ϴ�.�׵��� ���� ����Ʈ�� �̿����ּż� �����մϴ�.');";
				message += "location.href='" + request.getContextPath() + "/main.do';";
				message += " </script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
			}catch(Exception e) {
				message = "<script>";
				message += "alert('������ �߻��Ͽ����ϴ�.');";
				message += "location.href='" + request.getContextPath() + "/myPage/quit.do';";
				message += " </script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.BAD_REQUEST);
				e.printStackTrace();
			}
		}
		
		return resEnt;
	}
}
