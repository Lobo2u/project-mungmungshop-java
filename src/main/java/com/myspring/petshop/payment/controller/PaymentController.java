package com.myspring.petshop.payment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.petshop.payment.vo.CombineVO;
import com.myspring.petshop.payment.vo.PaymentVO;

public interface PaymentController {
	public String getPaymentCompletePage(Model model) throws Exception;
	public String getPaymentPage(@ModelAttribute("payment") PaymentVO payment,
			HttpServletRequest request, Model model) throws Exception;
	public ModelAndView addPayment(@ModelAttribute("combineVO") CombineVO combineVO, Errors errors,
			   @RequestParam("sale_check") String sale_check, HttpServletRequest request) throws Exception;
}
