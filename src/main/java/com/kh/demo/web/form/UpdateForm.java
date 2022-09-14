package com.kh.demo.web.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
public class UpdateForm {
  private Long productId;
  @NotBlank
  private String pname;     //  PNAME	VARCHAR2(30 BYTE)
  @NotNull
  @PositiveOrZero
  private Long quantity;    //  QUANTITY	NUMBER(10,0)
  @NotNull
  @PositiveOrZero
  private Long price;       //  PRICE	NUMBER(10,0)
}
