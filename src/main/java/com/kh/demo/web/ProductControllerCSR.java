package com.kh.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/csr")
public class ProductControllerCSR {

  @GetMapping("/products")
  public String view(){
    return "csr/products/view";
  }
}
