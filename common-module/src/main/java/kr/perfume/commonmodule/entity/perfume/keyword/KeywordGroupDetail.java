package kr.perfume.commonmodule.entity.perfume.keyword;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@IdClass(KeywordGroupDetailId.class)
public class KeywordGroupDetail  {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keyword_group_id")
    private KeywordGroup keywordGroup;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keyword_id")
    private KeywordMaster keywordMaster;

    public void setKeywordGroupDetail(KeywordGroup keywordGroup) {
        this.keywordGroup = keywordGroup;
    }

    @Builder
    public KeywordGroupDetail(KeywordGroup keywordGroup, KeywordMaster keywordMaster) {
        this.keywordGroup = keywordGroup;
        this.keywordMaster = keywordMaster;
    }
}
