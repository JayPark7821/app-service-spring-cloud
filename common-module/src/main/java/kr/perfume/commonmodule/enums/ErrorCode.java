package kr.perfume.commonmodule.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    JOINING_PROCESS_ON_GOING(HttpStatus.BAD_REQUEST, "이미 회원가입이 진행중인 유저 입니다."),
    INVALID_ID_TOKEN(HttpStatus.UNAUTHORIZED, "Invalid IdToken" ),
    NOT_AVAILABLE_YET(HttpStatus.BAD_REQUEST,"Not available yet" ),
    INVALID_PROVIDER_TYPE(HttpStatus.BAD_REQUEST,"Invalid Provider Type" ),
    USER_ALREADY_JOINED(HttpStatus.NOT_ACCEPTABLE,"이미 가입된 회원입니다." ),
    INVALID_JOIN_DATA(HttpStatus.BAD_REQUEST,"잘못된 가입정보 입니다." ),
    FRAGRANCE_NOT_FOUND(HttpStatus.BAD_REQUEST, "향 정보 오류입니다." ),
    NO_AUTHORIZATION_HEADER( HttpStatus.UNAUTHORIZED,"no authorization header" ),
    JWT_TOKEN_IS_NOT_VALID( HttpStatus.UNAUTHORIZED,"JWT token is not valid" );


    private HttpStatus status;
    private String message;

}
