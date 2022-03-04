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
@Table(name="TBL_DA_ARTST_EDUCTN_S")
public class ArtistEducnt {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EDUCTN_SQ", nullable=false)
	private Long eductnSq; //학력_순번
	
	@Column(name="ARTST_SQ", nullable=false)
	private Long artistSq;	//작가_순번
	
	@Column(name="MBR_SQ", nullable=false)
	private Long mbrSq;	//회원_순번
	
	@Column(name="EDUCTN_NM", nullable=false, length=200)
	private String eductnNm;	//학력_명
	
	@Column(name="EDUCTN_MAJOR", length=200)
	private String eductnMajor;	//학력_전공
	
	@Column(name="EDUCTN_STRT_DATE")
	private LocalDate educntStrtDate; //학력_졸업(수료)_일자
	
	@Column(name="EDUCTN_ENDNG_DATE", nullable=false)
	private LocalDate educntEndngDate; //학력_종료_일자
	
}
