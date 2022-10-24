package kr.perfume.perfumemodule.service;

import kr.perfume.commonmodule.dto.common.SavedResult;
import kr.perfume.perfumemodule.dto.request.FragranceSaveDto;
import kr.perfume.perfumemodule.dto.request.FragranceSaveDtoList;
import kr.perfume.perfumemodule.dto.response.FragranceResponseDto;
import kr.perfume.perfumemodule.entity.fragrance.Fragrance;
import kr.perfume.commonmodule.enums.ErrorCode;
import kr.perfume.commonmodule.exception.PerfumeApplicationException;
import kr.perfume.perfumemodule.repository.FragranceQueryRepository;
import kr.perfume.perfumemodule.repository.FragranceRepository;
import kr.perfume.perfumemodule.searchcondition.FragranceSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FragranceService {

    private final FragranceRepository fragranceRepository;
    private final FragranceQueryRepository fragranceQueryRepository;

    public SavedResult saveFragrance(FragranceSaveDtoList requestDto, HttpServletRequest request) {
        SavedResult savedResult = new SavedResult();
        for (FragranceSaveDto fragranceSaveDto : requestDto.getFragranceSaveList()) {
            if (fragranceSaveDto.getId() == null) {
                savedResult.addInsertedId(fragranceRepository.save(fragranceSaveDto.toEntity()).getId());
            } else {
                Fragrance fragrance = fragranceRepository.findById(fragranceSaveDto.getId())
                        .orElseThrow(() -> new PerfumeApplicationException(ErrorCode.FRAGRANCE_NOT_FOUND));
                fragrance.update(fragranceSaveDto);
                savedResult.addUpdatedId(fragranceSaveDto.getId());
            }
        }
        return savedResult;
    }

    public Page<FragranceResponseDto> findAllFragrancePageDesc(FragranceSearchCondition condition, Pageable pageable) {
        Page<Fragrance> results = fragranceQueryRepository.searchFragrancesWithCondition(condition, pageable);
        return results.map(FragranceResponseDto::new);
    }
}
