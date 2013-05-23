package yy.excelutil.reportout;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import yy.excelutil.common.Constants;
import yy.excelutil.pojo.WeekAllocInfoPoJo;

/*
 * 每周配货情况汇报
 */
public class WeekAllocInfoReport extends Report {

    public void writeReport(List<WeekAllocInfoPoJo> weekAllocInfoPoJoList, Workbook wb) throws Exception {

        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i < weekAllocInfoPoJoList.size(); i++) {
            WeekAllocInfoPoJo weekAllocInfoPoJo = weekAllocInfoPoJoList.get(i);
            Row row = sheet.createRow(i + 3);
            int j = 0;
            Cell cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(weekAllocInfoPoJo.getDate());// 日期
            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(weekAllocInfoPoJo.getDestPort());// 目的港
            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(weekAllocInfoPoJo.getHblNo());// HB/L
            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(weekAllocInfoPoJo.getLclWeight());// lcl rt
            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(weekAllocInfoPoJo.getTwenty());// 20‘
            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(weekAllocInfoPoJo.getForty());// 40‘
            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(weekAllocInfoPoJo.getFreightRate());// 运价
            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(weekAllocInfoPoJo.getCnyRate());// 人民币收费
            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(weekAllocInfoPoJo.getStowageCompany());// 配载公司
        }
    }

    public static void main(String[] arg) throws Exception {
        WeekAllocInfoReport weekAllocInfoReport = new WeekAllocInfoReport();
        Workbook wb = weekAllocInfoReport.readFile(Constants.WEEKALLOCINFO_TEMPLATE);

        OriDataReport oriDataReport = new OriDataReport();
        Workbook wbRd = oriDataReport.readFile(Constants.WEEKALLOCINFO_DATA);
        // 数据校验
        boolean flag = weekAllocInfoReport.checkDataPos(wbRd);
        if (!flag) {
            System.out.println(Constants.WARN_CHANGE_EXCEL);
        }
        List<WeekAllocInfoPoJo> weekAllocInfoPoJoList = oriDataReport.getWeekAllocInfoPoJoList(wbRd);
        oriDataReport.closeFile();
        //
        // List<WeekAllocInfoPoJo> weekAllocInfoPoJoList = new
        // ArrayList<WeekAllocInfoPoJo>();
        // WeekAllocInfoPoJo weekAllocInfoPoJo = new WeekAllocInfoPoJo();
        // weekAllocInfoPoJo.setDate("日期");
        // weekAllocInfoPoJo.setDestPort("目的港");
        // weekAllocInfoPoJo.setHblNo("HB/L");
        // weekAllocInfoPoJo.setLclWeight("lcl rt");
        // weekAllocInfoPoJo.setTwenty("20‘");
        // weekAllocInfoPoJo.setForty("40‘");
        // weekAllocInfoPoJo.setFreightRate("运价");
        // weekAllocInfoPoJo.setCnyRate("人民币收费");
        // weekAllocInfoPoJo.setStowageCompany("配载公司");
        // weekAllocInfoPoJoList.add(weekAllocInfoPoJo);
        weekAllocInfoReport.writeReport(weekAllocInfoPoJoList, wb);
        weekAllocInfoReport.writeFile(Constants.OUTPUT_PATH);
    }
}
