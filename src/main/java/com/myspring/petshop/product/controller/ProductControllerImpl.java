package com.myspring.petshop.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.petshop.common.pagination.Pagination;
import com.myspring.petshop.member.vo.MemberVO;
import com.myspring.petshop.product.service.ProductService;
import com.myspring.petshop.product.vo.ProductVO;
import com.myspring.petshop.review.service.ReviewService;
import com.myspring.petshop.review.vo.ReviewVO;

@Controller("productController")
public class ProductControllerImpl implements ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductVO product;
	@Autowired
	private MemberVO memberVO;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ReviewVO reviewVO;
	@Autowired
	private HttpSession session;
	
	@Override
	@RequestMapping(value="/product/productList.do", method = RequestMethod.GET)
	public ModelAndView getProducts(@ModelAttribute("category") ProductVO category,
			@RequestParam(value="sortBy", required=false, defaultValue="default") String sortBy,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView("productList");
		
		int listCnt = productService.productsCnt(category);
		
		Pagination pagination = new Pagination();
		pagination.setListSize(9);
		pagination.pageInfo(page, range, listCnt);
		
		HashMap<String, Object> productInfo = new HashMap<String, Object>();
		productInfo.put("category", category);
		productInfo.put("pagination", pagination);
		
		List products = null;
		
		
		if(sortBy.equals("default")) {
			products = productService.getProducts(productInfo);
			mav.addObject("products", products);
		}
		
		else if(sortBy.equals("love")) {
			products = productService.getLoveRanking(productInfo);
			mav.addObject("products", products);
		}
		
		else if(sortBy.equals("new")) {
			products = productService.getNewRanking(productInfo);
			mav.addObject("products", products);
		}
		
		else if(sortBy.equals("lowPrice")) {
			products = productService.getLowPriceRanking(productInfo);
			mav.addObject("products", products);
		}
		
		else if(sortBy.equals("highPrice")) {
			products = productService.getHighPriceRanking(productInfo);
			mav.addObject("products", products);
		}
		
		else{
			mav.setViewName("pageError");
		}
	
		mav.addObject("pagination", pagination);
		mav.addObject("category", category);
		mav.addObject("sortBy", sortBy);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/product/getProduct.do", method = RequestMethod.GET)
	public ModelAndView getProduct(@RequestParam("p_code") String p_code,
								   @RequestParam(required = false, defaultValue = "1") int page,
								   @RequestParam(required = false, defaultValue = "1") int range, 
						HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductVO product = productService.getProduct(p_code);
		
		ModelAndView mav = new ModelAndView("product");
		mav.addObject("product", product);
		
		session = request.getSession();
		
		memberVO = (MemberVO)session.getAttribute("member");
		
		
		
		// �Խñ� �� ����
		int listCnt = reviewService.reviewCnt();
		
		Pagination pagination = new Pagination();
		pagination.setListSize(10);
		pagination.pageInfo(page, range, listCnt);
		
		
		
		Map<String, Object> info = new HashMap<String, Object>();
		
		info.put("pagination", pagination);
		info.put("p_code", p_code);
		
		List reviewList = reviewService.listReview(info);

		mav.addObject("reviewList", reviewList);
		mav.addObject("info", info);
		
		return mav;
	}
	
	
	
	@Override
	@RequestMapping(value="/product/newProduct.do", method = RequestMethod.GET)
	public ModelAndView newProduct(
			@RequestParam(value="sortBy", required=false, defaultValue="default") String sortBy,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("newProduct");
		
		int listCnt = productService.newProductsCnt();
		
		Pagination pagination = new Pagination();
		pagination.setListSize(9);
		pagination.pageInfo(page, range, listCnt);
		
		HashMap<String, Object> productInfo = new HashMap<String, Object>();
		productInfo.put("pagination", pagination);
		
		List products = null;
		
		if(sortBy.equals("default")) {
			products = productService.getNewProducts(productInfo);
			mav.addObject("products", products);
		}
		
		else if(sortBy.equals("love")) {
			products = productService.getNewProductsLove(productInfo);
			mav.addObject("products", products);
		}
		
		
		else if(sortBy.equals("lowPrice")) {
			products = productService.getNewProductsLow(productInfo);
			mav.addObject("products", products);
		}
		
		else if(sortBy.equals("highPrice")) {
			products = productService.getNewProductsHigh(productInfo);
			mav.addObject("products", products);
		}
		
		else{
			mav.setViewName("pageError");
		}
	
		mav.addObject("pagination", pagination);
		mav.addObject("products", products);
		mav.addObject("sortBy", sortBy);
		
		return mav;
	}
}
