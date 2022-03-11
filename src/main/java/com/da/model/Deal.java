package com.da.model;

import java.math.BigDecimal;

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
@Table(name="TBL_DA_DEAL_M")
public class Deal {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DEAL_SQ", nullable=false)
	private Long dealSq;	//경매_순번
	
	@Column(name="WORK_SQ", nullable=false)
	private Long workSq;	//작품_순번
	
	@Column(name="MBR_SQ", nullable=false)
	private Long mbrSq;	//회원_순번
	
	@Column(name="ARTST_SQ")
	private Long artistSq;	//작가_순번
	
	@Column(name="DEAL_TYP_CD", nullable=false, length=100)
	private String dealTypCd;	//거래_유형_코드
	
	@Column(name="DEAL_STTS_CD", nullable=false, length=100)
	private String dealSttsCd;	//거래_상태_코드
	
	@Column(name="DEAL_STRT_PRC", nullable=false)
	private BigDecimal dealStrtPrc;	//거래_시작_가격
	
	@Column(name="DEAL_AUCTN_PRC", nullable=false)
	private BigDecimal dealAuctnPrc;	//거래_응찰_가격
	
	@Column(name="DEAL_SBID_PRC", nullable=false)
	private BigDecimal dealSbidPrc;	//거래_낙찰_가격
	
}
