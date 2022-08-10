package com.da.fo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.ListUtils;

import com.da.mapper.ArtistMapper;
import com.da.mapper.DealMapper;
import com.da.mapper.MemberMapper;
import com.da.util.CommonService;
import com.da.vo.MbrInfoVo;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class DealDao {
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	private DealMapper dealMapper;
	
	@Autowired
	private ArtistMapper artistMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private CommonService commonService;
	
	/*
	 * 딜 페이지에서 검색 필터별로 검색 결과를 조회한다.
	 * param : searchOption
	 * return : 검색 결과
	 */
	public List dealSerach(Map<String, Object> searchOptions){
		return dealMapper.dealSerach(searchOptions);
	}
	
	/*
	 * 딜 상세 페이지 (응찰하기)
	 * param : workSq
	 * return : 딜 상세 정보
	 */
	public Map<String, Object> dealDetail(String param){
		Map<String, Object> deal = dealMapper.dealDetail(param);
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> artistInfo = new HashMap<>();
		List<Map<String, Object>> auctnBid = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> eductn = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> career = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> exhbtn = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> exhbtnAword = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> workList = new ArrayList<Map<String,Object>>();
		result.put("deal", deal);
		if(deal.get("artstSq") == null){
			result.put("auctnBid", auctnBid);
			result.put("artistInfo", artistInfo);
			result.put("eductn", eductn);
			result.put("career", career);
			result.put("exhbtn", exhbtn);
			result.put("exhbtnAword", exhbtnAword);
			result.put("workList", workList);
			return result;
		}else{
			artistInfo = artistMapper.artistInfo(deal.get("artstSq").toString());
			auctnBid = dealMapper.selectAuctnBidList(deal.get("dealSq").toString());
			eductn = artistMapper.artistInfoEductn(deal.get("artstSq").toString());
			career = artistMapper.artistInfoCareer(deal.get("artstSq").toString());
			exhbtn = artistMapper.artistInfoExhbtn(deal.get("artstSq").toString());
			exhbtnAword = artistMapper.artistInfoExhbtnAword(deal.get("artstSq").toString());
			workList = artistMapper.artistWorkListAll(deal.get("artstSq").toString());
			result.put("auctnBid", auctnBid);
			result.put("artistInfo", artistInfo);
			result.put("eductn", eductn);
			result.put("career", career);
			result.put("exhbtn", exhbtn);
			result.put("exhbtnAword", exhbtnAword);
			result.put("workList", workList);
			return result;
		}
	}
	
	/*
	 * 거래등록
	 * param : 거래 정보가 담긴 Map
	 * return : int
	 */
	public int dealReg(Object param) {
		int suspension = dealMapper.selectDealSttsCd(param);
		if(suspension > 0) {
			return -1;
		}else{
			int dealCount = dealMapper.dealRegOverlapChk(param);
			if(dealCount > 0) {
				return -2;
			}
			int result = dealMapper.dealReg(param);
			if(result > 0) {
				int result2 = dealMapper.updateMbrRefNo();
				return result2;
			}
		}
		return 0;
	}
	
	/*
	 * 거래수정
	 * param : 거래 정보가 담긴 Map
	 * return : int
	 */
	public int dealMod(Object param) {
		int dealSttsCd = dealMapper.selectDealSttsCd(param);
		if(dealSttsCd > 0) {
			return -1;
		}else{
			int result = dealMapper.dealReg(param);
			result += dealMapper.updateMbrRefNo();
			return result;
		}
	}
	
	/*
	 * 응찰 테이블에 응찰 정보 insert
	 * param : dealSq, mbrSq, bidPrc
	 * return : int
	 */
	public int bidReg(Map<String, Object> param) {
		if(param.get("autoBidPrc") != null) { //자동응찰이면
			int check = dealMapper.checkAutoBid(param);
			if(check > 0){
				return 9;
			}else {
				dealMapper.insertAutoBid(param); //자동응찰 테이블에 등록한다
				int autoBidResult = autoBid(param);
				if(autoBidResult != -1) { //자동응찰 실패가 아니면
					if(autoBidResult == 0) { //자동응찰이 성공적으로 등록 되었으면
						return 10;
					}
					if(autoBidResult == 1) { //자동응찰이 성공적으로 등록 되었지만 더 높은 응찰자가 있으면
						return 11;
					}
					if(autoBidResult == 2) { //자동응찰이며 같은 금액으로 자동응찰 내역이 있으며 자동응찰 일시가 늦으면
						return 12;
					}
				}
				return -11;
			}
		}else{	
			int checkResult = dealMapper.bidRegCheck(param); //응찰가 현재 응찰가보다 낮거나 같으면
			if(checkResult > 0) {
				return -1; //-1를 리턴해준다
			}else{ //응찰가 현재 응찰가보다 높으면
				int regResult = dealMapper.bidReg(param); //응찰내역에 추가한다
				regResult += dealMapper.updateDealAuctnPrc(param); //딜 테이블에 응찰 금액을 업데이트해준다
				autoBid(param); //자동응찰
				return regResult;
			}
		}
	}
	
	/*
	 * 자동응찰 내역이 있으면 자동응찰을 실행한다.
	 * param : dealSq, mbrSq, bidPrc
	 * return : null
	 */
	public int autoBid(Map<String, Object> param) {
		List<Map<String, Object>> result = dealMapper.selectAutoBid(param);
		if(!ListUtils.isEmpty(result)) {
			Map<String, Object> paramMap = new HashMap<>();
			if(result.size() > 1) {
				long bidPrc = Long.parseLong(param.get("bidPrc").toString());
				bidPrc += askingPrice(bidPrc);
				param.put("bidPrc", bidPrc);
				int regResult = dealMapper.bidReg(param); //응찰내역에 추가한다
				regResult += dealMapper.updateDealAuctnPrc(param); //딜 테이블에 응찰 금액을 업데이트해준다
				long autoBidPrc1 = Long.parseLong(result.get(0).get("autoBidPrc").toString());
				long autoBidPrc2 = Long.parseLong(result.get(1).get("autoBidPrc").toString());
				if(autoBidPrc1 == autoBidPrc2) {
					if(Integer.parseInt(param.get("mbrSq").toString()) == Integer.parseInt(result.get(1).get("mbrSq").toString())){
						loop :
						for(int j=0; j<30; j++) {
							for(int i=0; i<result.size(); i++) {
								bidPrc += askingPrice(bidPrc);
								if(bidPrc > autoBidPrc1) {
									break loop;
								}
								paramMap.put("mbrSq", result.get(i).get("mbrSq"));
								paramMap.put("dealSq", result.get(i).get("dealSq"));
								paramMap.put("bidPrc", bidPrc);
								dealMapper.bidReg(paramMap);
								
							}
							dealMapper.updateDealAuctnPrc(paramMap);
						}
						paramMap.put("mbrSq", result.get(0).get("mbrSq").toString());
						dealMapper.updateLastBid(paramMap);
						return 2;
					}
				}else{
				loop :
					for(int j=0; j<30; j++) {
						for(int i=0; i<result.size(); i++) {
							if(bidPrc >= autoBidPrc1) {
								break loop;
							}
							bidPrc += askingPrice(bidPrc);
							paramMap.put("mbrSq", result.get(i).get("mbrSq"));
							paramMap.put("dealSq", result.get(i).get("dealSq"));
							paramMap.put("bidPrc", bidPrc);
							dealMapper.bidReg(paramMap);
						}
						dealMapper.updateDealAuctnPrc(paramMap);
					}
				return 1;
				}
			}else{
				long bidPrc = Long.parseLong(param.get("bidPrc").toString());
				bidPrc += askingPrice(bidPrc);
				param.put("bidPrc", bidPrc);
				int regResult = dealMapper.bidReg(param); //응찰내역에 추가한다
				regResult += dealMapper.updateDealAuctnPrc(param); //딜 테이블에 응찰 금액을 업데이트해준다
				return 0;
			}
		}
		return -1;
	}
	
	/*
	 * 호가를 계산해서 리턴해준다.
	 * param : bidPrc
	 * return : long
	 */
	public long askingPrice(long prc){
		long returnVal = 0;
		if (prc > 0 && prc < 300000) {
			returnVal = 20000;
		}
		if (prc >= 300000 && prc < 1000000) {
			returnVal = 50000;
		}
		if (prc >= 1000000 && prc < 3000000) {
			returnVal = 100000;
		}
		if (prc >= 3000000 && prc < 5000000) {
			returnVal = 200000;
		}
		if (prc >= 5000000 && prc < 10000000) {
			returnVal = 500000;
		}
		if (prc >= 10000000 && prc < 30000000) {
			returnVal = 1000000;
		}
		if (prc >= 30000000 && prc < 50000000) {
			returnVal = 2000000;
		}
		if (prc >= 50000000 && prc < 200000000) {
			returnVal = 5000000;
		}
		if (prc >= 200000000 && prc < 500000000) {
			returnVal = 10000000;
		}
		if (prc >= 500000000) {
			returnVal = 20000000;
		}
		return returnVal;
	}
	
	/*
	 * 작품 상세 페이지 (미판매)
	 * param : workSq
	 * return : 작품 상세 정보
	 */
	public Map<String, Object> workDetail(String param){
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> work = dealMapper.workDetail(param);
 		Map<String, Object> artistInfo = new HashMap<>();

		result.put("work", work);
		if(work.get("artstSq") != null) {
			artistInfo = artistMapper.artistInfo(work.get("artstSq").toString());
			List eductn = artistMapper.artistInfoEductn(work.get("artstSq").toString());
			List career = artistMapper.artistInfoCareer(work.get("artstSq").toString());
			List exhbtn = artistMapper.artistInfoExhbtn(work.get("artstSq").toString());
			List exhbtnAword = artistMapper.artistInfoExhbtnAword(work.get("artstSq").toString());
			List workList = artistMapper.artistWorkListAll(work.get("artstSq").toString());
			result.put("artistInfo", artistInfo);
			result.put("eductn", eductn);
			result.put("career", career);
			result.put("exhbtn", exhbtn);
			result.put("exhbtnAword", exhbtnAword);
			result.put("workList", workList);
		} else {
			result.put("artistInfo", artistInfo);
			return result;

			
		}
		return result;
	}
	
	/*
	 * 거래 정보 가져오기 (거래 수정)
	 * param : dealSq
	 * return : deal 테이블
	 */
	public Map<String, Object> selectDeal(Object param){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> deal = dealMapper.selectDeal(param);
		MbrInfoVo mbrInfo = memberMapper.mbrInfo(deal.get("sellMbrSq").toString());
		mbrInfo.setMbrDelivryCpNum(commonService.decrypt(mbrInfo.getMbrDelivryCpNum()));
		Map<String, Object> work = dealMapper.selectWork(deal.get("workSq").toString());
		result.put("deal", deal);
		result.put("mbrInfo", mbrInfo);
		result.put("work", work);
		
		return result;
	}
	/*
	 * 거래 중단하기 (거래 삭제)
	 * param : dealSq
	 * return : int
	 */
	public int bidSuspension(Object param){
		int suspension = dealMapper.selectDealSttsCd(param);
		int result = 0;
		if(suspension > 0) {
			return -1;
		}else{
			result = dealMapper.deleteDeal(param);
			return result;
		}
	}
}
