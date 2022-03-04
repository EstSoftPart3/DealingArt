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
@Table(name="TBL_DA_EXHBTN_S")
public class Exhbtn {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EXHBTN_SQ", nullable=false)
	private Long exhbtnSq;	//학력_순번
	
	@Column(name="ARTST_SQ", nullable=false)
	private Long artistSq;	//작가_순번
	
	@Column(name="MBR_SQ", nullable=false)
	private Long mbrSq;	//회원_순번
	
	@Column(name="EXHBTN_NM", nullable=false, length=200)
	private String exhbtnNm;	//전시_명
	
	@Column(name="EXHBTN_TYP_CD", nullable=false, length=100)
	private String exhbtnTypCd;	//전시_유형_코드
	
	@Column(name="EXHBTN_STRT_DATE")
	private LocalDate exhbtnStrtDate;	//전시_시작_일자
	
	@Column(name="EXHBTN_ENDNG_DATE", nullable=false)
	private LocalDate exhbtnEndngDate;	//전시_종료_일자
	
}
