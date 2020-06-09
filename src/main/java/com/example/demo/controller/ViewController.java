package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
   @RequestMapping("/view-products")
   @CrossOrigin(origins = "http://localhost:9090")
   public String viewProducts() {
      return "view-products";
   }
   
   @RequestMapping("/add-products")
   @CrossOrigin(origins = "http://localhost:9090")
   public String addProducts() {
      return "add-products";   
   }
   
}