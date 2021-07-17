package com.myspring.petshop.mail.controller;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.petshop.mail.service.MailServiceImpl;
import com.myspring.petshop.member.controller.MemberControllerImpl;
import com.myspring.petshop.member.vo.MemberVO;


@Controller("mailController")
@EnableAsync // �񵿱� ó�� ���ִ� @Async �ֳ����̼��� �ν��� �� �ְ� ���ִ� �ֳ����̼�.
public class MailControllerImpl implements MailController {
	@Autowired
	private MailServiceImpl mailService;
	@Autowired
	private JavaMailSender mailSender;
	
	private static final Logger logger = LoggerFactory.getLogger(MailControllerImpl.class);
	
	@Override
	@RequestMapping(value="/mail/sendMailByJoin.do", method=RequestMethod.GET)
	@ResponseBody
	public int sendMailByJoin(String email) throws Exception {
		
		int emailCnt = mailService.getEmailCnt(email);
		
		if(emailCnt > 3) {
			int checkNum = 0;
			
			return checkNum;
		}else {
		
			Random random = new Random();
			int checkNum = random.nextInt(888888) + 111111;
		
			String setFrom = "mungmungshop12@gmail.com";
			String setFromName = "������";
			String toMail = email;
			String title = "ȸ������ ���� �̸��� �Դϴ�.";
			String content =
					"Ȩ�������� �湮���ּż� �����մϴ�." +
							"<br><br>" +
							"���� ��ȣ�� " + checkNum + " �Դϴ�." +
							"<br><br>" +
							"�ش� ������ȣ�� ������ȣ Ȯ�ζ��� �����Ͽ� �ּ���.";
		
		
			try {		
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
				helper.setFrom(setFrom,setFromName);
				helper.setTo(toMail);
				helper.setSubject(title);
				helper.setText(content,true);
				mailSender.send(message);
		    }catch(Exception e) {
			    logger.error("Error:join_mailCheck send error");
		    }
			return checkNum;
		}
	}
	
	@Override
	@RequestMapping(value="/mail/findPwCheck.do", method = RequestMethod.POST)
	public ModelAndView sendMailByfindPw(@ModelAttribute("member")MemberVO member,RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String email = mailService.getEmail(member);
		ModelAndView mav = new ModelAndView();
		if(email != null && email != "") {
			String id = member.getMember_id();
			Random random = new Random();
			int checkNum = random.nextInt(888888) + 111111;
			String setFrom = "mungmungshop12@gmail.com";
			String setFromName = "������";
			String toMail = email;
			String title = "��й�ȣ ã�� ���� �̸��� �Դϴ�.";
			String content =
					"Ȩ�������� �湮���ּż� �����մϴ�." +
					"<br><br>" +
					"���� ��ȣ�� " + checkNum + " �Դϴ�." +
					"<br><br>" +
					"�ش� ������ȣ�� ������ȣ Ȯ�ζ��� �����Ͽ� �ּ���.";
			try {		
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
				helper.setFrom(setFrom,setFromName);
				helper.setTo(toMail);
				helper.setSubject(title);
				helper.setText(content,true);
				mailSender.send(message);
			} catch(Exception e) {
				logger.error("Error:findPw_mailCheck send error");
			}
			mav.setViewName("findPwCheck");
			mav.addObject("passcode", checkNum);
			mav.addObject("id", id);
			mav.addObject("email", email);
		}else {
			rAttr.addAttribute("email", "notExists");
			mav.setViewName("redirect:/findPw.do");
		}
		
		return mav;
	}

}
	
/*	
	@RequestMapping(value="/sendMail.do", method = RequestMethod.GET)
	public void sendSimpleMail(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");	// Ŭ���̾�Ʈ�� ��û ������ ����� request ��ü�� �ѱ� ���ڵ��� ���� utf-8����
		response.setContentType("text/html;charset=utf-8");	//�������� Ŭ���̾�Ʈ�� ������ �ѱ� ���ڵ��� ���� utf-8 ����
		PrintWriter out = response.getWriter(); //�ؽ�Ʈ ������ response ���� ��ü�� Ŭ���̾�Ʈ�� ������ ���� �� �ִ� ��Ʈ���� ����/ 
		StringBuffer sb = new StringBuffer(); //java.lang.StringBuffer�� �ξ� ȿ�����̰� ���� ó���ӵ��� ���ڿ��� �߰��մϴ�.(String Ŭ���� ��ü�� + �����ڸ� �̿��� ���ڿ��� �����ϸ� ��� ���ο� ��ü�� �����Ͽ� ���ڿ��� ���� �����ϸ� �Ҽ��� ������ ����Ӹ� �ƴ϶� �ӵ� ���� �ſ� �������Եȴ�)�Һ� Ŭ����=String,����Ŭ����=StringBuffer
		sb.append("<html><body>");
		sb.append("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
		sb.append("<h1>"+"��ǰ�Ұ�"+"<h1><br>");
		sb.append("�Ű� ������ �Ұ��մϴ�.<br><br>");
		sb.append("<a href='http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788956746425&orderClick=LAG&Kc=#N'>");
		sb.append("<img src='http://image.kyobobook.co.kr/images/book/xlarge/425/x9788956746425.jpg'/></a><br>");
		sb.append("</a>");
		sb.append("<a href='http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788956746425&orderClick=LAG&Kc=#N'>��ǰ����</a>");
		sb.append("</body></html>");		//������� ���ڿ��� ȿ�������� �����Ѵ�.
		String str=sb.toString();			//ȿ�������� ������ �� toString() �޼ҵ带 �̿��� ���ڿ��� �Ҵ�
		mailService.sendMail("������@naver.com", "�Ż�ǰ�� �Ұ��մϴ�", str);		
		
		out.print("������ ���½��ϴ�!!");
	} */

/*
@Controller
@EnableAsync  //�񵿱�ó�� @Async�� ����� �� �ְ� ���ִ� �༮ (@Async�� public �޼ҵ忡�� �����ؾ��Ѵ�,���� Ŭ�����ȿ����� ȣ���� �۵����� �ʴ´�.)
public class MailController {
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/sendMail.do", method = RequestMethod.GET)
	public void sendSimpleMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		mailService.sendMail("�����ڸ���@naver.com","�׽�Ʈ ����","�ȳ��ϼ���. ���� ���� �����Դϴ�.");
		mailService.sendPreConfiguredMail("�׽�Ʈ �����Դϴ�.");
		out.print("������ ���½��ϴ�!!");
	}
}				*/

