package com.da.vo;

import java.util.Date;

import lombok.Data;

@Data
public class AutoLoginVo {
	private String mbrSq;
	private String authSq;
	private String artstSq;
	private String artstActvtyNm;
	private String artstEnglsNm;
	private String artstBirthYear;
	private String autoLoginYn;
	private String autoLoginSsnId;
	private Date autoLoginDate;
}
