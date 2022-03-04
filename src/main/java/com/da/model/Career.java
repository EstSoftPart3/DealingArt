package com.da.model;

import java.time.LocalDate;

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
@Table(name="TBL_DA_CAREER_S")
public class Career {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CAREER_SQ", nullable=false)
	private Long careerSq;	//경력_순번
	
	@Column(name="ARTST_SQ", nullable=false)
	private Long artistSq;	//작가_순번
	
	@Column(name="MBR_SQ", nullable=false)
	private Long mbrSq;	//회원_순번
	
	@Column(name="CAREER_NM", nullable=false, length=200)
	private String careerNm;	//경력_명
	
	@Column(name="CAREER_TYP_CD", length=100)
	private String careerTypCd;	//경력_유형_코드
	
	@Column(name="CAREER_STRT_DATE")
	private LocalDate artistActvtyCd;	//경력_시작_일자
	
	@Column(name="CAREER_ENDNG_DATE", nullable=false)
	private LocalDate artistSelfIntro;	//경력_종료_일자
	
}
