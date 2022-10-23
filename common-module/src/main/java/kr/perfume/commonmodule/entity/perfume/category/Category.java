package kr.perfume.commonmodule.entity.perfume.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import kr.perfume.commonmodule.entity.perfume.keyword.KeywordGroup;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "category_desc")
    private String description;

    @OneToOne
    @JoinColumn(name = "keyword_group_id")
    private KeywordGroup keywordGroup;


    @Builder
    public Category(String categoryName, String description, KeywordGroup keywordGroup) {
        this.name = categoryName;
        this.description = description;
        this.keywordGroup = keywordGroup;
    }

    public void update(String name, String desc, KeywordGroup keywordGroup) {
        this.name = name;
        this.description = desc;
        this.keywordGroup = keywordGroup;
    }
}
