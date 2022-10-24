package kr.perfume.perfumemodule.entity.fragrance;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import kr.perfume.perfumemodule.entity.perfume.Perfume;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@IdClass(FragranceGroupId.class)
public class FragranceGroup {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfume_id")
    @JsonBackReference
    private Perfume perfume;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fragrance_id")
    @JsonManagedReference
    private Fragrance fragrance;

    private int containPercentage;

    @Builder
    public FragranceGroup(Perfume perfume, Fragrance fragrance, int containPercentage) {
        this.perfume = perfume;
        this.fragrance = fragrance;
        this.containPercentage = containPercentage;

    }
    public void setPerfumeRelation(Perfume perfume) {
        this.perfume = perfume;
    }
//    public void setFragranceRelation(Fragrance fragrance) {
//        this.fragrance = fragrance;
//    }


}
