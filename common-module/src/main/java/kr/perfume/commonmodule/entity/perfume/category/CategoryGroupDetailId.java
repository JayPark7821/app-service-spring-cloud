package kr.perfume.commonmodule.entity.perfume.category;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CategoryGroupDetailId implements Serializable {

    @EqualsAndHashCode.Include
    private Long category;
    @EqualsAndHashCode.Include
    private Long categoryGroup;

}
