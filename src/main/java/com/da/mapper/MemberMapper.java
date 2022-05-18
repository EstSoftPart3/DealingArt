package com.da.mapper;

import java.util.List;
import java.util.Map;

import com.da.vo.AutoLoginVo;
import com.da.vo.MbrInfoVo;

public interface MemberMapper {
	
	//회원 가입
	public void memberInsert(Map<String, Object> param);
	
	//회원 수정
	public void memberUpdate(Map<String, Object> param);
	
	//회원 아이디 중복 체크
	public List memberIdCheck(Map<String, Object> param);
	
	//회원 아이디 중복 체크
	public int memberInfoCount(Map<String, Object> param);
	
	//회원 상세
	public List memberContent(Map<String, Object> param);
		
	/*
	 * 로그인 기능
	 * param : loginId, loginPw
	 * return : HashMap
	 */
	public Map<String, Object> login(Map<String, Object> param);
	
	/*
	 * 로그인 아이디 체크
	 * param : loginId
	 * return : int
	 */
	public int loginIdCheck(Map<String, Object> param);
	
	/*
	 * 로그인 비밀번호 체크
	 * param : loginId, loginPw
	 * return : int
	 */
	public int loginPwdCheck(Map<String, Object> param);
	
	/*
	 * 아티스트 정보를 불러온다
	 * param : mbrSq
	 * return : Map
	 */
	public Map<String, Object> getArtistInfo(String param);
	
	/*
	 * 회원탈퇴
	 * param : name, email, password
	 * return : int
	 */
	public int memberWithdrawal(Map<String, Object> param);

	/*
	 * 회원탈퇴 체크
	 * param : name, email, password
	 * return : Map
	 */
	int memberWithdrawalCheck(Map<String, Object> param);
	
	
	//작가기본정보 등록
	public int authorInfoBaseInsert(Map<String, Object> param);
	
	//작가기본정보 수정
	public int authorInfoBaseUpdate(Map<String, Object> param);
	
	//작가기본정보 View
	public List authorBaseInfo(Map<String, Object> param);
	
	//작가기본정보 카운터
	public int authorBaseInfoCount(Map<String, Object> param);
	
	//작가학력정보 등록
	public int authorEduInfoInsert(Map<String, Object> param);
	
	//작가학력정보 수정
	public int authorEduInfoUpdate(Map<String, Object> param);
	
	//작가학력정보 리스트
	public List authorEduInfoList(Map<String, Object> param);
	
	//작가학력정보 삭제
	public int authorEduInfoDelete(Map<String, Object> param);
	
	//작가학력정보 등록유무 체크를 위한 카운터
	public int authorEduInfoCheckCount(Map<String, Object> param);
		
	//작가경력-경력 등록
	public int authorCareerInfoInsert(Map<String, Object> param);
	
	//작가경력 - 경력 리스트
	public List authorCarrerInfoList(Map<String, Object> param);
	
	//작가경력 - 경력 삭제
	public int authorCarrerInfoDelete(Map<String, Object> param);
	
	//작가경력 경력 수정
	public int authorCarrerInfoUpdate(Map<String, Object> param);
	
	//작가경력 경력 카운터
	public int authorCarrerInfoCheckCount(Map<String, Object> param);
	
	
	//작가 전시정보 등록
	public int authorExhbtnInfoInsert(Map<String, Object> param);
	
	//작가 전시정보 수정
	public int authorExhbtnInfoUpdate(Map<String, Object> param);
	
	//작가 전시정보 리스트
	public List authorExhbtnInfoList(Map<String, Object> param);
	
	//작가 전시정보 삭제
	public int authorExhbtnInfoDelete(Map<String, Object> param);
	
	//작가전시정보 등록유무 체크를 위한 카운터
	public int authorExhbtnInfoCheckCount(Map<String, Object> param);
	
	/*
	 * 회원 스크랩 추가
	 * param : 회원번호와 스크랩 작품 번호가 들어있는 Map
	 * return : int
	 */
	public int scrapAdd(Map<String, Object> param);
	
	/*
	 * 회원 스크랩 삭제
	 * param : 회원번호와 스크랩 작품 번호가 들어있는 Map
	 * return : int
	 */
	public int scrapDel(Map<String, Object> param);
	
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
	 * 회원 비밀번호 변경전 중복체크
	 * param : mbrId, mbrPasswrd
	 * return : int
	 */
	public int changePasswrdCheck(Map<String, Object> param);
	
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
