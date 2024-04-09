package com.green.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.entity.Section;

public interface SectionRepository extends JpaRepository<Section, Integer> {

}
