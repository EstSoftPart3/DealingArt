package com.da.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.da.mapper.DealMapper;
import com.da.mapper.MemberMapper;
import com.da.util.CommonService;
import com.da.util.SendSmsUtil;

@Component
public class AuctionScheduler {
	
	@Autowired
	private DealMapper dealMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private SendSmsUtil sendSmsUtil;
	
	//거래 종료된 경매 정보 가져와서 낙찰/거래종료로 10분마다 실행한다
	@Scheduled(cron="0 */10 * * * *")
	public void successfulBid () {
		List<Map<String, Object>> successfulBidList = dealMapper.selectSuccessfulBidList(); //거래 종료 시간 만료한 경매 정보 가져오기
		Map<String, Object> updateParamMap = new HashMap<>();
		String dealSq;
		String buyMbrSq;
		for(int i=0; i<successfulBidList.size(); i++) {
			dealSq = successfulBidList.get(i).get("dealSq").toString(); //거래 순번 가져오기
			buyMbrSq = dealMapper.selectSuccessfulBidBuyMbrSq(dealSq); //거래 순번으로 낙찰자 가져오기
			updateParamMap.put("buyMbrSq", buyMbrSq); //업데이트할 구매자 순번에 구매자 순번을 넣어준다
			updateParamMap.put("dealSbidPrc", successfulBidList.get(i).get("dealAuctnPrc").toString()); //업데이트할 낙찰 금액에 낙찰 금액을 넣어준다
			updateParamMap.put("dealFinalPrc", successfulBidList.get(i).get("dealAuctnPrc").toString()); //업데이트할 최종 금액에 낙찰 금액을 넣어준다
			updateParamMap.put("dealSq", successfulBidList.get(i).get("dealSq").toString()); //업데이트할 거래 순번에 거래 순번을 넣어준다
			dealMapper.updateSuccessfulBidDeal(updateParamMap); //딜 테이블을 거래종료 및 낙찰로 업데이트한다
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("mbrSq", buyMbrSq);
			List<Map<String, Object>> memberContent = memberMapper.memberContent(param); //낙찰자 조회한다
			//회원전화번호
			param.put("mbrCpNum", commonService.decrypt((String)memberContent.get(0).get("mbrCpNum")).replace("-", ""));
			//회원아이디
			param.put("mbrId", commonService.decrypt((String) memberContent.get(0).get("mbrId")));
			//회원이름
			param.put("mbrNm", memberContent.get(0).get("mbrNm"));
			//등록일시	
			param.put("regDt", memberContent.get(0).get("regDt"));
			//낙찰일시
			param.put("sBidDt", memberContent.get(0).get("sBidDt"));
			//작품명
			param.put("workNm", memberContent.get(0).get("workNm"));
			//최종낙찰가
			param.put("bidPrc", memberContent.get(0).get("bidPrc"));
			//만료일시
			param.put("dealEndngDt", memberContent.get(0).get("dealEndngDt"));
			//응찰일시
			param.put("bidDt", memberContent.get(0).get("bidDt"));
			//대상코드 수정 중요@@@@@
			param.put("sndConCd", "SSA");
						
			sendSmsUtil.sendSmsProc(param); //낙찰자에게 낙찰 알림 메세지를 보낸다
			
			List<Map<String, Object>> auctioneer = dealMapper.selectAuctioneerByMbrSq(dealSq); //유찰자를 조회한다
			for(int j=0; j<auctioneer.size(); j++) { //유찰자 만큼
				Map<String, Object> param2 = new HashMap<String, Object>();
				param2.put("mbrSq", buyMbrSq);
				List<Map<String, Object>> memberContent2 = memberMapper.memberContent(param2);
				//회원전화번호
				param2.put("mbrCpNum", commonService.decrypt((String)memberContent2.get(i).get("mbrCpNum")).replace("-", ""));
				//회원아이디
				param2.put("mbrId", commonService.decrypt((String) memberContent2.get(i).get("mbrId")));
				//회원이름
				param2.put("mbrNm", memberContent2.get(i).get("mbrNm"));
				//등록일시	
				param2.put("regDt", memberContent2.get(i).get("regDt"));
				//낙찰일시
				param2.put("sBidDt", memberContent2.get(i).get("sBidDt"));
				//작품명
				param2.put("workNm", memberContent2.get(i).get("workNm"));
				//최종낙찰가
				param2.put("bidPrc", memberContent2.get(i).get("bidPrc"));
				//만료일시
				param2.put("dealEndngDt", memberContent2.get(i).get("dealEndngDt"));
				//응찰일시
				param2.put("bidDt", memberContent2.get(i).get("bidDt"));
				//대상코드 수정 중요@@@@
				param2.put("sndConCd", "SAE");
							
				sendSmsUtil.sendSmsProc(param); //유찰자에게 경매종료 메세지를 보낸다
			}
		}
	}
}
