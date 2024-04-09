package com.green.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="member_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userNo;
	
	@Column(length=5, nullable=false)
	private String userFirstName;
	
	@Column(length=10, nullable=false)
	private String userLastName;
	
	@Column(length=50, nullable=false)
	private String userId;
	
	@Column(length=50, nullable=false)
	private String userPwd;
	
	@Column(nullable=false)
	private int role;
	
}
