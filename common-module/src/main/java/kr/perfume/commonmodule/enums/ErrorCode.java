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
    INVALID_PROVIDER_TYPE(HttpStatus.BAD_REQUEST,"Invalid Provider Type" );


    private HttpStatus status;
    private String message;

}
