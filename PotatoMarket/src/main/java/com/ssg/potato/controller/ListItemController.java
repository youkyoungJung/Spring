package com.ssg.potato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ssg.potato.domain.ItemThumb;
import com.ssg.potato.service.SearchService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;

@Controller
@SessionAttributes({"category", "productList"})
public class ListItemController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ListItemController.class);
	private SearchService service;

	@Autowired
	public void setSearchService(SearchService service) {
		this.service = service;
	}
	
	@RequestMapping("/list/item")
	public String joinPOST(  
			ModelMap model
			) throws Exception{
		logger.info("item list 출력");
		
		PagedListHolder<ItemThumb> productList = new PagedListHolder<>(this.service.getItemsList());
		productList.setPageSize(3);
		model.put("category", "직거래");
		model.put("productList", productList);
		
		return "searchItem";
	}
	
	@RequestMapping("/list/item2")
	public String handleRequest2(
			@RequestParam("page") String page,
			@ModelAttribute("category") String category,
			@ModelAttribute("productList") PagedListHolder<ItemThumb> productList,
			BindingResult result) throws Exception {
		if (category == null || productList == null) {
			throw new IllegalStateException("Cannot find pre-loaded category and product list");
		}
		if ("next".equals(page)) { productList.nextPage(); }
		else if ("previous".equals(page)) { productList.previousPage(); }
		return "searchItem";
	}
	
}
