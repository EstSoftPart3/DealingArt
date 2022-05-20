package com.da.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.da.mapper.DealMapper;

@Component
public class AuctionScheduler {
	
	@Autowired
	private DealMapper dealMapper;
	
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
		}
	}
}
