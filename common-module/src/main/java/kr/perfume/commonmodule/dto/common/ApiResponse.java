package kr.perfume.commonmodule.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import kr.perfume.commonmodule.enums.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private final int code;
    private final String message;
    private final T data;

    @Builder
    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T body) {
        return new ApiResponse<T>(HttpStatus.OK.value(), "OK", body);
    }

    public static <T> ApiResponse<T> created(T body) {
        return new ApiResponse<T>(HttpStatus.CREATED.value(), "CREATED", body);
    }

    public static <T> ApiResponse<T> fail(ErrorCode errorCode , T body) {
        return new ApiResponse<T>(errorCode.getStatus().value(), errorCode.getMessage(), body);
    }

    public static <T> ApiResponse<T> fail(HttpStatus errorCode ,String message, T body) {
        return new ApiResponse<T>(errorCode.value(), message, body);
    }


}
