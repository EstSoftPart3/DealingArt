package com.da.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.da.model.MemberEntity;

@Repository
public interface MemberEntityRepository extends JpaRepository<MemberEntity, Integer>{

}
