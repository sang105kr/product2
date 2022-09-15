package com.kh.demo.web.api;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Rest API 응답메세지 구조
 * @param <T>
 */
@Data
@AllArgsConstructor
public class ApiResponse<T> {
  private Header header;
  private T data;

  @Data
  @AllArgsConstructor
  public static class Header {
    private String rtcd;    //응답 코드  "00"-성공 ,"99"-실패
    private String rtmsg;   //응답 메세지
  }

//  public static <T> ApiResponse<T> createApiMsg(String rtcd, String rtmsg, T data){
//    Header header = new Header(rtcd,rtmsg);
//    ApiResponse<T> res = new ApiResponse<>(header,data);
//    return res;
//  }
}
