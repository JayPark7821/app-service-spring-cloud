package kr.perfume.perfumemodule.dto.response;

import kr.perfume.perfumemodule.entity.fragrance.Fragrance;
import lombok.Getter;

@Getter
public class FragranceResponseDto {

    private Long id;

    private String name;

    private String description;


    public FragranceResponseDto(Fragrance entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();

    }
}
