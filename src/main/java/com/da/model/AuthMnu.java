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
@Table(name="TBL_DA_AUTH_MNU_R")
public class AuthMnu {
	
	@Column(name="AUTH_SQ", nullable=false)
	private Long authSq;	//권한_순번
	
	@Column(name="MNU_SQ", nullable=false)
	private Long mnuSq;	//메뉴_순번
}
