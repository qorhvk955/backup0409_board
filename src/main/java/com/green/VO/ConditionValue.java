package com.green.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConditionValue {

	private int pageNum;
	private int amount;
	
	public ConditionValue() {
		this(1, 9);
	}
	
}
