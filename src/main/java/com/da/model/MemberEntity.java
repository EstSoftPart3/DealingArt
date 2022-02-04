package com.da.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_sample_member")
public class MemberEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MEM_SQ", nullable=false)
	private int memNo;
	
	@Column(name="MEM_ID", nullable=false)
	private String memId;
	
	@Column(name="MEM_PWD", nullable=false)
	private String memPw;
	
	@Column(name="MEM_NM", nullable=false)
	private String memNm;
	
	@Column(name="MEM_EMAIL", nullable=false)
	private String memEmail;
	
}
