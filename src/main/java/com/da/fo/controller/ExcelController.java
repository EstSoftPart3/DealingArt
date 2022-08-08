package com.da.fo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.da.mapper.ExcelMapper;
import com.da.util.CommonService;
import com.da.vo.OrderFormVo;

@Controller
public class ExcelController {
	
	@Autowired
	private ExcelMapper excelMapper;
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/oderFormDownload")
	@ResponseBody
	public ResponseEntity<InputStreamResource> oderFormDownload(HttpServletResponse response, @RequestParam Map<String, Object> param) throws IOException{
		
		System.out.println(param);
		
		 try (Workbook workbook = new XSSFWorkbook()) {
		 	//시트 생성
            Sheet sheet = workbook.createSheet("DA_발주서");
            int rowNo = 0;
            
            //첫번째 헤더 설정
            //헤더 스타일 폰트 설정
            CellStyle headStyle = workbook.createCellStyle();
            //헤더 배경색
            headStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //헤더 테두리
            headStyle.setBorderRight(BorderStyle.MEDIUM);
            headStyle.setBorderLeft(BorderStyle.MEDIUM);
            headStyle.setBorderTop(BorderStyle.MEDIUM);
            headStyle.setBorderBottom(BorderStyle.MEDIUM);
            Font font = workbook.createFont();
            //폰트 색상
            font.setColor(IndexedColors.BLACK.getIndex());
            //폰트 사이즈
            font.setFontHeightInPoints((short) 11);
            //폰트 굵기
            font.setBold(true);
            //폰트 설정
            headStyle.setFont(font);
            //폰트 정렬
            headStyle.setAlignment(HorizontalAlignment.CENTER); 
            //셀 생성
            Row headerRow = sheet.createRow(rowNo++);
            //셀 스타일 적용
            for(int i=0; i<35; i++) {
            	headerRow.createCell(i).setCellStyle(headStyle);
            }
            //셀 값 설정
            headerRow.getCell(0).setCellValue("발주 정보");
            headerRow.getCell(2).setCellValue("주문 정보");
            headerRow.getCell(8).setCellValue("운송 정보");
            headerRow.getCell(10).setCellValue("판매자 부가서비스");
            headerRow.getCell(11).setCellValue("구매자 부가서비스");
            headerRow.getCell(15).setCellValue("보험 발급");
            headerRow.getCell(17).setCellValue("작품 정보");
            headerRow.getCell(25).setCellValue("판매자 / 대리인");
            headerRow.getCell(30).setCellValue("구매자 / 대리인");
            sheet.setColumnWidth(10, 6144);
            //셀 병합
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1)); //첫행, 마지막행, 첫열, 마지막열( 0번째 행의 0~2번째 컬럼을 병합한다)
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 2, 7));
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 8, 9));
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 11, 14));
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 15, 16));
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 17, 24));
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 25, 29));
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 30, 34));
            
            
            //두 번째 헤더 설정
            //헤더 스타일 폰트 설정
            CellStyle headStyle2 = workbook.createCellStyle();
            //헤더 배경색
            headStyle2.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
            headStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //헤더 테두리
            headStyle2.setBorderRight(BorderStyle.THIN);
            headStyle2.setBorderLeft(BorderStyle.THIN);
            headStyle2.setBorderTop(BorderStyle.THIN);
            headStyle2.setBorderBottom(BorderStyle.THIN);
            Font font2 = workbook.createFont();
            //폰트 색상
            font2.setColor(IndexedColors.BLACK.getIndex());
            //폰트 사이즈
            font2.setFontHeightInPoints((short) 9);
            //폰트 굵기
            font2.setBold(true);
            //폰트 설정
            headStyle2.setFont(font2);
            //폰트 정렬
            headStyle2.setAlignment(HorizontalAlignment.CENTER); 
            //셀 스타일 설정
            Row headerRow2 = sheet.createRow(rowNo++);
            List<String> headerValue = Arrays.asList("발주 요청일", "상태", "주문번호", "작품번호", "주문일시", "작품가", "판매자 결제완료", "구매자 결제완료", "운송 구분", "운송 지역", "작업 할증", 
            		"설치", "포장", "조형", "작업할증", "보험발급", "보헙발급일", "작품명", "작가명", "제작년도", "사이즈", "기법", "이미지", "PCS", "보험가액", "이름", "연락처", "주소", "픽업일정", "특이사항", 
            		"이름", "연락처", "주소", "운송일정", "특이사항");
            //셀 값 설정
            for(int i=0; i<35; i++) {
            	headerRow2.createCell(i).setCellValue(headerValue.get(i));
            	headerRow2.getCell(i).setCellStyle(headStyle2);
            }
            sheet.setColumnWidth(2, 5120);
            sheet.setColumnWidth(4, 5120);
            sheet.setColumnWidth(5, 3072);
            sheet.setColumnWidth(6, 3096);
            sheet.setColumnWidth(7, 3096);
            sheet.setColumnWidth(8, 3072);
            sheet.setColumnWidth(17, 7168);
            sheet.setColumnWidth(18, 3072);
            sheet.setColumnWidth(20, 3072);
            sheet.setColumnWidth(21, 4096);
            sheet.setColumnWidth(22, 25840);
            sheet.setColumnWidth(26, 4096);
            sheet.setColumnWidth(27, 15360);
            sheet.setColumnWidth(31, 4096);
            sheet.setColumnWidth(32, 15360);
            //DB에서 발주 데이터 가져와서 넣기
//            param.put("dealSq", "28");
//            param.put("workSq", "204");
//            param.put("sellMbrSq", "151");
//            param.put("buyMbrSq", "297");
            OrderFormVo orderFormVo = excelMapper.oderFormDownload(param);
            CellStyle dataRowStyle = workbook.createCellStyle();
            dataRowStyle.setAlignment(HorizontalAlignment.CENTER); 
            Row dataRow = sheet.createRow(rowNo++);
            for(int i=0; i<35; i++) {
            	dataRow.createCell(i).setCellStyle(dataRowStyle);
            }
            setValue(sheet, "C3", orderFormVo.getMbrRefNo()); //주문번호
            setValue(sheet, "D3", orderFormVo.getWorkSq()); //작품번호
            setValue(sheet, "E3", orderFormVo.getPaymntDt()); //주문일시
            setValue(sheet, "F3", orderFormVo.getDealFinalPrc()); //작품가
            setValue(sheet, "G3", orderFormVo.getSellYn2PC()); //판매자 결제완료
            setValue(sheet, "H3", orderFormVo.getBuyYn2PC()); //구매자 결제완료
            setValue(sheet, "I3", orderFormVo.getTrnsprtTypNm()); //운송구분
            setValue(sheet, "J3", orderFormVo.getTrnsprtAreaNm()); //운송지역
            setValue(sheet, "K3", orderFormVo.getSellEC()); //판매자 작업할증
            setValue(sheet, "L3", orderFormVo.getBuyIS()); //구매자 설치
            setValue(sheet, "O3", orderFormVo.getBuyEC()); //구매자 작업할증
            setValue(sheet, "R3", orderFormVo.getWorkNm()); //작품명
            setValue(sheet, "S3", orderFormVo.getArtstActvtyNm()); //작가명
            setValue(sheet, "T3", orderFormVo.getWorkProdcYear()); //제작년도
            setValue(sheet, "U3", orderFormVo.getWorkSize()); //사이즈
            setValue(sheet, "V3", orderFormVo.getWorkMatrl()); //기법
            setValue(sheet, "W3", orderFormVo.getWorkMainImgUrl()); //이미지
            setValue(sheet, "Z3", orderFormVo.getSellMbrNm()); //판매자 이름
            setValue(sheet, "AA3", commonService.decrypt(orderFormVo.getSellMbrDelivryCpNum().toString())); //판매자 연락처
            setValue(sheet, "AB3", orderFormVo.getSellDelivryAddr()); //판매자 주소
            setValue(sheet, "AE3", orderFormVo.getBuyMbrNm()); //구매자 이름
            setValue(sheet, "AF3", commonService.decrypt(orderFormVo.getBuyMbrDelivryCpNum().toString())); //구매자 연락처
            setValue(sheet, "AG3", orderFormVo.getBuyDelivryAddr()); //구매자 이름
            
            //파일 이름 설정
            String fileName = "DA_발주서_" + orderFormVo.getMbrRefNo();
            fileName = URLEncoder.encode(fileName, "UTF-8");
	        
            File tmpFile = File.createTempFile("TMP~", ".xlsx");
            try (OutputStream fos = new FileOutputStream(tmpFile);) {
                workbook.write(fos);
            }
            InputStream res = new FileInputStream(tmpFile) {
                @Override
                public void close() throws IOException {
                    super.close();
                    if (tmpFile.delete()) {
                        System.out.println("임시 파일 삭제 완료");
                    }
                }
            };
 
            return ResponseEntity.ok() //
                    .contentLength(tmpFile.length()) //
                    .contentType(MediaType.APPLICATION_OCTET_STREAM) //
                    .header("Content-Disposition", "attachment;filename="+fileName+".xlsx") //
                    .body(new InputStreamResource(res));
 
        }
    }
	
	// 특정 셀에 특정 값 넣기
    private void setValue(Sheet sheet, String position, String value) {
        CellReference ref = new CellReference(position);
        Row r = sheet.getRow(ref.getRow());
        if (r != null) {
            Cell c = r.getCell(ref.getCol());
            c.setCellValue(value);
        }
    }
}
