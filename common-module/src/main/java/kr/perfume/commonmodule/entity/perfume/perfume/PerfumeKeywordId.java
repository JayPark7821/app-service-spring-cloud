package kr.perfume.commonmodule.entity.perfume.perfume;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PerfumeKeywordId implements Serializable{

    @EqualsAndHashCode.Include
    private Long perfume;
    @EqualsAndHashCode.Include
    private Long keywordMaster;
}
