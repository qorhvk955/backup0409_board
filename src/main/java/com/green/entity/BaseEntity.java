package com.green.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
abstract class BaseEntity {

	
	@Column(name="regDate", updatable = false)
	private LocalDateTime regDate;
	
	@LastModifiedDate
	@Column(name ="modDate")
	private LocalDateTime modDate;
	
    public BaseEntity() {
        Random random = new Random();
        
        int minYear = 2024;
        int maxYear = 2026;
        int year = minYear + random.nextInt(maxYear - minYear + 1);
        
        LocalDate randomDate = LocalDate.of(year, random.nextInt(12) + 1, random.nextInt(28) + 1);
        LocalTime randomTime = LocalTime.of(random.nextInt(24), random.nextInt(60));
        this.regDate = LocalDateTime.of(randomDate, randomTime);
    }


}
