package kr.perfume.commonmodule.dto.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class SavedResult {

	private List<Long> inserted = new ArrayList<>();
	private List<Long> updated = new ArrayList<>();

	private int totalCount;

	public void addInsertedId(Long id) {
		this.inserted.add(id);
		this.totalCount++;
	}
	public void addUpdatedId(Long id) {
		this.updated.add(id);
		this.totalCount++;
	}
}
