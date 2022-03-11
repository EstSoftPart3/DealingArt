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
@Table(name="TBL_DA_AUCTN_BID_H")
public class AuctnBid {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BID_SQ", nullable=false)
	private Long bidSq;	//응찰_순번
	
	@Column(name="BID_MBR_SQ", nullable=false)
	private Long bidMbrSq;	//응찰_회원_순번
	
	@Column(name="DEAL_SQ", nullable=false)
	private Long dealSq;	//경매_순번
	
	@Column(name="BID_PRC", nullable=false)
	private BigDecimal bidPrc;	//응찰_가격
	
	
}
