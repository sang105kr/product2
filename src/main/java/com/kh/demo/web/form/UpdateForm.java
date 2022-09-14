package com.kh.demo.web.form;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UpdateForm {
  private Long productId;
  @NotBlank
  private String pname;     //  PNAME	VARCHAR2(30 BYTE)
  @NotNull
  @Positive
  @Max(9999999999L)
  private Long quantity;    //  QUANTITY	NUMBER(10,0)
  @NotNull
  @Positive
  @Max(9999999999L)
  private Long price;       //  PRICE	NUMBER(10,0)
}
