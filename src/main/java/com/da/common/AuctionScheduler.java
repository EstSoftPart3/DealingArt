package com.da.common;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.da.mapper.DealMapper;
import com.da.mapper.MemberMapper;
import com.da.mapper.MyPageMapper;
import com.da.util.CommonService;
import com.da.util.SendSmsUtil;
import com.da.vo.MbrInfoVo;

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
	
	@Autowired
	private MyPageMapper myPageMapper;
	
	//거래 종료된 경매 정보 가져와서 낙찰/거래종료로 10분마다 실행한다
	@Scheduled(cron="0 */10 * * * *")
	public void successfulBid() {
		//쿠폰 발급 중지
		Map<String, Object> cuponMap = new HashMap<String, Object>();
		cuponMap.put("cuponIdntfctnNum", "DAEVENING");
		cuponMap.put("endDate", "2022-11-01 00:00:00");
		myPageMapper.cuponStop(cuponMap);
		
		List<Map<String, Object>> successfulBidList = dealMapper.selectSuccessfulBidList(); //거래 종료 시간 만료한 경매 정보 가져오기
		List<Map<String, Object>> successfulSaleList = dealMapper.selectNotSoldSaleList(); //판매 종료 시간이 만료했지만 판매되지 않은 정찰가 거래 정보 가져오기
		MbrInfoVo mbrInfoVo = new MbrInfoVo();
		
		Map<String, Object> smsParam = new HashMap<String, Object>();
		Map<String, Object> updateParamMap = new HashMap<String, Object>();
		
		String bidDealSq;
		String bidBuyMbrSq;
		
		for(int i=0; i<successfulBidList.size(); i++) {
			bidDealSq = successfulBidList.get(i).get("dealSq").toString(); //거래 순번 가져오기
			bidBuyMbrSq = dealMapper.selectSuccessfulBidBuyMbrSq(bidDealSq); //거래 순번으로 낙찰자 가져오기
			if(bidBuyMbrSq != null) {
				
				updateParamMap.put("buyMbrSq", bidBuyMbrSq); //업데이트할 구매자 순번에 구매자 순번을 넣어준다
				updateParamMap.put("dealSbidPrc", successfulBidList.get(i).get("dealAuctnPrc").toString()); //업데이트할 낙찰 금액에 낙찰 금액을 넣어준다
				updateParamMap.put("dealFinalPrc", successfulBidList.get(i).get("dealAuctnPrc").toString()); //업데이트할 최종 금액에 낙찰 금액을 넣어준다
				updateParamMap.put("dealSq", successfulBidList.get(i).get("dealSq").toString()); //업데이트할 거래 순번에 거래 순번을 넣어준다
				dealMapper.updateSuccessfulBidDeal(updateParamMap); //딜 테이블을 거래종료 및 낙찰로 업데이트한다
				
				mbrInfoVo = memberMapper.mbrInfo(bidBuyMbrSq); //낙찰자 정보를 조회한다
				//회원전화번호
				smsParam.put("mbrCpNum", commonService.decrypt(mbrInfoVo.getMbrCpNum()).replaceAll("-", ""));
				//회원아이디
				smsParam.put("mbrId", commonService.decrypt(mbrInfoVo.getMbrId()));
				//회원활동명
				smsParam.put("mbrNcknm", mbrInfoVo.getMbrNcknm());
				//등록일시	
				smsParam.put("regDt", successfulBidList.get(i).get("dealStrtDt"));
				//낙찰일시
				smsParam.put("sBidDt", successfulBidList.get(i).get("dealEndngDt"));
				//작품명
				smsParam.put("workNm", successfulBidList.get(i).get("workNm"));
				//작품번호
				smsParam.put("workSq", successfulBidList.get(i).get("workSq"));
				//최종낙찰가
				smsParam.put("bidPrc", successfulBidList.get(i).get("dealAuctnPrc"));
				//대상코드 수정 중요@@@@
				smsParam.put("sndConCd", "SSA");
				
				sendSmsUtil.sendSmsProc(smsParam); //낙찰자에게 낙찰 알림 메세지를 보낸다
				
				mbrInfoVo = new MbrInfoVo();
				smsParam = new HashMap<String, Object>();
				mbrInfoVo = memberMapper.mbrInfo(successfulBidList.get(i).get("sellMbrSq").toString());
				//회원전화번호
				smsParam.put("mbrCpNum", commonService.decrypt(mbrInfoVo.getMbrCpNum()).replaceAll("-", ""));
				//회원아이디
				smsParam.put("mbrId", commonService.decrypt(mbrInfoVo.getMbrId()));
				//회원활동명
				smsParam.put("mbrNcknm", mbrInfoVo.getMbrNcknm());
				//등록일시	
				smsParam.put("regDt", successfulBidList.get(i).get("dealStrtDt"));
				//낙찰일시
				smsParam.put("sBidDt", successfulBidList.get(i).get("dealEndngDt"));
				//작품명
				smsParam.put("workNm", successfulBidList.get(i).get("workNm"));
				//작품번호
				smsParam.put("workSq", successfulBidList.get(i).get("workSq"));
				//최종낙찰가
				smsParam.put("bidPrc", successfulBidList.get(i).get("dealAuctnPrc"));
				//대상코드 수정 중요@@@@
				smsParam.put("sndConCd", "SSE");
				
				sendSmsUtil.sendSmsProc(smsParam); //판매자에게 낙찰 알림 메세지를 보낸다
				
				
				List<Map<String, Object>> auctioneer = dealMapper.selectAuctioneerByMbrSq(bidDealSq, bidBuyMbrSq); //유찰자를 조회한다
				for(int j=0; j<auctioneer.size(); j++) { //유찰자 만큼
					mbrInfoVo = memberMapper.mbrInfo(auctioneer.get(j).get("mbrSq").toString());
					//회원전화번호
					smsParam.put("mbrCpNum", commonService.decrypt(mbrInfoVo.getMbrCpNum()).replaceAll("-", ""));
					//회원아이디
					smsParam.put("mbrId", commonService.decrypt(mbrInfoVo.getMbrId()));
					//회원활동명
					smsParam.put("mbrNcknm", mbrInfoVo.getMbrNcknm());
					//작품명
					smsParam.put("workNm", successfulBidList.get(i).get("workNm"));
					//작품번호
					smsParam.put("workSq", successfulBidList.get(i).get("workSq"));
					//만료일시
					smsParam.put("dealEndngDt", successfulBidList.get(i).get("dealEndngDt"));
					//응찰일시
					smsParam.put("bidDt", auctioneer.get(j).get("bidDate"));
					//대상코드 수정 중요@@@
					smsParam.put("sndConCd", "SAE");
					
					sendSmsUtil.sendSmsProc(smsParam); //유찰자에게 경매종료 메세지를 보낸다
				}
			}else{
				
				dealMapper.updateFailedBidDeal(bidDealSq); //유찰된 거래 유찰 상태로 변경한다
				
				mbrInfoVo = memberMapper.mbrInfo(successfulBidList.get(i).get("sellMbrSq").toString()); //회원정보를 조회한다
				//회원전화번호
				smsParam.put("mbrCpNum", commonService.decrypt(mbrInfoVo.getMbrCpNum()).replaceAll("-", ""));
				//회원아이디
				smsParam.put("mbrId", commonService.decrypt(mbrInfoVo.getMbrId()));
				//회원활동명
				smsParam.put("mbrNcknm", mbrInfoVo.getMbrNcknm());
				//작품명
				smsParam.put("workNm", successfulBidList.get(i).get("workNm"));
				//작품번호
				smsParam.put("workSq", successfulBidList.get(i).get("workSq"));
				//만료일시
				smsParam.put("dealEndngDt", successfulBidList.get(i).get("dealEndngDt"));
				//대상코드 수정 중요@@@
				smsParam.put("sndConCd", "SREA");
				
				sendSmsUtil.sendSmsProc(smsParam); //판매자에게 판매종료 메세지를 보낸다
			}
		}
		
		for(int i=0; i<successfulSaleList.size(); i++) { //정찰가면서 판매 시간이 종료된 걸 조회한다
			
			dealMapper.updateFailedBidDeal(successfulSaleList.get(i).get("dealSq").toString()); //유찰된 거래 유찰 상태로 변경한다
			
			mbrInfoVo = memberMapper.mbrInfo(successfulSaleList.get(i).get("sellMbrSq").toString()); //회원정보를 조회한다
			//회원전화번호
			smsParam.put("mbrCpNum", commonService.decrypt(mbrInfoVo.getMbrCpNum()).replaceAll("-", ""));
			//회원아이디
			smsParam.put("mbrId", commonService.decrypt(mbrInfoVo.getMbrId()));
			//회원활동명
			smsParam.put("mbrNcknm", mbrInfoVo.getMbrNcknm());
			//작품명
			smsParam.put("workNm", successfulSaleList.get(i).get("workNm"));
			//작품번호
			smsParam.put("workSq", successfulSaleList.get(i).get("workSq"));
			//만료일시
			smsParam.put("dealEndngDt", successfulSaleList.get(i).get("dealEndngDt"));
			//대상코드 수정 중요@@@
			smsParam.put("sndConCd", "SRES");
			
			sendSmsUtil.sendSmsProc(smsParam); //판매자에게 판매종료 메세지를 보낸다
		}
	}

}
