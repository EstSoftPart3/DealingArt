package com.da.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="TBL_DA_COMN_DTL_CD_S")
public class ComnDtlCd {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DTL_CD_SQ", nullable=false)
	private Long dtlCdSq;	//상세_코드_순번
	
	@Column(name="CD_SQ", nullable=false)
	private Long cdSq;	//코드_순번
	
	@Column(name="DTL_CD", nullable=false, length=100)
	private String dtlCd;	//상세_코드
	
	@Column(name="DTL_CD_NM", nullable=false, length=200)
	private String dtlCdNm;	//상세_코드_명
	
	@Column(name="DTL_CD_ORD", nullable=false)
	private Long dtlCdOrd;	//상세_코드_순서
	
	@Column(name="DTL_CD_PRPRT_VAL1", length=300)
	private String dtlCdPrprtVal1;	//상세_코드_속성_값1
	
	@Column(name="DTL_CD_PRPRT_VAL2", length=300)
	private String dtlCdPrprtVal2;	//상세_코드_속성_값2
	
	@Column(name="DTL_CD_PRPRT_VAL3", length=300)
	private String dtlCdPrprtVal3;	//상세_코드_속성_값3
	
	@Column(name="NOTE", length=300)
	private String note;	//비고
	
	@Column(name="REG_MBR_SQ", nullable=false)
	private Long regMbrSq;	//등록_회원_순번
	
	@Column(name="REG_DT", nullable=false)
	private LocalDate regDt;	//등록_일시
	
	@Column(name="UPDT_MBR_SQ", nullable=false)
	private Long updtMbrSq;	//수정_회원_순번
	
	@Column(name="UPDT_DT", nullable=false)
	private LocalDate updtDt;	//수정_일시
	
	@Column(name="USE_YN", nullable=false, length=1)
	@ColumnDefault("'Y'")
	private String useYn;	//USE_YN
	
	@Column(name="DEL_YN", nullable=false, length=1)
	@ColumnDefault("'N'")
	private String delYn;	//삭제_여부
}
