package kr.perfume.perfumemodule.entity.keyword;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class KeywordMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id")
    private Long id;

    @Column(name = "keyword_name")
    private String name;

    @Column(name = "keyword_desc")
    private String description;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private KeywordType keywordType;

    @Builder
    public KeywordMaster( String name, String description, KeywordType keywordType) {
        this.name = name;
        this.description = description;
        this.keywordType = keywordType;
    }

//    public void update(KeywordSaveRequestDto keywordSaveRequestDto) {
//        this.name = keywordSaveRequestDto.getName();
//        this.description = keywordSaveRequestDto.getDesc();
//        this.keywordType = keywordSaveRequestDto.getKeywordType();
//    }
}
