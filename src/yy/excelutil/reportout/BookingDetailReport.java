package yy.excelutil.reportout;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import yy.excelutil.common.Constants;
import yy.excelutil.pojo.BookingDetailPoJo;

/*
 * Booking Detail
 * 委托明细 装箱明细表
 */
public class BookingDetailReport extends Report {

    private static String SHIP_INFO = "(.*?) V.(.*)";
    private static Pattern SHIP_INFO_PT = Pattern.compile(SHIP_INFO);

    public void writeReport(List<BookingDetailPoJo> bookingDetailPoJoList, Workbook wb) throws Exception {
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

        BookingDetailPoJo bookingDetailPoJoFirst = bookingDetailPoJoList.get(0);

        List<String> shipNameNo = getShipInfo(bookingDetailPoJoFirst.getShipName());
        Row rowTemp = sheet.getRow(2);
        Cell cell = rowTemp.createCell(0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(shipNameNo.get(0));// 船名
        cell = rowTemp.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(shipNameNo.get(1));// 航次

        for (int i = 0; i < bookingDetailPoJoList.size(); i++) {
            BookingDetailPoJo bookingDetailPoJo = bookingDetailPoJoList.get(i);
            Row row = sheet.createRow(i + 4);
            cell = row.createCell(0);
            cell.setCellStyle(cellStyle);
            cell = row.createCell(8);
            cell.setCellStyle(cellStyle);

            cell = row.createCell(1);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(bookingDetailPoJo.getMbillNo());// 出口拼箱准单号
            cell = row.createCell(2);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(bookingDetailPoJo.getName());// 货物名称
            cell = row.createCell(3);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(bookingDetailPoJo.getCount());// 件数
            cell = row.createCell(4);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(bookingDetailPoJo.getPackageType());// 包装类型
            cell = row.createCell(5);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(bookingDetailPoJo.getWeight());// 毛重
            cell = row.createCell(6);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(bookingDetailPoJo.getVolume());// 体积
            cell = row.createCell(7);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(bookingDetailPoJo.getComments());// 备注
        }
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
        BookingDetailReport bookingDetailReport = new BookingDetailReport();
        Workbook wb = bookingDetailReport.readFile(Constants.BOOKINGDETAIL_TEMPLATE);

        OriDataReport oriDataReport = new OriDataReport();
        Workbook wbRd = oriDataReport.readFile(Constants.BOOKINGDETAIL_DATA);
        // 数据校验
        boolean flag = bookingDetailReport.checkDataPos(wbRd);
        if (!flag) {
            System.out.println(Constants.WARN_CHANGE_EXCEL);
        }
        List<BookingDetailPoJo> bookingDetailPoJoList = oriDataReport.getBookingDetailPoJoList(wbRd);
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
        bookingDetailReport.writeReport(bookingDetailPoJoList, wb);
        bookingDetailReport.writeFile(Constants.OUTPUT_PATH);
    }
}
