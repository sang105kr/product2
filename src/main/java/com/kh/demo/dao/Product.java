package com.kh.demo.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Product {
  private Long productId; //  PRODUCT_ID	NUMBER(10,0)
  private String pname;   //  PNAME	VARCHAR2(30 BYTE)
  private Long quantity;  //  QUANTITY	NUMBER(10,0)
  private Long price;   //  PRICE	NUMBER(10,0)

}
