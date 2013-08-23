package yy.excelutil.billout;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import yy.excelutil.common.Constants;
import yy.excelutil.exception.ExcelException;
import yy.excelutil.pojo.QuoteBillPoJo;

/*
 * 报价单
 */
public class QuoteBill extends Bill {

    private QuoteBillPoJo quoteBillPoJo;
    private static String REG_AMT_WM = "([\\w]{3})\\s*([\\d\\.]+)[\\sp].*w/m.*";
    private static String REG_AMT_SHIPMENT = "([\\w]{3})\\s*([\\d\\.]+)[\\sp].*shipment.*";
    private static Pattern REG_AMT_WM_PT = Pattern.compile(REG_AMT_WM, Pattern.CASE_INSENSITIVE);
    private static Pattern REG_AMT_SHIPMENT_PT = Pattern.compile(REG_AMT_SHIPMENT, Pattern.CASE_INSENSITIVE);
    private int sheetIndex;

    public QuoteBill(int _sheetIndex) {
        sheetIndex = _sheetIndex;
    }

    public QuoteBill() {
        sheetIndex = 0;
    }

    public void readBillData() {
    }

    private int reOrganizeData(Workbook wb) throws ExcelException {
        quoteBillPoJo = new QuoteBillPoJo();
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(3);// kgs
        Cell cell = row.getCell(1);
        quoteBillPoJo.setTon(cell.getStringCellValue());

        row = sheet.getRow(4);// cbm
        cell = row.getCell(1);
        quoteBillPoJo.setCube(cell.getStringCellValue());
        BigDecimal tonNm = new BigDecimal(quoteBillPoJo.getTon()).divide(new BigDecimal(1000));
        BigDecimal cubeNm = new BigDecimal(quoteBillPoJo.getCube());
        if (tonNm.compareTo(cubeNm) > 0) {
            quoteBillPoJo.setCoefficient(tonNm);
        } else {
            quoteBillPoJo.setCoefficient(cubeNm);
        }

        row = sheet.getRow(5);// rate
        cell = row.getCell(1);
        quoteBillPoJo.setRate(cell.getStringCellValue());

        int i = 0;
        row = sheet.getRow(this.startLine + i);
        quoteBillPoJo.setPaidDesc(row.getCell(0).getStringCellValue());
        quoteBillPoJo.setCollDesc(row.getCell(3).getStringCellValue());
        i++;

        row = sheet.getRow(this.startLine + i);
        while (Constants.CONTINUE_CONUE == getContinueFlag(row, 0)) {
            cell = row.getCell(1);
            parseData(cell.getStringCellValue(), quoteBillPoJo.getAllDataPaid());
            i++;
            row = sheet.getRow(this.startLine + i);
        }

        int j = 1;
        row = sheet.getRow(this.startLine + j);
        while (Constants.CONTINUE_CONUE == getContinueFlag(row, 3)) {
            cell = row.getCell(4);
            parseData(cell.getStringCellValue(), quoteBillPoJo.getAllDataColl());
            j++;
            row = sheet.getRow(this.startLine + j);
        }
        quoteBillPoJo.setTotalAudPaid(calTotals(quoteBillPoJo.getAllDataPaid()[0], quoteBillPoJo.getAllDataPaid()[2]));
        quoteBillPoJo.setTotalUsdPaid(calTotals(quoteBillPoJo.getAllDataPaid()[1], quoteBillPoJo.getAllDataPaid()[3]));
        quoteBillPoJo.setTotalAudColl(calTotals(quoteBillPoJo.getAllDataColl()[0], quoteBillPoJo.getAllDataColl()[2]));
        quoteBillPoJo.setTotalUsdColl(calTotals(quoteBillPoJo.getAllDataColl()[1], quoteBillPoJo.getAllDataColl()[3]));
        quoteBillPoJo.setTotalAudRefund(quoteBillPoJo.getTotalAudColl().subtract(quoteBillPoJo.getTotalAudPaid()));
        quoteBillPoJo.setTotalUsdRefund(quoteBillPoJo.getTotalUsdColl().subtract(quoteBillPoJo.getTotalUsdPaid()));
        quoteBillPoJo.setTotalRefund(quoteBillPoJo.getTotalAudRefund()
                .multiply(new BigDecimal(quoteBillPoJo.getRate())).add(quoteBillPoJo.getTotalUsdRefund()));
        i += startLine;
        j += startLine;
        return i > j ? i : j;
    }

    /**
     *
     * @param totalWmList
     * @param totalShipList
     * @return
     */
    private BigDecimal calTotals(List<String> totalWmList, List<String> totalShipList) {
        BigDecimal totals = BigDecimal.ZERO;
        for (String amt : totalWmList) {
            totals = totals.add(new BigDecimal(amt));
        }
        totals = totals.multiply(quoteBillPoJo.getCoefficient());

        for (String amt : totalShipList) {
            totals = totals.add(new BigDecimal(amt));
        }
        return totals;
    }

    private void parseData(String content, List<String>[] alldata) throws ExcelException {
        boolean flag = false;
        Matcher m = REG_AMT_WM_PT.matcher(content);
        if (m.find()) {
            String cur = m.group(1);
            if (Constants.QUOTEBILL_CUR_AUD.equals(cur)) {
                alldata[0].add(m.group(2));
                flag = true;
            } else if (Constants.QUOTEBILL_CUR_USD.equals(cur)) {
                alldata[1].add(m.group(2));
                flag = true;
            }
        } else {
            m = REG_AMT_SHIPMENT_PT.matcher(content);
            if (m.find()) {
                String cur = m.group(1);
                if (Constants.QUOTEBILL_CUR_AUD.equals(cur)) {
                    alldata[2].add(m.group(2));
                    flag = true;
                } else if (Constants.QUOTEBILL_CUR_USD.equals(cur)) {
                    alldata[3].add(m.group(2));
                    flag = true;
                }
            }
        }
        if (!flag) {
            throw new ExcelException(Constants.ERROR_DATA_QUOTE_EXCEL);
        }
    }

    public void writeBill(Workbook wb) throws Exception {
        int lastLine = this.reOrganizeData(wb);
        int i = 1;
        Sheet sheet = wb.getSheetAt(0);

        Row row = sheet.createRow(lastLine + i);
        Cell cell = row.createCell(1);
        cell.setCellValue(resourceBundleUtil.getStringUTF8(Constants.QUOTEBILL_TOTALS_USD));
        cell = row.createCell(2);
        cell.setCellValue(resourceBundleUtil.getStringUTF8(Constants.QUOTEBILL_TOTALS_AUD));
        i++;

        row = sheet.createRow(lastLine + i);
        cell = row.createCell(0);
        cell.setCellValue(quoteBillPoJo.getPaidDesc());
        cell = row.createCell(1);
        cell.setCellValue(quoteBillPoJo.getTotalUsdPaid().toString());
        cell = row.createCell(2);
        cell.setCellValue(quoteBillPoJo.getTotalAudPaid().toString());
        i++;

        row = sheet.createRow(lastLine + i);
        cell = row.createCell(1);
        cell.setCellValue(resourceBundleUtil.getStringUTF8(Constants.QUOTEBILL_TOTALS_USD));
        cell = row.createCell(2);
        cell.setCellValue(resourceBundleUtil.getStringUTF8(Constants.QUOTEBILL_TOTALS_AUD));
        i++;

        row = sheet.createRow(lastLine + i);
        cell = row.createCell(0);
        cell.setCellValue(quoteBillPoJo.getCollDesc());
        cell = row.createCell(1);
        cell.setCellValue(quoteBillPoJo.getTotalUsdColl().toString());
        cell = row.createCell(2);
        cell.setCellValue(quoteBillPoJo.getTotalAudColl().toString());
        i++;

        row = sheet.createRow(lastLine + i);
        cell = row.createCell(3);
        cell.setCellValue(resourceBundleUtil.getStringUTF8(Constants.QUOTEBILL_TOTALS_FINAL));
        i++;

        row = sheet.createRow(lastLine + i);
        cell = row.createCell(0);
        cell.setCellValue(resourceBundleUtil.getStringUTF8(Constants.QUOTEBILL_TOTALS_REFUND));
        cell = row.createCell(1);
        cell.setCellValue(quoteBillPoJo.getTotalUsdRefund().toString());
        cell = row.createCell(2);
        cell.setCellValue(quoteBillPoJo.getTotalAudRefund().toString());
        cell = row.createCell(3);
        cell.setCellValue(quoteBillPoJo.getTotalRefund().toString());
        i++;
    }

    public static void main(String[] arg) throws Exception {
        QuoteBill quoteBill = new QuoteBill();
        Workbook wb;
        wb = quoteBill.readFile(Constants.QUOTEBILL_TEMPDATA);

        // 数据校验
        quoteBill.checkData(wb);
        quoteBill.writeBill(wb);
        quoteBill.writeFile(Constants.OUTPUT_PATH);
        quoteBill.closeFile();
    }
}
