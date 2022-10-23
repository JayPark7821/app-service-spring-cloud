package kr.perfume.commonmodule.client.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import kr.perfume.commonmodule.dto.common.ApiResponse;
import kr.perfume.commonmodule.exception.PerfumeApplicationException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeignErrorDecoder implements ErrorDecoder {

	private final ObjectMapper objectMapper;

	@SneakyThrows
	@Override
	public Exception decode(String methodKey, Response response) {

		ApiResponse apiResponse = objectMapper.readValue(response.body().asInputStream(), ApiResponse.class);
		switch (response.status()) {
			case 400:
				if (methodKey.contains("getUserByEmail")) {
					return new PerfumeApplicationException(HttpStatus.BAD_REQUEST, apiResponse.getMessage());
				}
			case 500:
				break;
			default:
				return new Exception(response.reason());
		}
		return null;
	}
}
