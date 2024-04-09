package com.green.VO;

import lombok.Data;

@Data
public class PageVO {

	private int startPage;
	private int endPage;
	
	private boolean prev;
	private boolean next;
	
	private long total;
	private ConditionValue cv;
	
	public PageVO(ConditionValue cv, long total) {
		
		this.cv = cv;
		this.total = total;
		
		this.endPage = ((cv.getPageNum()+9)/10)*10;
		this.startPage = this.endPage-9;
		
		int realEndPage = (int)(Math.ceil(this.total/(cv.getAmount()*1.0)));
		
		if(realEndPage < this.endPage) {
			this.endPage = realEndPage;
		}
		
		this.prev = startPage != 1;
		this.next = this.endPage < realEndPage;
		
	}
	
}
