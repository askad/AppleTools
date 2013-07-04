package yy.excelutil.reportout;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import yy.excelutil.common.Constants;
import yy.excelutil.pojo.ArrivedPoJo;

/*
 * Arrived Report
 * 运抵
 */
public class ArrivedReport extends Report {

    private static String SHIP_INFO = "(.*?) V.(.*)";
    private static Pattern SHIP_INFO_PT = Pattern.compile(SHIP_INFO);
    private String sbl;
    private String[] SBL_SUFFIX = { "", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
            "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

    public ArrivedReport(String _sbl) {
        sbl = _sbl;
    }

    public void writeReport(List<ArrivedPoJo> arrivedPoJoList, Workbook wb) throws Exception {
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

        Sheet sheet = wb.getSheetAt(0);
        CellStyle cellStyleTotals = sheet.getRow(2).getCell(0).getCellStyle();
        int i = 0;
        for (; i < arrivedPoJoList.size(); i++) {
            ArrivedPoJo arrivedPoJo = arrivedPoJoList.get(i);
            int j = 0;
            List<String> shipNameNo = getShipInfo(arrivedPoJo.getShipName());
            Row row = sheet.createRow(i + 1);
            Cell cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(shipNameNo.get(0));// 船名

            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(shipNameNo.get(1));// 航次

            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(sbl + SBL_SUFFIX[i]);// 海运提单号

            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(arrivedPoJo.getMbillNo());// 提运单号

            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);

            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellValue(Integer.parseInt(arrivedPoJo.getCount()));// 件数

            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellValue(new Double(arrivedPoJo.getWeight()));// 毛重
            // Double doubleValue = cell.getNumericCellValue();
            // if (!arrivedPoJo.getWeight().equals(doubleValue.toString())) {
            // cell.setCellValue(arrivedPoJo.getWeight());
            // }

            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(arrivedPoJo.getName());// 品名

            cell = row.createCell(j++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue("USA");// 目的地
        }
        i++;
        // /////////////////////total
        // row///////////////////////////////////////////////////////////////////////////
        Row row = sheet.createRow(i);
        Cell cell = row.createCell(0);
        cell.setCellStyle(cellStyleTotals);
        cell.setCellValue("合计：");// 合计：

        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(2);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(3);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(4);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(5);
        cell.setCellStyle(cellStyleTotals);
        // cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        cell.setCellFormula("SUM(F2:F" + i + ")");// 件数

        cell = row.createCell(6);
        cell.setCellStyle(cellStyleTotals);
        // cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        cell.setCellFormula("SUM(G2:G" + i + ")");// 毛重

        cell = row.createCell(7);
        cell.setCellStyle(cellStyleTotals);

        cell = row.createCell(8);
        cell.setCellStyle(cellStyle);
        // ///////////////////////////////////////////////////////////////

        // ///////////////////////////////////info
        // row///////////////////////////
        row = sheet.createRow(i + 4);
        cell = row.createCell(6);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("主提单号：");// 主提单号：

        cell = row.createCell(7);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(sbl);

        row = sheet.createRow(i + 5);
        cell = row.createCell(6);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("箱号:");// 主提单号：

        cell = row.createCell(7);
        cell.setCellStyle(cellStyle);

        // for (int k = i + 1; k < i + 4; k++) {
        // row = sheet.createRow(k);
        // cell = row.createCell(0);
        // cell.setCellStyle(cellStyleTotals);
        //
        // cell = row.createCell(1);
        // cell.setCellStyle(cellStyle);
        //
        // cell = row.createCell(2);
        // cell.setCellStyle(cellStyle);
        //
        // cell = row.createCell(3);
        // cell.setCellStyle(cellStyle);
        //
        // cell = row.createCell(4);
        // cell.setCellStyle(cellStyle);
        //
        // cell = row.createCell(5);
        // cell.setCellStyle(cellStyle);
        //
        // cell = row.createCell(6);
        // cell.setCellStyle(cellStyle);
        // }
        // sheet.addMergedRegion(new CellRangeAddress(i + 1, i + 3, 6, 7));
        wb.getSheetAt(0).setForceFormulaRecalculation(true);
    }

    private List<String> getShipInfo(String shipName) {
        List<String> shipResult = new ArrayList<String>();
        Matcher m = SHIP_INFO_PT.matcher(shipName);
        if (m.find()) {
            shipResult.add(m.group(1));
            shipResult.add(m.group(2));
        }
        return shipResult;
    }

    public static void main(String[] arg) throws Exception {

        InputStream is = System.in;
        Scanner scan = new Scanner(is);
        // 这段代码用来读取键盘输入的字符串
        System.out.println("Pls input the B/L No:");
        String name = scan.next();
        ArrivedReport arrivedReport = new ArrivedReport(name);
        Workbook wb = arrivedReport.readFile(Constants.ARRIVED_TEMPLATE);

        OriDataReport oriDataReport = new OriDataReport();
        Workbook wbRd = oriDataReport.readFile(Constants.ARRIVED_DATA);
        // 数据校验
        boolean flag = arrivedReport.checkDataPos(wbRd);
        if (!flag) {
            System.out.println(Constants.WARN_CHANGE_EXCEL);
        }
        List<ArrivedPoJo> arrivedPoJoList = oriDataReport.getArrivedPoJoList(wbRd);
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
        arrivedReport.writeReport(arrivedPoJoList, wb);
        arrivedReport.writeFile(Constants.OUTPUT_PATH);
        // arrivedReport.reopenForReCalc(fileName);
        // arrivedReport.writeFile(Constants.OUTPUT_PATH);
    }
}
