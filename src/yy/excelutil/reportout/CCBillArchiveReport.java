package yy.excelutil.reportout;

import java.util.List;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;

import yy.excelutil.common.Constants;
import yy.excelutil.pojo.CCBillArchivePoJo;

/*
 * customs clearance
 * 报关单据存档表
 */
public class CCBillArchiveReport extends Report {

    public void writeReport(List<CCBillArchivePoJo> ccBillArchivePoJoList, Workbook wb) throws Exception {
        // readFile(this.resourceBundle.getString(Constants.CCBILLARCHIVE_TEMPLATE));

        Font headerFont = wb.createFont(); // 字体
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headerFont.setFontHeight((short) 220);
        headerFont.setFontName("宋体");

        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setFont(headerFont);
        // cellStyle.setWrapText(true);
        Sheet sheet = wb.getSheetAt(0);
        int i = 0;
        for (; i < ccBillArchivePoJoList.size(); i++) {
            CCBillArchivePoJo ccBillArchivePoJo = ccBillArchivePoJoList.get(i);
            Row row = sheet.createRow(i + 1);
            Cell cell = row.createCell(0);
            cell.setCellValue(i + 1);// 序号
            cell.setCellStyle(cellStyle);
            cell = row.createCell(1);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getSailDate());// 开船日
            cell = row.createCell(2);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getCabinNo());// 进舱号
            cell = row.createCell(3);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getBillNo());// 提单号
            cell = row.createCell(4);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getDestPort());// 目的港
            cell = row.createCell(5);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getShipName());// 船名航次
            cell = row.createCell(6);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getShipCompany());// 经营单位
            cell = row.createCell(7);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getCooperateCompany());// 往来单位
            cell = row.createCell(8);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getCustomBroker());// 报关行
            cell = row.createCell(9);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getTrackNo());// 寄报关行快递单号
            cell = row.createCell(10);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getOperater());// 操作
            cell = row.createCell(11);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getCustomNo());// 海关编号
            cell = row.createCell(12);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getBackDate());// 退回公司日期
            cell = row.createCell(13);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getRejectFlag());// 是否可退单
            cell = row.createCell(14);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getRejectDate());// 退单日期
            cell = row.createCell(15);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ccBillArchivePoJo.getRejectSign());// 退单签收
        }
        // 加载下拉列表内容
        DVConstraint constraint = DVConstraint.createFormulaListConstraint("BGH");// LIST NAME
        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(1, i, 8, 8);
        // 数据有效性对象
        HSSFDataValidation data_validation_list = new HSSFDataValidation(regions, constraint);
        sheet.addValidationData(data_validation_list);
    }

    public static void main(String[] arg) throws Exception {
        CCBillArchiveReport ccBillArchiveReport = new CCBillArchiveReport();
        Workbook wb = ccBillArchiveReport.readFile(Constants.CCBILLARCHIVE_TEMPLATE);

        OriDataReport oriDataReport = new OriDataReport();
        Workbook wbRd = oriDataReport.readFile(Constants.CCBILLARCHIVE_DATA);
        // 数据校验
        ccBillArchiveReport.checkDataPos(wbRd);
        List<CCBillArchivePoJo> ccBillArchivePoJoList = oriDataReport.getCCBillArchivePoJoList(wbRd);
        oriDataReport.closeFile();
        // CCBillArchivePoJo ccBillArchivePoJo = new CCBillArchivePoJo();
        // ccBillArchivePoJo.setSailDate("开船日");
        // ccBillArchivePoJo.setCabinNo("进舱号");
        // ccBillArchivePoJo.setBillNo("提单号");
        // ccBillArchivePoJo.setDestPort("目的港");
        // ccBillArchivePoJo.setShipName("船名航次");
        // ccBillArchivePoJo.setShipCompany("经营单位");
        // ccBillArchivePoJo.setCooperateCompany("往来单位");
        // ccBillArchivePoJo.setCustomBroker("报关行");
        // ccBillArchivePoJo.setTrackNo("寄报关行快递单号");
        // ccBillArchivePoJo.setOperater("操作");
        // ccBillArchivePoJo.setCustomNo(" 海关编号");
        // ccBillArchivePoJo.setBackDate("退回公司日期");
        // ccBillArchivePoJo.setRejectFlag("是否可退单");
        // ccBillArchivePoJo.setRejectDate("退单日期");
        // ccBillArchivePoJo.setRejectSign("退单签收");
        // ccBillArchivePoJoList.add(ccBillArchivePoJo);
        ccBillArchiveReport.writeReport(ccBillArchivePoJoList, wb);
        ccBillArchiveReport.writeFile(Constants.OUTPUT_PATH);
    }
}
