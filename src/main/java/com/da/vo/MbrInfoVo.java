package com.da.vo;

import lombok.Data;

@Data
public class MbrInfoVo {
	private String mbrSq;
	private String authSq;
	private String mbrId;
	private String mbrEmail;
	private String mbrPasswrd;
	private String mbrNm;
	private String mbrNcknm;
	private String mbrBirth;
	private String mbrSexCd;
	private String mbrHomeAddr;
	private String mbrDelivryAddr;
	private String mbrDelivryCpNum;
	private String mbrCpNum;
	private String mbrCpCertYn;
	private String mbrCpCertDate;
	private String regMbrSq;
	private String regDt;
	private String updtMbrSq;
	private String updtDt;
	private String useYn;
	private String delYn;
	private String mbrEmlAlarm;
	private String mbrCpAlarm;
	private String mbrSocialSort;
	private String autoLoginYn;
	private String autoLoginSsnId;
	private String autoLoginDate;
	private String mbrCpCertDi;
	private String mbrAccountNo;
	private String mbrBankCd;
	private String mbrBankNm;
}
