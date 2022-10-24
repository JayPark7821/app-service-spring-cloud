package kr.perfume.perfumemodule.searchcondition;

import lombok.Getter;

@Getter
public class FragranceSearchCondition {
	private String fragranceName;

	private String fragranceDesc;

	public FragranceSearchCondition(String fragranceName, String fragranceDesc ) {
		this.fragranceName = fragranceName;
		this.fragranceDesc = fragranceDesc;
	}


}
