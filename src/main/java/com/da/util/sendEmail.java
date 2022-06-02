package com.da.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.da.fo.service.MemberService;
import com.da.mapper.MemberMapper;

import com.da.mapper.NotiMapper;

@Component
public class sendEmail {
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private SendMailUtil sendMailUtil;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	NotiMapper NotiMapper;
	
	@Autowired
	MemberMapper memberMapper;
	
	//@RequestMapping("/emailSend")
		//@ResponseBody
		public String emailSendUtil(@RequestParam Map<String, Object> param) {
			
			Map<String, Object> result = new HashMap<>();
			
			Map<String, Object> rtnMap = new HashMap<String, Object>();
			Map<String, Object> tomap = new HashMap<String, Object>();
			List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
			Map<String, Object> params = new HashMap<String, Object>();
			
			String gubun = (String) param.get("gubun");
					
			result = memberService.memberContent(param);
			
			@SuppressWarnings({ "unchecked", "unused" })
			List<Map<String, Object>> memberContent = memberMapper.memberContent(param);
			
			String mbrId = commonService.decrypt((String) memberContent.get(0).get("mbrId"));
			String mbrNm = (String) memberContent.get(0).get("mbrNm");
			
			String title = null;
			String content_part = null;
			String content_head = null;
			
			
			//히스토리 테이블 카운터
			Map<String, Object> getParam = new HashMap<String, Object>();
			
			
			if(gubun.equals("EMI")) {
				
				//보낸티입
				String sndTyp = "E";
				//보낸 컨텐츠 코드
				String sndConCd = "EMI";
				
				getParam.put("sndTyp", sndTyp);
				getParam.put("sndConCd", sndConCd);
				getParam.put("mbrId", mbrId);
				getParam.put("sndAddress", mbrId);
			
			}
			
			if(gubun.equals("EAP")) {
				
				//보낸티입
				String sndTyp = "E";
				//보낸 컨텐츠 코드
				String sndConCd = "EAP";
				
				getParam.put("sndTyp", sndTyp);
				getParam.put("sndConCd", sndConCd);
				getParam.put("mbrId", mbrId);
				getParam.put("sndAddress", mbrId);
			
			}
					
			int notiCount = NotiMapper.notiCount(getParam);
			
			if(notiCount == 0) {
			
			//회원가입
		    if(gubun.equals("EMI")) {
		    	
		    	title = "딜링아트의 세계에 오신 걸 환영합니다.";
		    	
		    	
		    	content_head = "    <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; width:100%;max-width: 630px; clear: both; background: none;border:0;\" width=\"100%\">"
				+ "                                <tbody>"
				+ "                                    <tr>"
				+ "                                        <td style=\"padding: 15px 0 15px 0; line-height: 1.8; border-width: 0px;\">"
				+ "                                            <table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0px 5px;table-layout:fixed\" width=\"100%\">"
				+ "                                                <tbody>"
				+ "                                                    <tr>"
				+ "                                                        <td style=\"padding: 0px 10px;\" width=\"100%\">"
				+ "                                                            <div>"
				+ "                                                                <p style=\"text-align: justify; margin: 0px;width:100%\"><img src=\"https://s3.ap-northeast-2.amazonaws.com/img.stibee.com/54874_1650865649.png\" style=\"width: 100%; display: inline; vertical-align: bottom; max-width: 100%; border-width: 0px; border-color: initial; border-image: initial; text-align: justify;\" width=\"590\"></p>"
				+ "                                                            </div>"
				+ "                                                        </td>"
				+ "                                                    </tr>"
				+ "                                                </tbody>"
				+ "                                            </table>"
				+ "                                        </td>"
				+ "                                    </tr>"
				+ "                                </tbody>"
				+ "                            </table>"
				+ "                            <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; width:100%;max-width: 630px; clear: both; background: none; border:0;\" width=\"100%;\">"
				+ "                                <tbody>"
				+ "                                    <tr>"
				+ "                                        <td style=\"padding: 15px 0 15px 0; line-height: 10px; border-width: 0px;\">"
				+ "                                            <table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"table-layout:fixed;padding: 0px 5px;\" width=\"100%\">"
				+ "                                                <tbody>"
				+ "                                                    <tr>"
				+ "                                                        <td style=\"padding: 0px 15px; line-height: 10px;\" width=\"100%\">"
				+ "                                                            <div>"
				+ "                                                                <p style=\"text-align: justify; margin: 0px; width:100%\"><img src=\"https://s3.ap-northeast-2.amazonaws.com/img.stibee.com/11188_1599120912.png\" style=\"width: 100%; display: inline; vertical-align: bottom; max-width: 100%; border-width: 0px; border-color: initial; border-image: initial; text-align: justify;\" width=\"590\" loading=\"eager\"></p>"
				+ "                                                            </div>"
				+ "                                                        </td>"
				+ "                                                    </tr>"
				+ "                                                </tbody>"
				+ "                                            </table>"
				+ "                                        </td>"
				+ "                                    </tr>"
				+ "                                </tbody>"
				+ "                            </table>"
		    	+ "                            <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; width:100%;max-width: 630px; clear: both; background: none;border:0;\" width=\"100%\">"
				+ "                                <tbody>"
				+ "                                    <tr>"
				+ "                                        <td style=\"padding: 5px 0 5px 0; line-height: 1.8; border-width: 0px;font-size: 14px;\">"
				+ "                                            <table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0px 5px;\" width=\"100%\">"
				+ "                                                <tbody>"
				+ "                                                    <tr>"
				+ "                                                        <td class=\"stb-text-box\" style=\"padding: 0px 15px;mso-line-height-rule: exactly;line-height:1.8;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;word-break: break-word;font-size: 14px;font-family: AppleSDGothic, apple sd gothic neo, noto sans korean, noto sans korean regular, noto sans cjk kr, noto sans cjk, nanum gothic, malgun gothic, dotum, arial, helvetica, MS Gothic, sans-serif!important; color: #333333\" width=\"100%\">"
				+ "                                                            <div style=\"text-align: center; font-size: 18px;\">"
				+ "                                                                <span style=\"font-weight: bold;\">안녕하세요, "+ mbrNm +"님!&nbsp;</span>"
				+ "                                                            </div>"
				+ "                                                            <div style=\"text-align: center; font-size: 18px;\">"
				+ "                                                                <span style=\"font-weight: bold;\">딜링아트의 세계에 오신 걸 환영합니다.&nbsp;&nbsp;</span><br></div>"
				+ "                                                        </td>"
				+ "                                                    </tr>"
				+ "                                                </tbody>"
				+ "                                            </table>"
				+ "                                        </td>"
				+ "                                    </tr>"
				+ "                                </tbody>"
				+ "                            </table>";
				
		    	content_part = "<table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0px 5px;\" width=\"100%\">"
				+ "                <tbody>"
				+ "                    <tr>"
				+ "                        <td class=\"stb-text-box\" style=\"padding: 0px 15px;mso-line-height-rule: exactly;line-height:1.8;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;word-break: break-word;font-size: 14px;font-family: AppleSDGothic, apple sd gothic neo, noto sans korean, noto sans korean regular, noto sans cjk kr, noto sans cjk, nanum gothic, malgun gothic, dotum, arial, helvetica, MS Gothic, sans-serif!important; color: #333333\" width=\"100%\">"
				+ "                            <div style=\"text-align: center; color: rgb(51, 51, 51); font-size: 16px;\">"
				+ "                                <span style=\"font-weight: bold;\">딜링아트는 미술품 거래의 새로운 기준을 제시합니다.&nbsp;&nbsp;</span><br></div>"
				+ "                            <div style=\"text-align: center;\">"
				+ "                                <span style=\"color: rgb(51, 51, 51); font-family: AppleSDGothic, &quot;apple sd gothic neo&quot;, &quot;noto sans korean&quot;, &quot;noto sans korean regular&quot;, &quot;noto sans cjk kr&quot;, &quot;noto sans cjk&quot;, &quot;nanum gothic&quot;, &quot;malgun gothic&quot;, dotum, arial, helvetica, MS Gothic, sans-serif; font-style: normal;\"><br></span>"
				+ "                            </div>"
				+ "                            <div style=\"text-align: center;\">"
				+ "                                <span style=\"color: rgb(51, 51, 51); font-family: AppleSDGothic, &quot;apple sd gothic neo&quot;, &quot;noto sans korean&quot;, &quot;noto sans korean regular&quot;, &quot;noto sans cjk kr&quot;, &quot;noto sans cjk&quot;, &quot;nanum gothic&quot;, &quot;malgun gothic&quot;, dotum, arial, helvetica, MS Gothic, sans-serif; font-style: normal; font-weight: bold;\">□ 품격 있는 안심 서비스&nbsp;</span>"
				+ "                            </div>"
				+ "                            <div style=\"text-align: center; \">&nbsp;보증서 기반 거래, 프리미엄 운송 서비스를 제공합니다.&nbsp;</div>"
				+ "                            <div style=\"text-align: center; \"><br></div>"
				+ "                            <div style=\"text-align: center; \">"
				+ "                                <span style=\"font-weight: bold;\">□ 투명한 공개 경매&nbsp;</span>"
				+ "                            </div>"
				+ "                            <div style=\"text-align: center; \">실시간으로 경매 진행 현황을 확인할 수 있습니다.&nbsp;</div>"
				+ "                            <div style=\"text-align: center; \"><br></div>"
				+ "                            <div style=\"text-align: center; \">"
				+ "                                <span style=\"font-weight: bold;\">□ 온라인 다이렉트 결제 번거로운 과정은 이제 그만!&nbsp;</span>"
				+ "                            </div>"
				+ "                            <div style=\"text-align: center; \">온라인으로 간편하게 결제가 가능합니다.&nbsp;</div>"
				+ "                            <div style=\"text-align: center; \"><br></div>"
				+ "                            <div style=\"text-align: center; \">"
				+ "                                <span style=\"font-weight: bold;\">&nbsp;□ 다이어트 수수료&nbsp;</span>"
				+ "                            </div>"
				+ "                            <div style=\"text-align: center; \">거래 수수료의 거품을 빼고 합리적인 수수료를 제공합니다.&nbsp;</div>"
				+ "                            <div style=\"text-align: center; \"><br></div>"
				+ "                            <div style=\"text-align: center; \">&nbsp;<span style=\"font-weight: bold;\">□ 간편 판매 등록&nbsp;</span>"
				+ "                            </div>"
				+ "                            <div style=\"text-align: center; \">보증서만 업로드하면 딜링아트 에서 등록을 도와드립니다.&nbsp;<br></div>"
				+ "                        </td>"
				+ "                    </tr>"
				+ "                </tbody>"
				+ "            </table>";
		    	
		    }
		    
		    if(gubun.equals("EAP")) {
		    	
		    	title = "딜링아트 작가등록이 완료되었습니다.";
		    	content_head = "<img src=\"https://www.dealing-art.com/resources/img/logo.png\">";
		    	content_part = "<table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0px 5px;\" width=\"100%\">"
						+ "                <tbody>"
						+ "                    <tr>"
						+ "                        <td class=\"stb-text-box\" style=\"padding: 0px 15px;mso-line-height-rule: exactly;line-height:1.8;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;word-break: break-word;font-size: 14px;font-family: AppleSDGothic, apple sd gothic neo, noto sans korean, noto sans korean regular, noto sans cjk kr, noto sans cjk, nanum gothic, malgun gothic, dotum, arial, helvetica, MS Gothic, sans-serif!important; color: #333333\" width=\"100%\">"
						+ "                            <div style=\"text-align: center; color: rgb(51, 51, 51); font-size: 16px;\">"
						+ "                                <span style=\"font-weight: bold;\">딜링아트는 미술품 거래의 새로운 기준을 제시합니다.&nbsp;&nbsp;</span><br></div>"
						+ "                            <div style=\"text-align: center;\">"
						+ "                                <span style=\"color: rgb(51, 51, 51); font-family: AppleSDGothic, &quot;apple sd gothic neo&quot;, &quot;noto sans korean&quot;, &quot;noto sans korean regular&quot;, &quot;noto sans cjk kr&quot;, &quot;noto sans cjk&quot;, &quot;nanum gothic&quot;, &quot;malgun gothic&quot;, dotum, arial, helvetica, MS Gothic, sans-serif; font-style: normal;\"><br></span>"
						+ "                            </div>"
						+ "                            <div style=\"text-align: center; \">"+mbrId+"님의 작가등록이 완료 되었습니다.&nbsp;</div>"
						+ "                            <div style=\"text-align: center; \"><br></div>"
						+ "                            <div style=\"text-align: center; \">"
						+ "                                <span style=\"font-weight: bold;\">안녕하세요, "+mbrId+"님! </span>"
						+ "                            </div>"
						+ "                            <div style=\"text-align: center; \">신청하신 작가등록이 완료되었습니다.</div>"
						+ "                            <div style=\"text-align: center; \"><br></div>"
						+ "                            <div style=\"text-align: center; \">"
						+ "                                <span style=\"font-weight: bold;\">마이페이지에 활성화된 포트폴리오 메뉴에서 확인 가능합니다.</span>"
						+ "                            </div>"
						+ "                        </td>"
						+ "                    </tr>"
						+ "                </tbody>";
		    }
		    	
				//String content = "[인증번호] "+ serti +" 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
				String content = "<!DOCTYPE html>"
						+ "<html>"
						+ "    <head><meta content='width=device-width, initial-scale=1, maximum-scale=1' name='viewport'><meta charset='UTF-8'><style>"
						+ "            @media only screen and(max-width:640px) {"
						+ "                .stb-left-cell,"
						+ "                .stb-right-cell {"
						+ "                    max-width: 100% !important;"
						+ "                    width: 100% !important;"
						+ "                }"
						+ "                .stb-left-cell img,"
						+ "                .stb-right-cell img {"
						+ "                    width: 100%;"
						+ "                    height: auto;"
						+ "                }"
						+ "                .stb-left-cell > div {"
						+ "                    padding: 5px 10px !important;"
						+ "                    box-sizing: border-box;"
						+ "                }"
						+ "                .stb-right-cell > div {"
						+ "                    padding: 5px 10px !important;"
						+ "                    box-sizing: border-box;"
						+ "                }"
						+ "                .stb-cell-wrap {"
						+ "                    padding: 0 !important;"
						+ "                }"
						+ "                .stb-cell-wrap > tr > td {"
						+ "                    padding: 0 !important;"
						+ "                }"
						+ "                .stb-cell-wrap > tbody > tr > td {"
						+ "                    padding: 0 !important;"
						+ "                }"
						+ "                .stb-cell-wrap > tbody > tr > td.stb-text-box {"
						+ "                    padding: 0 10px !important;"
						+ "                }"
						+ "                .stb-left-cell > div.stb-text-box {"
						+ "                    padding: 5px 10px !important;"
						+ "                }"
						+ "                .stb-right-cell > div.stb-text-box {"
						+ "                    padding: 5px 10px !important;"
						+ "                }"
						+ "                .stb-container {"
						+ "                    width: 94% !important"
						+ "                }"
						+ "                .stb-container a {"
						+ "                    text-decoration: underline;"
						+ "                }"
						+ "                .stb-cta-only-wrap {"
						+ "                    padding: 10px 0 !important;"
						+ "                }"
						+ "            }"
						+ "        </style>"
						+ "    </head>"
						+ "    <body>"
						+ "        <div class=\"stb-container-full\" style=\"width:100%; padding:40px 0; background-color:#ffffff; margin: 0 auto;\">"
						+ "            <table class=\"stb-container\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" style=\"margin: 0px auto; width: 94%; max-width: 630px; background: rgb(255, 255, 255); border: 0px;\">"
						+ "                <tbody>"
						+ "                    <tr style=\"margin: 0;padding:0;\">"
						+ "                        <td style=\"width: 100%; max-width: 630px; margin: 0 auto; position: relative; border-spacing: 0; clear: both; border-collapse: separate;padding:0;overflow:hidden;_width:620px;\">"
						+ "                            <div style=\"height: 0px; max-height: 0px; border-width: 0px; border-color: initial; border-image: initial; visibility: hidden; line-height: 0px; font-size: 0px; overflow: hidden;display:none;\"></div>"
						+ content_head
						
						+ "                            <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; width:100%;max-width: 630px; clear: both; background: none;border:0;\" width=\"100%\">"
						+ "                                <tbody>"
						+ "                                    <tr>"
						+ "                                        <td style=\"padding: 20px 0 15px 0;line-height: 1.8; border-width: 0px;\">"
						+ "                                            <table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0px 0;\" width=\"100%\">"
						+ "                                                <tbody>"
						+ "                                                    <tr>"
						+ "                                                        <td style=\"padding: 0 0\">"
						+ "                                                            <div style=\"height: 0; background: none; padding: 0px; border-top-width:1px;border-top-style:dotted;border-top-color:#999999;margin:0 15px\"></div>"
						+ "                                                        </td>"
						+ "                                                    </tr>"
						+ "                                                </tbody>"
						+ "                                            </table>"
						+ "                                        </td>"
						+ "                                    </tr>"
						+ "                                </tbody>"
						+ "                            </table>"
						+ "                            <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; width:100%;max-width: 630px; clear: both; background: none;border:0;\" width=\"100%\">"
						+ "                                <tbody>"
						+ "                                    <tr>"
						+ "                                        <td style=\"padding: 15px 0 15px 0; line-height: 1.8; border-width: 0px;font-size: 14px;\">"
						+ content_part
						+ "                                        </td>"
						+ "                                    </tr>"
						+ "                                </tbody>"
						+ "                            </table>"
						
						+ "                            <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; width:100%;max-width: 630px; clear: both; background: none;border:0;\" width=\"100%\">"
						+ "                                <tbody>"
						+ "                                    <tr>"
						+ "                                        <td style=\"padding: 20px 0 15px 0;line-height: 1.8; border-width: 0px;\">"
						+ "                                            <table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0px 0;\" width=\"100%\">"
						+ "                                                <tbody>"
						+ "                                                    <tr>"
						+ "                                                        <td style=\"padding: 0 0\">"
						+ "                                                            <div style=\"height: 0; background: none; padding: 0px; border-top-width:1px;border-top-style:dotted;border-top-color:#999999;margin:0 15px\"></div>"
						+ "                                                        </td>"
						+ "                                                    </tr>"
						+ "                                                </tbody>"
						+ "                                            </table>"
						+ "                                        </td>"
						+ "                                    </tr>"
						+ "                                </tbody>"
						+ "                            </table>"
						+ "                            <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; width:100%;max-width: 630px; clear: both; background: none;border:0;\" width=\"100%\">"
						+ "                                <tbody>"
						+ "                                    <tr>"
						+ "                                        <td style=\"padding: 15px 0 15px 0; border-width: 0px;\">"
						+ "                                            <table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0px 5px;\" width=\"100%\">"
						+ "                                                <tbody>"
						+ "                                                    <tr>"
						+ "                                                        <td class=\"stb-text-box\" width=\"100%\" style=\"padding: 0px 10px;mso-line-height-rule: exactly;line-height:1.8;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;word-break: break-word;font-size: 12px;font-family: AppleSDGothic, apple sd gothic neo, noto sans korean, noto sans korean regular, noto sans cjk kr, noto sans cjk, nanum gothic, malgun gothic, dotum, arial, helvetica, MS Gothic, sans-serif!important;text-align: center; color: #606060\">"
						+ "                                                            <span style=\"color: rgb(153, 153, 153);\">맨션나인 주식회사</span><br><div>"
						+ "                                                                <span style=\"color: rgb(153, 153, 153);\">help@dealing-art.com</span>"
						+ "                                                            </div>"
						+ "                                                            <div>"
						+ "                                                                <span style=\"font-size: 12px; color: rgb(153, 153, 153);\">"
						+ "                                                                    <span style=\"font-size: 12px;\">주소:&nbsp;</span>"
						+ "                                                                    <span style=\"font-size: 12px; text-align: start;\">서울특별시 마포구 월드컵로28길 9 3층&nbsp;</span>"
						+ "                                                                </span>"
						+ "                                                                <span style=\"font-size: 14px; text-align: start;\"></span>"
						+ "                                                                <span style=\"color: rgb(153, 153, 153); font-size: inherit;\">전화번호: 070-4267-7371</span>"
						+ "                                                            </div>"
						+ "                                                            <div>"
						+ "                                                                <span style=\"color: rgb(153, 153, 153);\">"
						+ "                                                                    <a href=\"$%unsubscribe%$\" style=\"text-decoration: underline; color: rgb(153, 153, 153); display: inline;\" class=\" link-edited\" target=\"_blank\">수신거부</a>&nbsp;<a href=\"$%unsubscribe%$\" style=\"text-decoration: underline; color: rgb(153, 153, 153); display: inline;\" class=\" link-edited\" target=\"_blank\">Unsubscribe</a>"
						+ "                                                                </span>"
						+ "                                                                <b></b>"
						+ "                                                            </div>"
						+ "                                                        </td>"
						+ "                                                    </tr>"
						+ "                                                </tbody>"
						+ "                                            </table>"
						+ "                                        </td>"
						+ "                                    </tr>"
						+ "                                </tbody>"
						+ "                            </table>"
						+ "                        </td>"
						+ "                    </tr>"
						+ "                </tbody>"
						+ "            </table>"
						+ "        </div>"
						+ "    </body>"
						+ "</html>";
		    
			

				//String memberEmail = "swordbass.j3@gmail.com";
				
				tomap.put("type", "R");
				tomap.put("address", mbrId);
				mList.add(tomap);
				
				params.put("title", title);
				params.put("body", content);
				//params.setContent(content, "text/html; charset=UTF-8");
				params.put("recipients", mList);
				
				rtnMap = sendMailUtil.sendMail(params);
				
				
				if(notiCount == 0) {
					//히스토리 저장
					NotiMapper.notiInsert(getParam);
				}
				
				
			}
				
				return title;
				
		}

}
