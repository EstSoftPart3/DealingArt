package com.da.fo.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.da.fo.dao.MemberDao;
import com.da.vo.AutoLoginVo;
import com.da.vo.MbrInfoVo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService  {
	
	@Autowired
	MemberDao memberDao;
	
	//회원정보 입력
	@Override
	public int memberInsert(Map<String, Object> param){
		int insertState = -1;
		insertState = memberDao.memberInsert(param);
		return insertState;
	}
	
	//회원정보 입력
	@Override
	public void memberUpdate(Map<String, Object> param){
		memberDao.memberUpdate(param); 
	}
	
	/*
	 * 로그인 기능
	 * param : loginId, loginPw
	 * return : int
	 */
	public Map<String, Object> login(Map<String, Object> param) {
		return memberDao.login(param);
	}
	
	/*
	 * 아티스트 정보를 불러온다
	 * param : mbrSq
	 * return : Map
	 */
	public Map<String, Object> getArtistInfo(String param){
		return memberDao.getArtistInfo(param);
	}

	/*
	 * 회원탈퇴
	 * param : name, email, password
	 * return : int
	 */
	public int memberWithdrawal(Map<String, Object> param) {
		return memberDao.memberWithdrawal(param);
	}
	
	/*
	 * 회원탈퇴 체크
	 * param : name, email, password
	 * return : Map
	 */
	public int memberWithdrawalCheck(Map<String, Object> param){
		return memberDao.memberWithdrawalCheck(param);
	}
	
	//회원정보 상세
	@Override
	public Map<String, Object> memberContent(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = memberDao.memberContent(param);
		
		return result;
	}
	
	//회원정보 아이디 중복 체크
	@Override
	public Map<String, Object> memberIdCheck(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = memberDao.memberIdCheck(param);
		
		return result;
	}
	
	public int memberInfoCount(Map<String, Object> param) {
		int result = -1;
		
		result = memberDao.memberInfoCount(param);
		
		return result;
	}
	
	//작가기본정보 등록
	@Override
	public int authorInfoBaseSave(Map<String, Object> param){
		int saveState = -1;
		saveState = memberDao.authorInfoBaseSave(param);
		return saveState; 
	}
	
	//작가기본정보 VIEW
	@Override
	public Map<String, Object> authorBaseInfoView(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = memberDao.authorBaseInfoView(param);
		
		return result;
		
	}
	
	//작가학력정보 등록/수정
	@Override
	public int authorEduInfoSaveData(Map<String, Object> param){
		int saveState = -1;
		saveState = memberDao.authorEduInfoSaveData(param);
		return saveState; 
	}
	
	//작가학력정보
	@Override
	public Map<String, Object> authorEduInfoList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = memberDao.authorEduInfoList(param);
		
		return result;
	}
	
	//작가학력정보 삭제
	@Override
	public int authorEduInfoDelete(Map<String, Object> param){
		int deleteState = -1;
		deleteState = memberDao.authorEduInfoDelete(param);
		return deleteState; 
	}
	
	//작가경력정보 등록
	@Override
	public int authorCareerInfoSaveData(Map<String, Object> param){
		int saveState = -1;
		saveState = memberDao.authorCareerInfoSaveData(param);
		return saveState; 
	}
	
	//작가경력-경력 리스트
	@Override
	public Map<String, Object> authorCarrerInfoList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = memberDao.authorCarrerInfoList(param);
		
		return result;
	}
	
	//작가경력 - 경력 삭제
	@Override
	public int authorCarrerInfoDelete(Map<String, Object> param){
		int deleteState = -1;
		deleteState = memberDao.authorCarrerInfoDelete(param);
		return deleteState; 
	}
	
	//작가전시정보 등록/수정
	@Override
	public int authorExhbtnInfoSaveData(Map<String, Object> param){
		int saveState = -1;
		saveState = memberDao.authorExhbtnInfoSaveData(param);
		return saveState; 
	}
	
	//작가전시정보 - 리스트
	@Override
	public Map<String, Object> authorExhbtnInfoList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = memberDao.authorExhbtnInfoList(param);
		
		return result;
	}
	
	//작가전시정보 삭제
	@Override
	public int authorExhbtnInfoDelete(Map<String, Object> param){
		int deleteState = -1;
		deleteState = memberDao.authorExhbtnInfoDelete(param);
		return deleteState; 
	}
	
	/*
	 * 회원 스크랩 추가
	 * param : 회원번호와 스크랩 작품 번호가 들어있는 Map
	 * return : int
	 */
	public int scrapAdd(Map<String, Object> param) {
		return memberDao.scrapAdd(param);
	}
	
	/*
	 * 회원 스크랩 삭제
	 * param : 회원번호와 스크랩 작품 번호가 들어있는 Map
	 * return : int
	 */
	public int scrapDel(Map<String, Object> param) {
		return memberDao.scrapDel(param);
	}
	
	/*
	 * 회원 자동로그인 정보 수정
	 * param : 회원정보가 들어있는 AutoLoginVo
	 * return : null
	 */
	public void autoLogin(AutoLoginVo autoLoginVo) {
		memberDao.autoLogin(autoLoginVo);
	}
	
	/*
	 * 자동로그인시 세션아이디로 회원 정보 가져오기
	 * param : sessionId
	 * return : null
	 */
	public AutoLoginVo getSessionId(String param) {
		return memberDao.getSessionId(param);
	}
	
	/*
	 * 회원 아이디 찾기
	 * param : mbrCpCertDi
	 * return : 회원 정보
	 */
	public Map<String, Object> findId(String param){
		return memberDao.findId(param);
	}
	
	/*
	 * 회원 중복체크
	 * param : mbrCpCertDi
	 * return : 회원 카운트
	 */
	public int memberDuplicateCheck(String param) {
		return memberDao.memberDuplicateCheck(param);
	}
	
	/*
	 * 회원 비밀번호 변경
	 * param : mbrId, mbrPasswrd
	 * return : int
	 */
	public int changePasswrd(Map<String, Object> param) {
		return memberDao.changePasswrd(param);
	}
	
	/*
	 * 회원 정보 
	 * param : mbrSq
	 * return : MbrInfoVo
	 */
	public MbrInfoVo mbrInfo(String param) {
		return memberDao.mbrInfo(param);
	}
	
	/*
	 * 회원 배송 정보 수정
	 * param : mbrInfo
	 * return : int
	 */
	public int mbrDelivryAddrCor(Object param) {
		return memberDao.mbrDelivryAddrCor(param);
	}
	
	/*
	 * 회원 활동명 중복체크
	 * param : mbrInfo
	 * return : int
	 */
	public int selectMbrNcknmCount(Object param) {
		return memberDao.selectMbrNcknmCount(param);
	}

}
