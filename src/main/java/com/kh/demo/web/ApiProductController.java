package com.kh.demo.web;

import com.kh.demo.dao.Product;
import com.kh.demo.svc.ProductSVC;
import com.kh.demo.web.api.ApiResponse;
import com.kh.demo.web.api.product.AddReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j  // log.info()
@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiProductController {

  private final ProductSVC productSVC;

//  등록	POST	/api/products
  @ResponseBody
  @PostMapping(value = "/products")
  public ApiResponse<Long> add(@RequestBody AddReq addReq){
    log.info("reqMsg={}",addReq);
    //검증

    //AddReq->Product 변환
    Product product = new Product();
    BeanUtils.copyProperties(addReq, product );

    //상품등록
    Long id = productSVC.save(product);

    //응답메세지
    ApiResponse.Header header = new ApiResponse.Header("00", "성공");
    ApiResponse<Long> response = new ApiResponse<>(header,id);

    return response;
  }

//  조회	GET	/api/products/{id}
  @ResponseBody
  @GetMapping("/products/{id}")
  public  ApiResponse<Product> findById(@PathVariable("id") Long id){

    //상품조회
    Optional<Product> findedProduct = productSVC.findByProductId(id);

    //응답메세지
    ApiResponse<Product> response = null;
    if(findedProduct.isPresent()){
      Product product = findedProduct.get();
      ApiResponse.Header header = new ApiResponse.Header("00", "성공");
      response = new ApiResponse<>(header,product);
    }else{
      ApiResponse.Header header = new ApiResponse.Header("01", "찾고자하는 정보가 없습니다.");
      response = new ApiResponse<>(header,null);
    }
    return response;
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
