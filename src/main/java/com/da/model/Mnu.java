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
@Table(name="TBL_DA_MNU_M")

public class Mnu {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MNU_SQ", nullable=false)
	private Long mnuSq;	//메뉴_순번
	
	@Column(name="MNU_NM", nullable=false, length=200)
	private String mnuNm;	//메뉴_명
	
	@Column(name="MNU_URL", nullable=false, length=500)
	private String mnuUrl;	//메뉴_URL
	
	@Column(name="MNU_CLNUP_ORD", nullable=false)
	private Long mnuClnupOrd;	//메뉴_정렬_순서
	
	@Column(name="MNU_LVL", nullable=false)
	private Long mnuLvl;	//메뉴_레벨
	
	@Column(name="MNU_PARENT_SQ")
	private Long mnuParentSq;	//메뉴_부모_순번
	
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
	private String useYn;	//사용_여부
	
	@Column(name="DEL_YN", nullable=false, length=1)
	@ColumnDefault("'N'")
	private String delYn;	//삭제_여부
}
