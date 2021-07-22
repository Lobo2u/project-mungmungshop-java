package com.myspring.petshop.member.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.myspring.petshop.member.dao.MemberDAO;
import com.myspring.petshop.member.vo.MemberVO;

@EnableScheduling
@Configuration
public class BatchController{
	
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private MemberVO memberVO;
	
	
	private static final Logger logger = LoggerFactory.getLogger(BatchController.class);
	
	@Scheduled(cron="0/10 * * * * *") //�� �� �� �� �� ���� ��
	public void scheduleRun() {
		String batchResult = "success";
		try {
			System.out.println("- - - 10�� �ֱ⸶�� ����");
			List<MemberVO> memberList = memberDAO.batchSelectMember();
			
			
			if(memberList != null) {
				for(int i = 0; i < memberList.size(); i++) {
					memberVO = memberList.get(i);
					System.out.println("VO ũ��"+memberVO);
					memberDAO.deleteMember(memberVO);
				}
			}
		}catch(Exception e) {
			batchResult = "failed";
		}
		
		logger.info("������ ���� : [" + batchResult + "] " );	
	}
}
