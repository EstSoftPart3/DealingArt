package com.da.model;


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
@Table(name="TBL_DA_WORK_IMG_S")
public class WorkImg {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IMG_SQ", nullable=false)
	private Long imgSq;	//이미지_순번
	
	@Column(name="WORK_SQ", nullable=false)
	private Long workSq;	//작품_순번
	
	@Column(name="IMG_NM", nullable=false, length=200)
	private String imgNm;	//이미지_명
	
	@Column(name="IMG_URL", nullable=false, length=300)
	private String imgUrl;	//이미지_URL
	
	@Column(name="IMG_USE_YN", nullable=false, length=1)
	@ColumnDefault("'Y'")
	private String imgUseYn;	//이미지_사용_여부
	
	@Column(name="IMG_DEL_YN", nullable=false, length=1)
	@ColumnDefault("'N'")
	private String imgDelYn;	//이미지_삭제_여부

}
