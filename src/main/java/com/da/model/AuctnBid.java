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
@Table(name="TBL_DA_AUCTN_BID_H")
public class AuctnBid {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BID_MBR_SQ", nullable=false)
	private Long bidMbrSq;	//응찰_회원_순번
	
	@Column(name="DEAL_SQ", nullable=false)
	private Long dealSq;	//경매_순번
	
	@Column(name="DEAL_TYP_CD", nullable=false, length=100)
	private String dealTypCd;	//거래_유형_코드
	
	@Column(name="DEAL_STTS_CD", nullable=false, length=100)
	private String dealSttsCd;	//거래_상태_코드
	
	
}
