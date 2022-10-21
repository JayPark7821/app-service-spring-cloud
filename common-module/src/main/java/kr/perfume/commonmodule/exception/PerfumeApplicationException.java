package kr.perfume.commonmodule.exception;

import kr.perfume.commonmodule.enums.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PerfumeApplicationException extends RuntimeException {

    private HttpStatus errorCode;
    private String message;

    public PerfumeApplicationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode.getStatus();
        this.message = errorCode.getMessage();
    }
    public PerfumeApplicationException(HttpStatus errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }


}
