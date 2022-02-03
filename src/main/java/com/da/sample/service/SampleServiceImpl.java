package com.da.sample.service;

import java.util.List;

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
	
	@Override
	public int sampleLogin(String memId, String memPw) {
		return sampleDao.sampleLogin(memId, memPw);
	}
	
	@Override
	public List<SampleBoard> searchBoard() {
		return sampleDao.searchBoard();
	}
	
	@Override
	public int insertMem(MemberEntity memberEntity) {
		return sampleDao.insertMem(memberEntity);
	}
	
	@Override
	public SampleBoard insertBoard(SampleBoard sampleBoard) {
		return sampleDao.inserBoard(sampleBoard);
	}
	
	@Override
	public SampleBoard selectBoard(SampleBoard sampleBoard) {
		return sampleDao.selectBoard(sampleBoard);
	}
}