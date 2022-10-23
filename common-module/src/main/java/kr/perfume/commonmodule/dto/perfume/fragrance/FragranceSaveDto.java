package kr.perfume.commonmodule.dto.perfume.fragrance;

import kr.perfume.commonmodule.entity.perfume.fragrance.Fragrance;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class FragranceSaveDto {

	private Long id;
	@Valid
	@NotNull
	private String name;
	@Valid
	@NotNull
	private String desc;

	public Fragrance toEntity() {
		return Fragrance.builder()
			.name(name)
			.description(desc)
			.build();
	}

}
