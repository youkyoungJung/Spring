package com.ssg.potato.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssg.potato.domain.Item;
import com.ssg.potato.service.ItemService;

@Controller
public class DetailItemController {

   private ItemService service;
   
   @Autowired
   public void setGroupService(ItemService service) {
      this.service = service;
   }
   
   @RequestMapping("/detail/item")
   public String handleRequest(
         @RequestParam("item_id") int item_id, 
         ModelMap model
         ) throws Exception {
      Item item = this.service.selectItem(item_id);
      model.put("product", item);
      return "item";
   }
   
   @RequestMapping("/shop/addItemToCart")
   public String purchase1(
         HttpServletRequest request,
         HttpServletResponse response,
         @ModelAttribute("item_id") int item_id) 
         throws Exception {
      HttpSession session = request.getSession();
      
      if(UserSession.hasLogined(session)) {
         String member_id = UserSession.getLoginMemberId(session);
         Item item = service.selectItem(item_id);
         
         if(item.getConfirm() == 1) {
            response.setContentType("text/html; charset=UTF-8");
            RequestDispatcher dispatcher = request.getRequestDispatcher("cart");
            dispatcher.include(request, response);
            response.getWriter().write("<script> alert('판매가 완료된 상품입니다. 죄송합니다.'); history.go(-1);</script>");
            response.getWriter().flush();
            return null;
         }
         service.reserve(item_id, member_id);
      }else {
         return "login";
      }
      
      
      return "redirect:/shop/viewCart1";
   }
}