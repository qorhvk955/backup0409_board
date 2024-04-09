package com.green.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="board_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Board extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long boardNo;
	
	@Column(length=50, nullable=false)
	private int boardWriteYear;
	
	@Column(length=100, nullable=false)
	private String boardTitle;
	
	@Column(length=1000, nullable=false)
	private String boardContent;
	
	@Column(length=255, nullable=false)
	private String boardFile;	
	
	@Column(nullable=false)
	private int viewCount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="section_no")
	private Section section;
	
		
}
