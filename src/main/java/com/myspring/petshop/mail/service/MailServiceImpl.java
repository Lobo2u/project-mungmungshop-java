package com.myspring.petshop.mail.service;

import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.myspring.petshop.mail.dao.MailDAO;
import com.myspring.petshop.member.vo.MemberVO;

@Service("mailService")
public class MailServiceImpl implements MailService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SimpleMailMessage preConfiguredMessage;
	@Autowired
	private MailDAO mailDAO;

	@Override
	public String getEmail(MemberVO member) throws Exception {
		
		return mailDAO.selectEmail(member);
	}
	
	@Override
	public String getPw(MemberVO member) throws Exception {
		
		return mailDAO.selectPw(member);
	}
	
	@Override
	public int getEmailCnt(String email) throws Exception {
		
		return mailDAO.selectEmailCnt(email);
	}
}

	
/*
	@Async
	public void sendMail(String to, String subject, String body) {
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setSubject(subject);
			messageHelper.setTo(to);
			messageHelper.setFrom("mungmungshop12@gmail.com", "������");
			messageHelper.setText(body,true);
			mailSender.send(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Async
	public void sendPreConfiguredMail(String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
		mailMessage.setText(message);
		mailSender.send(mailMessage);
	}
} */

/*
 @Service("mailService")
public class MailService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SimpleMailMessage preConfiguredMessage;
	
	@Async //�񵿱� ó��
	public void sendMail(String to, String subject, String body) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			//messageHelper.setCc("zzzzzz@naver.com");
			messageHelper.setFrom("�۽��� ����@naver.com", "ȫ�浿");
			messageHelper.setSubject(subject);
			messageHelper.setTo(to);		
			messageHelper.setText(body);
			mailSender.send(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Async  //�񵿱� ó��  // mail-context.xml�� preConfiguredMessage�� �̸� �����Ѱ����� ����
	public void sendPreConfiguredMail(String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
		mailMessage.setText(message);
		mailSender.send(mailMessage);
	}

}
*/
