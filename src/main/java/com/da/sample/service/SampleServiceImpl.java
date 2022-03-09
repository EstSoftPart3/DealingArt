package com.da.sample.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.da.model.MemberEntity;
import com.da.model.SampleBoard;
import com.da.repository.MemberEntityRepository;
import com.da.sample.dao.SampleDao;

@Service
@AllArgsConstructor
public class SampleServiceImpl implements SampleService{
	
	@Autowired
	private SampleDao sampleDao;
	
	@Autowired
	MemberEntityRepository memberEntityRepository;
	
	/*
	 * 로그인 기능
	 * param : 화면에서 입력한 회원아이디, 회원패스워드
	 * return : 검색조건으로 조회된 row의 count
	 */
	@Override
	public int sampleLogin(String memId, String memPw) {
		return sampleDao.sampleLogin(memId, memPw);
	}
	
	/*
	 * 게시물 목록 조회 기능
	 * param : null
	 * return : 전체 게시물이 조회된 List
	 */
	@Override
	public Map<String, Object> searchBoard(Map<String, Object> param) {
		return sampleDao.searchBoard(param);
	}
	
	/*
	 * 새로운 회원 정보 저장 기능
	 * param : 입력한 회원정보가 들어있는 VO
	 * return : 성공 여부를 숫자로 보낸다
	 */
	@Override
	public int insertMem(MemberEntity memberEntity) {
		return sampleDao.insertMem(memberEntity);
	}
	
	/*
	 * 작성한 게시물을 저장하는 기능
	 * param : 입력한 게시물 정보가 들어있는 VO
	 * return : 저장된 게시물 정보가 들어있는 VO
	 */
	@Override
	public SampleBoard insertBoard(SampleBoard sampleBoard) {
		return sampleDao.inserBoard(sampleBoard);
	}
	
	/*
	 * 게시물 목록중 하나의 게시물을 선택해서 조회하는 기능
	 * param : 목록 중 해당하는 row의 정보가 들어있는 VO
	 * return : 조회된 게시물의 정보가 들어있는 VO
	 */
	@Override
	public SampleBoard selectBoard(SampleBoard sampleBoard) {
		return sampleDao.selectBoard(sampleBoard);
	}
	
	@Override
	public int deleteBoard(String bNo) {
		return sampleDao.deleteBoard(bNo);
	}
}