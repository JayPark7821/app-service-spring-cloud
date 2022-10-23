package kr.perfume.commonmodule.entity.perfume.keyword;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class KeywordGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_group_id")
    private Long id;

    @OneToMany(mappedBy = "keywordGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KeywordGroupDetail> keywordGroupDetail = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    private KeywordType keywordType;


    public void setKeyword(List<KeywordGroupDetail> keywordGroupDetail) {
        this.keywordGroupDetail = keywordGroupDetail;
        for (KeywordGroupDetail groupDetail : keywordGroupDetail) {
            groupDetail.setKeywordGroupDetail(this);
        }
    }


    @Builder
    public KeywordGroup( KeywordType keywordType) {
        this.keywordType = keywordType;
    }

    public void update( List<KeywordGroupDetail> keywordGroupDetail, KeywordType keywordType ) {
        this.setKeyword( keywordGroupDetail);
        this.keywordType = keywordType;
    }

}
