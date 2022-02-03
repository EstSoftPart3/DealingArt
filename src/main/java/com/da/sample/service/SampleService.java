package com.da.sample.service;

import java.util.List;

import com.da.model.MemberEntity;
import com.da.model.SampleBoard;

public interface  SampleService{
	
	int sampleLogin(String memId, String memPw);
	
	List<SampleBoard> searchBoard();
	
	int insertMem(MemberEntity memberEntity);
	
	SampleBoard insertBoard(SampleBoard sampleBoard);
	
	SampleBoard selectBoard(SampleBoard sampleBoard);
}
