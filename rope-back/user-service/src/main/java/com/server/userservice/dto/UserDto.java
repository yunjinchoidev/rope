package com.server.userservice.dto;

import com.server.userservice.vo.ResponseOrder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {

    private String email; // 이메일
    private String name; // 이름
    private String pwd; // 비밀번호
    private String userId; // 유저 ID
    private Date createdAt; // 생성일
    private String decryptedPwd; // 복호화 전 비밀번호
    private String encryptedPwd; // 복호화 한 비밀번호
    private List<ResponseOrder> orders; // 주문 리스트
}
