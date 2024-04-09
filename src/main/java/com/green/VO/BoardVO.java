package com.green.VO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardVO {

		private long boardNo;
		private String boardTitle;
		private String boardContent;
		private String boardFile;
		private int viewCount;
		private int BoardWriteYear;
		private LocalDateTime regDate;
		private LocalDateTime modDate;
		private String sectionNo;

}
