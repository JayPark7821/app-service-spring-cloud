package kr.perfume.perfumemodule.service;

import kr.perfume.commonmodule.dto.common.SavedResult;
import kr.perfume.commonmodule.dto.perfume.fragrance.FragranceSaveDto;
import kr.perfume.commonmodule.dto.perfume.fragrance.FragranceSaveDtoList;
import kr.perfume.commonmodule.entity.perfume.fragrance.Fragrance;
import kr.perfume.commonmodule.enums.ErrorCode;
import kr.perfume.commonmodule.exception.PerfumeApplicationException;
import kr.perfume.perfumemodule.repository.FragranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FragranceService {

    private final FragranceRepository fragranceRepository;

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
}
