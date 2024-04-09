package com.green.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
