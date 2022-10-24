package kr.perfume.perfumemodule.controller;

import kr.perfume.commonmodule.dto.common.ApiResponse;
import kr.perfume.commonmodule.dto.common.SavedResult;
import kr.perfume.perfumemodule.dto.request.FragranceSaveDtoList;
import kr.perfume.perfumemodule.dto.response.FragranceResponseDto;
import kr.perfume.commonmodule.exception.PerfumeApplicationException;
import kr.perfume.perfumemodule.searchcondition.FragranceSearchCondition;
import kr.perfume.perfumemodule.service.FragranceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/fragrance")
@RequiredArgsConstructor
public class FragranceController {

    private final FragranceService fragranceService;

    @PostMapping("/")
    public ResponseEntity<ApiResponse<SavedResult>> saveFragrance(@RequestBody @Valid FragranceSaveDtoList requestDto,
                                                         BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            log.error("---------------------- FRAGRANCE BINDING ERROR --------------------------");
            for (ObjectError allError : bindingResult.getAllErrors()) {
                throw new PerfumeApplicationException(HttpStatus.BAD_REQUEST, allError.getDefaultMessage());
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.created(fragranceService.saveFragrance(requestDto, request)));
    }

   @GetMapping("/fragrance")
    public ApiResponse<Page<FragranceResponseDto>> findAllFragrances(String fragranceName, String fragranceDesc, Pageable pageable) {

        FragranceSearchCondition condition = new FragranceSearchCondition(fragranceName, fragranceDesc);
        return ApiResponse.success(fragranceService.findAllFragrancePageDesc(condition, pageable));
    }

}
