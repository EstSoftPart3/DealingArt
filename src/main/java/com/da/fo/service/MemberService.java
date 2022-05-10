package com.da.fo.service;

import java.util.Map;

import com.da.vo.AutoLoginVo;
import com.da.vo.MbrInfoVo;


public interface MemberService {
	
	//회원정보 등록
	public void memberInsert(Map<String, Object> param);
	
	//회원정보 수정
	public void memberUpdate(Map<String, Object> param);
	
	/*
	 * 로그인 기능
	 * param : loginId, loginPw
	 * return : int
	 */
	Map<String, Object> login(Map<String, Object> param);
	
	/*
	 * 아티스트 정보를 불러온다
	 * param : mbrSq
	 * return : Map
	 */
	Map<String, Object> getArtistInfo(String param);
	
	/*
	 * 회원탈퇴
	 * param : name, email, password
	 * return : int
	 */
	int memberWithdrawal(Map<String, Object> param);
	
	/*
	 * 회원탈퇴 체크
	 * param : name, email, password
	 * return : Map
	 */
	int memberWithdrawalCheck(Map<String, Object> param);
	
	
	//회원정보 상세	
	public Map<String, Object> memberContent(Map<String, Object> param);
	
	//회원정보 아이디 중복 체크
	public Map<String, Object> memberIdCheck(Map<String, Object> param);
	
	//회원정보 카운터
	public int memberInfoCount(Map<String, Object> param);
			
	//작가기본정보 등록
	public int authorInfoBaseSave(Map<String, Object> param);
	
	//작가기본정보
	public Map<String, Object> authorBaseInfoView(Map<String, Object> param);
		
	//작가학력정보 등록
	public int authorEduInfoSaveData(Map<String, Object> param);
	
	//작가학력정보 리스트
	public Map<String, Object> authorEduInfoList(Map<String, Object> param);
	
	//작가학력정보 삭제
	public int authorEduInfoDelete(Map<String, Object> param);
	
	//작가경력 등록
	public int authorCareerInfoSaveData(Map<String, Object> param);
	
	//작가 경력-경력 등록
	public Map<String, Object> authorCarrerInfoList(Map<String, Object> param);
	
	//작가 경력-경력 삭제
	public int authorCarrerInfoDelete(Map<String, Object> param);
	
	//작가 전시정보 등록/수정
	public int authorExhbtnInfoSaveData(Map<String, Object> param);
	
	//작가 전시정보 리스트
	public Map<String, Object> authorExhbtnInfoList(Map<String, Object> param);
	
	//작가 전시정보 삭제
	public int authorExhbtnInfoDelete(Map<String, Object> param);
	
	/*
	 * 회원 스크랩 추가
	 * param : 회원번호와 스크랩 작품 번호가 들어있는 Map
	 * return : int
	 */
	int scrapAdd(Map<String, Object> param);
	
	/*
	 * 회원 스크랩 삭제
	 * param : 회원번호와 스크랩 작품 번호가 들어있는 Map
	 * return : int
	 */
	int scrapDel(Map<String, Object> param);
	
	/*
	 * 회원 자동로그인 정보 수정
	 * param : 회원정보가 들어있는 AutoLoginVo
	 * return : null
	 */
	public void autoLogin(AutoLoginVo autoLoginVo);
	
	/*
	 * 자동로그인시 세션아이디로 회원 정보 가져오기
	 * param : sessionId
	 * return : null
	 */
	public AutoLoginVo getSessionId(String param);
	
	/*
	 * 회원 아이디 찾기
	 * param : mbrCpCertDi
	 * return : 회원 정보
	 */
	public Map<String, Object> findId(String param);
	
	/*
	 * 회원 중복체크
	 * param : mbrCpCertDi
	 * return : 회원 카운트
	 */
	public int memberDuplicateCheck(String param);
	
	/*
	 * 회원 비밀번호 변경
	 * param : mbrId, mbrPasswrd
	 * return : int
	 */
	public int changePasswrd(Map<String, Object> param);
	
	/*
	 * 회원 정보 
	 * param : mbrSq
	 * return : MbrInfoVo
	 */
	public MbrInfoVo mbrInfo(String param);
	
	/*
	 * 회원 배송 정보 수정
	 * param : mbrInfo
	 * return : int
	 */
	public int mbrDelivryAddrCor(Object param);

}
