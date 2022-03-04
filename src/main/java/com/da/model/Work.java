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
@Table(name="TBL_DA_WORK_M")
public class Work {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="WORK_SQ", nullable=false)
	private Long workSq;	//작품_순번
	
	@Column(name="MBR_SQ", nullable=false)
	private Long mbrSq;	//회원_순번
	
	@Column(name="ARTST_SQ")
	private Long artistSq;	//작가_순번
	
	@Column(name="WORK_NM", nullable=false, length=200)
	private String workNm;	//작품_명
	
	@Column(name="WORK_SIZE_WIDTH", nullable=false,  length=50)
	private String workSizeWidth;	//작품_사이즈_가로
	
	@Column(name="WORK_SIZE_DEPTH", nullable=false,  length=50)
	private String workSizeDepth;	//작품_사이즈_세로
	
	@Column(name="WORK_SIZE_HEIGHT", nullable=false, length=50)
	private String workSizeHeight;	//작품_사이즈_높이
	
	@Column(name="WORK_SIZE_WEIGHT", nullable=false,  length=50)
	private String workSizeWeight;	//작품_사이즈_무게
	
	@Column(name="WORK_LAKE", nullable=false,  length=50)
	private String workLake;	//작품_호수
	
	@Column(name="WORK_MAIN_IMG_URL", nullable=false,  length=300)
	private String workMainImgUrl;	//작품_대표_이미지_URL
	
	@Column(name="WORK_FRM_IMG_URL", nullable=false,  length=300)
	private String workFrmImgUrl;	//작품_액자_이미지_URL
	
	@Column(name="WORK_MDIA", nullable=false,  length=150)
	private String workMdia;	//작품_메체
	
	@Column(name="WORK_PRODC_YEAR", nullable=false)
	private LocalDate workProdcYear;	//작품_제작_년도
	
	@Column(name="WORK_PRC", nullable=false)
	private Long workPrc;	//작품_가격
	
	@Column(name="WORK_SALE_YN", nullable=false, length=1)
	@ColumnDefault("'N'")
	private String workSaleYn;	//작품_판매_여부
	
	@Column(name="WORK_INTRDC", length=500)
	private String workIntrdc;	//작품_소개
	
	@Column(name="WORK_CLR_CD", length=100)
	private String workClrCd;	//작품_컬러_코드
	
	@Column(name="WORK_THM_CD", length=100)
	private String workThmCd;	//작품_테마_코드
	
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
