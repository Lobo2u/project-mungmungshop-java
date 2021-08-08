package com.myspring.petshop.member.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.myspring.petshop.manager.order.service.ManagerOrderService;
import com.myspring.petshop.member.dao.MemberDAO;
import com.myspring.petshop.member.vo.MemberVO;

@EnableScheduling
@Configuration
public class BatchController{
	
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private MemberVO memberVO;
	@Autowired
	private ManagerOrderService managerOrderService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(BatchController.class);
	
	@Scheduled(cron="0 0 12 * * ?") //초 분 시 일 월 요일 년
	public void scheduleRun() {
		String batchResult = "success";
		try {
			System.out.println("- - - 정오마다 실행");
			List<MemberVO> memberList = memberDAO.batchSelectMember();
			
			if(memberList != null) {
				for(int i = 0; i < memberList.size(); i++) {
					memberVO = memberList.get(i);
					System.out.println("VO 크기"+memberVO);
					memberDAO.deleteMember(memberVO);
				}
			}
		}catch(Exception e) {
			batchResult = "failed";
			e.printStackTrace();
		}
		
		logger.info("스케쥴 실행 : [" + batchResult + "] " );	
	}
	
	@Scheduled(cron="0 0 11 * * ?") //초 분 시 일 월 요일 년
	public void scheduleRun2() {
		String batchResult = "success";
		try {
			System.out.println("- - - 오전 11시마다 실행");
			managerOrderService.batchBuyConfirm();	
		}catch(Exception e) {
			batchResult = "failed";
			e.printStackTrace();
		}
		
		logger.info("스케쥴 실행 : [" + batchResult + "] " );	
	}
}
