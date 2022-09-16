package com.kh.demo.web.api.product;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddReq {
  @NotBlank
  private String pname;   //상품명
  @NotNull
  //@Positive(message = "단가는 양수값이어야 합니다.")
  private Long quantity;  //수량
  @NotNull
  //@Positive(message = "단가는 양수값이어야 합니다.")
  private Long price;     //단가
}
