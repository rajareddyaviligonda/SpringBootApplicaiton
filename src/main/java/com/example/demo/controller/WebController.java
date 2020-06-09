package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*Thymeleaf is a Java-based library used to create a web application. 
It provides a good support for serving a XHTML/HTML5 in web applications. 
In this chapter, you will learn in detail about Thymeleaf.
*/
@Controller
public class WebController {
   @RequestMapping(value = "/index")
   public String index() {
      return "index";
   }
}