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
@Table(name="TBL_DA_MBR_M")
public class Mbr {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MBR_SQ", nullable=false)
	private Long mbrSq;	//회원_순번
	
	@Column(name="AUTH_SQ", nullable=false)
	private Long authSq;	//권한_순번
	
	@Column(name="MBR_ID", nullable=false, length=200)
	private String mbrId;	//회원_아이디
	
	@Column(name="MBR_EMAIL", nullable=false, length=200)
	private String mbrEmail;	//회원_이메일
	
	@Column(name="MBR_PASSWRD", nullable=false, length=500)
	private String mbrPasswrd;	//회원_비밀번호
	
	@Column(name="MBR_NM", nullable=false, length=200)
	private String mbrNm;	//회원_이름
	
	@Column(name="MBR_NCKNM", nullable=false, length=200)
	private String mbrNcknm;	//회원_닉네임
	
	@Column(name="MBR_NATN_CD", length=100)
	private String mbrNatnCd;	//회원_국가_코드
	
	@Column(name="MBR_BIRTH", nullable=false, length=500)
	private String mbrBirth;	//회원_생년월일
	
	@Column(name="MBR_SEX_CD", nullable=false, length=100)
	private String mbrSexCd;	//회원_성별_코드
	
	@Column(name="MBR_HOME_ADDR", length=500)
	private String mbrHomeAddr;	//회원_집_주소
	
	@Column(name="MBR_DELIVRY_ADDR", length=500)
	private String mbrDelivryAddr;	//회원_배송지_주소
	
	@Column(name="MBR_CP_NUM", nullable=false, length=100)
	private String mbrCpNum;	//회원_휴대폰_번호
	
	@Column(name="MBR_CP_CERT_YN", length=1)
	@ColumnDefault("'N'")
	private String mbrCpCertYn;	//회원_휴대폰_인증_여부
	
	@Column(name="MBR_CP_CERT_DATE")
	private LocalDate mbrCpCertDate;	//회원_휴대폰_인증_일자
	
	@Column(name="REG_MBR_SQ", nullable=false)
	private Long regMbrSq;	//등록_회원_순번
	
	@Column(name="REG_DT", nullable=false)
	private LocalDate regDt;	//등록_일시
	
	@Column(name="UPDT_MBR_SQ", nullable=false)
	private Long updtMbrSq;	//수정_회원_순번
	
	@Column(name="UPDT_DT", nullable=false)
	private LocalDate dpdtDt;	//수정_일시
	
	@Column(name="USE_YN", nullable=false, length=1)
	@ColumnDefault("'Y'")
	private String useYn;	//사용_여부
	
	@Column(name="DEL_YN", nullable=false, length=1)
	@ColumnDefault("'N'")
	private String delYn;	//삭제_여부

}
