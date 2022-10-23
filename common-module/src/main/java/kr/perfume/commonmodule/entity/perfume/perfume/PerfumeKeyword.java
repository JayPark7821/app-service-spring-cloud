package kr.perfume.commonmodule.entity.perfume.perfume;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import kr.perfume.commonmodule.entity.perfume.keyword.KeywordMaster;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@IdClass(PerfumeKeywordId.class)
public class PerfumeKeyword {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfume_id")
    @JsonBackReference
    private Perfume perfume;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keyword_id")
    private KeywordMaster keywordMaster;


    @Builder
    public PerfumeKeyword(Perfume perfume, KeywordMaster keywordMaster) {
        this.perfume = perfume;
        this.keywordMaster = keywordMaster;
    }

    public void setPerfumeRelation(Perfume perfume) {
        this.perfume = perfume;
    }
}
