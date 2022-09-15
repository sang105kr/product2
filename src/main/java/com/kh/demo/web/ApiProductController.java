package com.kh.demo.web;

import com.kh.demo.dao.Product;
import com.kh.demo.svc.ProductSVC;
import com.kh.demo.web.api.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j  // log.info()
@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiProductController {

  private final ProductSVC productSVC;

//  등록	POST	/api/products
  @ResponseBody
  @PostMapping(value = "/products")
  public ApiResponse<List<Person>> add(@RequestBody String reqMsg){
    log.info("reqMsg={}",reqMsg);

   List<Person> persons = new ArrayList<>();

    Person p1 = new Person("홍길동", 30);
    Person p2 = new Person("홍길순", 20);

    persons.add(p1);    persons.add(p2);

    ApiResponse.Header header = new ApiResponse.Header("00", "성공");
    ApiResponse<List<Person>> response = new ApiResponse<>(header,persons);

    return response;
  }

  @Data
  @AllArgsConstructor
  static class Person{
    private String name;
    private int age;
  }


//  조회	GET	/api/products/{id}
  @GetMapping("/products/{id}")
  public String findById(){
    return "ok";
  }
//  수정	PATCH	/api/products/{id}
  @PatchMapping("/products/{id}")
  public String edit(){
    return "ok";
  }
//  삭제	DELETE	/api/products/{id}
  @DeleteMapping("/products/{id}")
  public String del(){
    return "ok";
  }
//  목록	GET	/api/products
  @ResponseBody
  @GetMapping("/products")
  public ApiResponse<List<Product>> findAll(){

    List<Product> list = productSVC.findAll();

    //api응답 메세지
    ApiResponse.Header header = new ApiResponse.Header("00","성공");
    ApiResponse<List<Product>> response = new ApiResponse<>(header, list);

    return response;
  }
}
