package com.green.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="section_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Section {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sectionNo;
	
	@Column(length=50, nullable=false)
	private String sectionName;
	
}
