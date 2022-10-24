package kr.perfume.perfumemodule.entity.fragrance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import kr.perfume.perfumemodule.dto.request.FragranceSaveDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Fragrance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fragrance_id")
	private Long id;

	@Column(name = "fragrance_name")
	private String name;

	@Column(name = "fragrance_desc")
	private String description;

	public void update(FragranceSaveDto fragranceSaveDto) {
		this.name = fragranceSaveDto.getName();
		this.description = fragranceSaveDto.getDesc();
	}

	@Builder
	public Fragrance(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
