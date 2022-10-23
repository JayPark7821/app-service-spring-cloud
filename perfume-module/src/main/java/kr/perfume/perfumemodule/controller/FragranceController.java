package kr.perfume.perfumemodule.controller;

import kr.perfume.commonmodule.dto.common.ApiResponse;
import kr.perfume.commonmodule.dto.common.SavedResult;
import kr.perfume.commonmodule.dto.perfume.fragrance.FragranceSaveDtoList;
import kr.perfume.commonmodule.exception.PerfumeApplicationException;
import kr.perfume.perfumemodule.service.FragranceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
}
