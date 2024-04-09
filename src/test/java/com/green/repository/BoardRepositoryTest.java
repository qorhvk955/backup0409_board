package com.green.repository;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.entity.Board;
import com.green.entity.Section;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository br;
	
	@Autowired
	SectionRepository sr;
	
	@Test
	public void insertSection() {
		
		for(int i=1; i<=4; i++) {
		
			Section section = null;
			
					switch(i) {
						case 1:
							section = Section.builder().
							sectionName("모든 권한").
							build();
							break;
						case 2:
							section = Section.builder().
							sectionName("VR 아카이빙").
							build();
							break;
						case 3:
							section = Section.builder().
							sectionName("동영상").
							build();
							break;
						case 4:
							section = Section.builder().
							sectionName("디지털 조감도").
							build();
							break;
					}
					
					sr.save(section);					
		}
	}
	
	public void updateYear(Board board) {
        if (board.getRegDate() != null) {
            int year = board.getRegDate().getYear();
            board.setBoardWriteYear(year);
            br.save(board); 
        }
    }
	
	
	@Test
	public void insertBoard() {
			
			Random random = new Random();		
			
			for(int i=1; i<=20; i++) {			
				
				int randomValue = random.nextInt(3)+2;
		        Section section = sr.findById(Integer.valueOf(randomValue)).orElse(null);

		        if(randomValue == 2) {
					Board board = Board.builder()
			                .boardTitle("글 제목 vr" + i)
			                .boardContent("글 내용 vr" + i)
			                .boardFile("image_" + i + ".png")
			                .viewCount(0)
			                .section(section)
			                .build();
			        br.save(board);
			        updateYear(board);				

				}else if(randomValue == 3) {
					Board board = Board.builder()
			                .boardTitle("글 제목 333" + i)
			                .boardContent("글 내용 333" + i)
			                .boardFile("image_" + i + ".png")
			                .viewCount(0)
			                .section(sr.findById(randomValue).orElse(null))
			                .build();
			        br.save(board);
			        updateYear(board);
				}else if(randomValue == 4) {
					Board board = Board.builder()
			                .boardTitle("글 제목 조감도" + i)
			                .boardContent("글 내용 444" + i)
			                .boardFile("image_" + i + ".png")
			                .viewCount(0)
			                .section(sr.findById(randomValue).orElse(null))
			                .build();
			        br.save(board);
			        updateYear(board);
				}
			}			
	}
}
