package com.da.fo.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.da.fo.dao.MemberDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService  {
	
	@Autowired
	MemberDao memberDao;
	
	//회원정보 입력
	@Override
	public void memberInsert(Map<String, Object> param){
		memberDao.memberInsert(param);
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
}
