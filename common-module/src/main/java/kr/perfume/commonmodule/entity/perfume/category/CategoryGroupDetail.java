package kr.perfume.commonmodule.entity.perfume.category;

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

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@IdClass(CategoryGroupDetailId.class)
public class CategoryGroupDetail {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_group_id")
    private CategoryGroup categoryGroup;

    private int level;

    public void setRelationWithCategoryGroup(CategoryGroup categoryGroup) {
        this.categoryGroup = categoryGroup;
    }


    @Builder
    public CategoryGroupDetail(Category category, CategoryGroup categoryGroup, int level) {
        this.category = category;
        this.categoryGroup = categoryGroup;
        this.level = level;
    }
}
