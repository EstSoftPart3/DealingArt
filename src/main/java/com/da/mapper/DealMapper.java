package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface DealMapper {
	/*
	 * 딜 페이지에서 검색 필터별로 검색 결과를 조회한다.
	 * param : searchOption
	 * return : 검색 결과
	 */
	public List dealSerach(Object param);

}