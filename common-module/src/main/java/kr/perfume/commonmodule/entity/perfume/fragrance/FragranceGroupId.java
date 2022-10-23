package kr.perfume.commonmodule.entity.perfume.fragrance;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FragranceGroupId implements Serializable {

    @EqualsAndHashCode.Include
    private Long perfume;
    @EqualsAndHashCode.Include
    private Long fragrance;
}
