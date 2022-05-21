package com.ssg.potato.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssg.potato.domain.Thumb;
import com.ssg.potato.service.SearchService;

@Controller
public class MainController {

   private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ListItemController.class);
   private SearchService service;
   
   @Autowired
   public void setSearchService(SearchService service) {
      this.service = service;
   }
   
   @RequestMapping("/")
   public String joinPOST(  
         ModelMap model
         ) throws Exception{
      logger.info("item list 출력");
      
      PagedListHolder<Thumb> productList = new PagedListHolder<>(this.service.getMainList());
      productList.setPageSize(12);
      model.put("productList", productList);
      
      return "index";
   }
}