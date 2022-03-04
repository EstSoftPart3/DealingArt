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
@Table(name="TBL_DA_KEYWRD_S")
public class Keywrd {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="KEYWRD_SQ", nullable=false)
	private Long keywrdSq;	//키워드_순번
	
	@Column(name="KEYWRD", nullable=false, length=300)
	private String keywrd;	//키워드
	
	@Column(name="WORK_SQ", nullable=false)
	private Long workSq;	//작품_순번
}
