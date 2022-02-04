package com.da.mapper;

import java.util.List;

public interface SampleMapper {
	public int sampleLogin(String memId, String memPw);
	
	public List searchBoard();
	
	public void insertBoard(Object Object);
}
