package com.da.mapper;

import com.da.vo.OrderFormVo;

public interface ExcelMapper {
	/*
	 * 발주서 엑셀 다운로드
	 * PARAM : dealSq
	 * RETURN : 발주서 엑셀
	 */
	public OrderFormVo oderFormDownload(Object param);
}
