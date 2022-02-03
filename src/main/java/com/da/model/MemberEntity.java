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
	@Column(name="MEM_SQ")
	private int memNo;
	
	@Column(name="MEM_ID")
	private String memId;
	
	@Column(name="MEM_PWD")
	private String memPw;
	
	@Column(name="MEM_NM")
	private String memNm;
	
	@Column(name="MEM_EMAIL")
	private String memEmail;
	
}
