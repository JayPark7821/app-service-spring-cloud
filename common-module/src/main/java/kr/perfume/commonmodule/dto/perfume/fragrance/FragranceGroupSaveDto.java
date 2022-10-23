package kr.perfume.commonmodule.dto.perfume.fragrance;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class FragranceGroupSaveDto {
	@Valid
	@NotNull
	private Long id;
	@Valid
	@NotNull
	@Max(100)
	@Min(0)
	private int percentage;



}
