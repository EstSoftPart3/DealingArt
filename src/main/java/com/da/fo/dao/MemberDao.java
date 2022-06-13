package com.da.fo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.da.mapper.MemberMapper;
import com.da.util.CommonService;
import com.da.vo.AutoLoginVo;
import com.da.vo.MbrInfoVo;
import com.querydsl.jpa.impl.JPAQueryFactory;




@Repository
public class MemberDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	MemberMapper memberMapper;
	
	//회원정보 수정
	public void memberUpdate(Map<String, Object> param){
		
		System.out.println("FO_MEMBER_UPDATE_REQUEST = " + param);
		memberMapper.memberUpdate(param);
		
	}
	
	//회원정보 입력
	public int memberInsert(Map<String, Object> param){
		
		System.out.println("FO_MEMBER_INSERT_REQUEST = " + param);
		
		int insertState = -1;
		
		insertState = memberMapper.memberInsert(param);
		
		return insertState;
		
	}
	
	/*
	 * 로그인 기능
	 * param : loginId, loginPw
	 * return : int
	 */
	public Map<String, Object> login(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<>();
		int idCheck = memberMapper.loginIdCheck(param); //회원 아이디 체크
		if(idCheck > 0) { //아이디 체크 성공하면
			int pwdCheck = memberMapper.loginPwdCheck(param); //회원 비밀번호 체크
			if(pwdCheck > 0) { //비밀번호 체크 성공하면
				result = memberMapper.login(param); //로그인 정보를 가져온다
				result.put("error", "none"); //오류없음
				return result;
			}else{
				result.put("error", "nonPwd"); //패스워드가 안맞는다
				return result;
			}
		}else{
			result.put("error", "nonId"); //아이디가 안맞는다
			return  result;
		}
	}
	
	/*
	 * 아티스트 정보를 불러온다
	 * param : mbrSq
	 * return : Map
	 */
	public Map<String, Object> getArtistInfo(String param){
		return memberMapper.getArtistInfo(param);
	}
	
	/*
	 * 회원탈퇴
	 * param : name, email, password
	 * return : int
	 */
	public int memberWithdrawal(Map<String, Object> param) {
		return memberMapper.memberWithdrawal(param);
	}
	
	/*
	 * 회원탈퇴 체크
	 * param : name, email, password
	 * return : Map
	 */
	public int memberWithdrawalCheck(Map<String, Object> param){
		return memberMapper.memberWithdrawalCheck(param);
	}
	
	//회원정보 상세
	public Map<String, Object> memberContent(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("MEMBER_CONTENT_REQUEST = " + param);
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> memberContent = memberMapper.memberContent(param);
		
		for(int z=0; z<memberContent.size(); z++){
		 	
			 //아이디 복호화
			 String mbrIdDecrypt = commonService.decrypt((String) memberContent.get(z).get("mbrId"));
			 //비밀번호 복호화
			 String mbrPasswrdDecrypt = commonService.decrypt((String) memberContent.get(z).get("mbrPasswrd"));
			 //이메일 복호화
			 String mbrEmailDecrypt = commonService.decrypt((String) memberContent.get(z).get("mbrEmail"));
			 //휴대전화번호 복호화
			 String mbrCpNumDecrypt = commonService.decrypt((String) memberContent.get(z).get("mbrCpNum"));
			 //집주소 복호화
			 String mbrHomeAddrDecrypt = commonService.decrypt((String) memberContent.get(z).get("mbrHomeAddr"));
			 //이메일 이벤트 알림
			 String mbrEmlAlarm = (String) memberContent.get(z).get("mbrEmlAlarm");
			 //휴대폰 이벤트 알림
			 String mbrCpAlarm = (String) memberContent.get(z).get("mbrCpAlarm");
			 //닉네임
			 String mbrNcknm = (String) memberContent.get(z).get("mbrNcknm");
			 
						
			 memberContent.get(z).put("mbrId", mbrIdDecrypt);
			 memberContent.get(z).put("mbrPasswrd", mbrPasswrdDecrypt);
			 memberContent.get(z).put("mbrEmail", mbrEmailDecrypt);
			 memberContent.get(z).put("mbrCpNum", mbrCpNumDecrypt);
			 memberContent.get(z).put("mbrHomeAddr", mbrHomeAddrDecrypt);
			 memberContent.get(z).put("mbrEmlAlarm", mbrEmlAlarm);
			 memberContent.get(z).put("mbrCpAlarm", mbrCpAlarm);
			 memberContent.get(z).put("mbrNcknm", mbrNcknm);
			 
		  }
		
		result.put("memberContent", memberContent);
		
		return result;
	}
	
	//회원정보 아이디.닉네임 중복 체크
	public Map<String, Object> memberIdCheck(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("MEMBER_CHECK_REQUEST = " + param);
		List memberIdCheck = memberMapper.memberIdCheck(param);
		
		result.put("memberIdCheck", memberIdCheck);
		
		return result;
	}
	
	//회원정보 아이디.닉네임 중복 체크
	public int memberInfoCount(Map<String, Object> param){
		
		int memberInfoCount = memberMapper.memberInfoCount(param);
		
		return memberInfoCount;
	}
	
	//작가정보 등록
	public int authorInfoBaseSave(Map<String, Object> param){
		
		int saveState = -1;
		
		System.out.println("FO_AUTHOR_INFO_BASE_SAVE_REQUEST = " + param);
		
		
		int authorInfoBaseCount = memberMapper.authorBaseInfoCount(param);
		
		if(authorInfoBaseCount == 0) {
			saveState = memberMapper.authorInfoBaseInsert(param);
		} else {
			saveState = memberMapper.authorInfoBaseUpdate(param);
		}
				 
		return saveState;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> authorBaseInfoView(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("AUTHOR_BASE_INFO_VIEW = " + param);
		
		List<Map<String, Object>> baseInfo = memberMapper.authorBaseInfo(param);
		
		result.put("baseInfo", baseInfo);
				
		return result;
	}
	
	//작가학력정보 등록/수정
	public int authorEduInfoSaveData(Map<String, Object> param){
		
		int saveState = -1;
		
		Map<String, Object> getParam = new HashMap<>();
		
		String eductnSq = (String) param.get("eductnSq");
		getParam.put("eductnSq", eductnSq);
		
		int authorEudInfoCheckCount = memberMapper.authorEduInfoCheckCount(getParam);
		
		if(authorEudInfoCheckCount == 0) {
			saveState = memberMapper.authorEduInfoInsert(param);
		} else {
			saveState = memberMapper.authorEduInfoUpdate(param);
		}
			 
		return saveState;
	}
	
	//작가학력정보 리스트
	public Map<String, Object> authorEduInfoList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> eduInfo = memberMapper.authorEduInfoList(param);
		
		result.put("eduInfo", eduInfo);
				
		return result;
	}
	
	//작가학력정보 삭제
	public int authorEduInfoDelete(Map<String, Object> param){
		
		int deleteState = -1;
				
		deleteState = memberMapper.authorEduInfoDelete(param);
			 
		return deleteState;
	}
	
	//작가경력정보 등록 / 수정
	public int authorCareerInfoSaveData(Map<String, Object> param){
		
		int saveState = -1;
		
		Map<String, Object> getParam = new HashMap<>();
		
		String careerSq = (String) param.get("careerSq");
		getParam.put("careerSq", careerSq);
		
		int authorCarrerInfoCheckCount = memberMapper.authorCarrerInfoCheckCount(getParam);
		
		if(authorCarrerInfoCheckCount == 0) {
			saveState = memberMapper.authorCareerInfoInsert(param);
		} else {
			saveState = memberMapper.authorCarrerInfoUpdate(param);
		}
		
	  return saveState;
	}

	//작가 경력 - 경력 리스트 authorCarrerInfoList
	public Map<String, Object> authorCarrerInfoList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> carrerInfo = memberMapper.authorCarrerInfoList(param);
		
		result.put("carrerInfo", carrerInfo);
				
		return result;
	}
	
	//작가경력 - 경력 삭제
	public int authorCarrerInfoDelete(Map<String, Object> param){
		
		int deleteState = -1;
				
		deleteState = memberMapper.authorCarrerInfoDelete(param);
			 
		return deleteState;
	}
	
	//작가 전시정보 등록 / 수정
	public int authorExhbtnInfoSaveData(Map<String, Object> param){
		
		int saveState = -1;
		
		Map<String, Object> getParam = new HashMap<>();
		
		String exhbtnSq = (String) param.get("exhbtnSq");
		getParam.put("exhbtnSq", exhbtnSq);
		
		int authorExhbtnInfoCheckCount = memberMapper.authorExhbtnInfoCheckCount(getParam);
		
		if(authorExhbtnInfoCheckCount == 0) {
			saveState = memberMapper.authorExhbtnInfoInsert(param);
		} else {
			saveState = memberMapper.authorExhbtnInfoUpdate(param);
		}
		
	  return saveState;
	}
	
	//작가 전시정보 개인전,단체전
	public Map<String, Object> authorExhbtnInfoList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> exhbtnInfo = memberMapper.authorExhbtnInfoList(param);
		
		result.put("exhbtnInfo", exhbtnInfo);
				
		return result;
	}
	
	//작가전시정보 삭제
	public int authorExhbtnInfoDelete(Map<String, Object> param){
		
		int deleteState = -1;
				
		deleteState = memberMapper.authorExhbtnInfoDelete(param);
			 
		return deleteState;
	}
	
	/*
	 * 회원 스크랩 추가
	 * param : 회원번호와 스크랩 작품 번호가 들어있는 Map
	 * return : int
	 */
	public int scrapAdd(Map<String, Object> param) {
		return memberMapper.scrapAdd(param);
	}
	
	/*
	 * 회원 스크랩 삭제
	 * param : 회원번호와 스크랩 작품 번호가 들어있는 Map
	 * return : int
	 */
	public int scrapDel(Map<String, Object> param) {
		return memberMapper.scrapDel(param);
	}
	
	/*
	 * 회원 자동로그인 정보 수정
	 * param : 회원정보가 들어있는 AutoLoginVo
	 * return : null
	 */
	public void autoLogin(AutoLoginVo autoLoginVo) {
		memberMapper.autoLogin(autoLoginVo);
	}
	
	/*
	 * 자동로그인시 세션아이디로 회원 정보 가져오기
	 * param : sessionId
	 * return : null
	 */
	public AutoLoginVo getSessionId(String param) {
		return memberMapper.getSessionId(param);
	}
	
	/*
	 * 회원 아이디 찾기
	 * param : mbrCpCertDi
	 * return : 회원 정보
	 */
	public Map<String, Object> findId(String param){
		return memberMapper.findId(param);
	}
	
	/*
	 * 회원 중복체크
	 * param : mbrCpCertDi
	 * return : 회원 카운트
	 */
	public int memberDuplicateCheck(String param) {
		return memberMapper.memberDuplicateCheck(param);
	}
	
	/*
	 * 회원 비밀번호 변경
	 * param : mbrId, mbrPasswrd
	 * return : int
	 */
	public int changePasswrd(Map<String, Object> param) {
		int result = memberMapper.changePasswrdCheck(param);
		if(result > 0) {
			return -1;
		}else {
			return memberMapper.changePasswrd(param);
		}
	}
	
	/*
	 * 회원 정보 
	 * param : mbrSq
	 * return : MbrInfoVo
	 */
	public MbrInfoVo mbrInfo(String param) {
		return memberMapper.mbrInfo(param);
	}
	
	/*
	 * 회원 배송 정보 수정
	 * param : mbrInfo
	 * return : int
	 */
	public int mbrDelivryAddrCor(Object param) {
		return memberMapper.mbrDelivryAddrCor(param);
	}
	
	/*
	 * 회원 활동명 중복체크
	 * param : mbrInfo
	 * return : int
	 */
	public int selectMbrNcknmCount(Object param) {
		return memberMapper.selectMbrNcknmCount(param);
	}

}
