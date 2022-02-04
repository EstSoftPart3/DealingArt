package com.da.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

import lombok.Data;

@Data
@Entity
@Table(name="tb_sample_borad")
@DynamicInsert
@DynamicUpdate
public class SampleBoard {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BNO", nullable=false)
	private int bNo;
	
	@Column(name="TITLE", nullable = false)
	private String bTitle;
	
	@Column(name="CONTENT", nullable = false)
	private String bContent;
	
	@Column(name="WRITER", nullable = false)
	private String bWriter;
	
	@CreatedDate
	@Column(name="REGDATE", nullable = false)
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime bRegDate;
	
	@Column(name="VIEWCNT", columnDefinition = "int default 0")
	private int bViewCnt;

}
