package com.SpringMVC.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfWeb")//@Controller, thể hiện đây là annotation Controller                                     
//homeControllerOfWeb thể hiện đây là controller của web
public class HomeController {
  
   @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
   public ModelAndView homePage() {
      ModelAndView mav = new ModelAndView("web/home");// ví dụ view sẽ tìm đến file home.jsp
      return mav;
   }
  
   
   //modelandview này là object hỗ trợ của Springframwork
 //view có nghĩa là nó sẽ tự động tìm file jsp có tên trong khai báo
  
}