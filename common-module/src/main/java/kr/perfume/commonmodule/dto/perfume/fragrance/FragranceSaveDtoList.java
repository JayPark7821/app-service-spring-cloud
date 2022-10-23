package kr.perfume.commonmodule.dto.perfume.fragrance;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Getter
@NoArgsConstructor
public class FragranceSaveDtoList {
    @Valid
    private List<FragranceSaveDto> fragranceSaveList;


}
