package com.da.model;	//

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="TBL_DA_ARTST_M")
public class Artst {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ARTST_SQ", nullable=false)
	private Long artistSq;	//작가_순번
	
	@Column(name="MBR_SQ", nullable=false)
	private Long mbrSq;	//회원_순번
	
	@Column(name="ARTST_ACTVTY_NM", nullable=false, length=100)
	private String artistActvtyNm;	//작가_활동_명
	
	@Column(name="ARTST_ENGLS_NM", nullable=false, length=100)
	private String artistEnglsNm;	//작가_영문_명
	
	@Column(name="ARTST_ACTVTY_PART_CD", length=100)
	private String artistActvtyPartCd;	//작가_활동_분야_코드
	
	@Column(name="ARTST_ACTVTY_CD", length=100)
	private String artistActvtyCd;	//작가_활동_지역_코드
	
	@Column(name="ARTST_SELF_INTRO", nullable=false)
	@Lob
	private String artistSelfIntro;	//작가_자기소개
	
	@Column(name="ARTST_PROFILE_IMG_URL", length=300)
	private String artistProfileImgUrl;	//작가_프로필_이미지_URL
	
	@Column(name="ARTST_HMPG_URL", length=300)
	private String artistHmpgUrl;	//작가_홈페이지_URL
	
	@Column(name="ARTST_PROMTN_VIDEO_URL", length=300)
	private String atritsPromtnVideoUrl;	//작가_홍보_영상_URL
	
	@Column(name="ARTST_FACEBOOK_ID", length=300)
	private String artistFacebookId;	//작가_페이스북_아이디
	
	@Column(name="ARTST_INSTAGRAM_ID", length=300)
	private String artistInstagramId;	//작가_인스타그램_아이디
	
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
