package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface ArtistWorkMapper {
	
	/* 작가 정보 리스트 */
	public List artistWorkList(Object param);
	
	/* 작가 정보 상세 */
	public List artistWorkDetail(Object param);
	
	/* 작가 작품 리스트 */
	public List workList(Object param);

}
