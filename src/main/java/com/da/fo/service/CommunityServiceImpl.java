package com.da.fo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.fo.dao.CommunityDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	CommunityDao communityDao;

	@Override
	public Map<String, Object> searchHomeList() {
		return communityDao.searchHomeList();
	}

	@Override
	public Map<String, Object> showingOffDetail(Map<String, Object> param) {
		return communityDao.showingOffDetail(param);
	}

	@Override
	public Map<String, Object> searchEventList(Map<String, Object> param) {
		return communityDao.searchEventList(param);
	}

	/*
	 * 댓글, 대댓글 조회
	 */
	@Override
	public Map<String, Object> searchCmtsList(Map<String, Object> param) {
		return communityDao.searchCmtsList(param);
	}
	
	/*
	 * 커뮤니티 자랑하기 리스트 조회
	 * param : 
	 * return : 
	 */
	@Override
	public List<Map<String, Object>> communityListData(Map<String, Object> param) {
		List<Map<String, Object>> result = communityDao.communityWorksListData(param);
		return result;
	}

	/*
	 * 커뮤니티 페이지 총 개수 가져오기
	 * param : 
	 * return : 
	 */
	@Override
	public Map<String, Object> getCommunityTotalCount(Map<String, Object> param){
		Map<String, Object> totalCount = communityDao.getCommunityTotalCount(param);
		return totalCount;
	}
	
	/*
	 * 커뮤니티 전시후시/소개 공통코드 들고오기
	 * param : 
	 * return : 
	 */
	@Override
	public List<Map<String, Object>> getDtlCdNm(String cdSq) {
		List<Map<String, Object>> result = communityDao.getDtlCdNm(cdSq);
		return result;
	}
	
	/*
	 * 커뮤니티 전시후시/소개, 노하우 상세 정보 들고오기 
	 * param : 
	 * return : 
	 */
	public Map<String, Object> communityExhKnoDetail(String comtSq){
		Map<String, Object> result = communityDao.communityExhKnoDetail(comtSq);
		return result;
	}
	
}
