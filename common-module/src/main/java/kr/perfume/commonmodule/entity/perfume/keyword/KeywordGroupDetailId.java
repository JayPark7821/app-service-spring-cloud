package kr.perfume.commonmodule.entity.perfume.keyword;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class KeywordGroupDetailId implements Serializable {

    private Long keywordGroup;
    private Long keywordMaster;

}
