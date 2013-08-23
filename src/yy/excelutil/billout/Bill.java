package yy.excelutil.billout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import yy.excelutil.common.Constants;
import yy.excelutil.common.ResourceBundleUtil;
import yy.excelutil.exception.ExcelException;

public class Bill {

    protected InputStream stream;
    protected Workbook wb;
    protected ResourceBundleUtil resourceBundleUtil;

    protected int startLine;
    String fileName;

    public Bill() {
        resourceBundleUtil = ResourceBundleUtil.getInstance();
    }

    protected void checkData(Workbook wb) throws Exception {
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(3);
        Cell cell = row.getCell(0);
        if (cell != null) {
            String value = cell.getStringCellValue();
            if (value == null || value.trim().isEmpty())
                throw new ExcelException(Constants.ERROR_MISSED_QUOTE_EXCEL);
        }
        row = sheet.getRow(4);
        cell = row.getCell(1);
        if (cell != null) {
            String value = cell.getStringCellValue();
            if (value == null || value.trim().isEmpty())
                throw new ExcelException(Constants.ERROR_MISSED_QUOTE_EXCEL);
        }
        row = sheet.getRow(5);
        cell = row.getCell(1);
        if (cell != null) {
            String value = cell.getStringCellValue();
            if (value == null || value.trim().isEmpty())
                throw new ExcelException(Constants.ERROR_MISSED_QUOTE_EXCEL);
        }
        startLine = Integer.parseInt(resourceBundleUtil.getString(Constants.QUOTEBILL_TEMPDATA_STARTLINE));
    }

    protected Workbook readFile(String templateKey) throws Exception {
        String tempPath = resourceBundleUtil.getStringUTF8(templateKey);
        File f = new File(tempPath);
        fileName = f.getName();
        stream = new FileInputStream(f);
        wb = WorkbookFactory.create(stream);
        return wb;
    }

    public Workbook reopenForReCalc(String tempPath) throws Exception {
        File f = new File(tempPath);
        fileName = f.getName();
        stream = new FileInputStream(f);
        wb = WorkbookFactory.create(stream);
        wb.getSheetAt(0).setForceFormulaRecalculation(true);
        wb.getCreationHelper().createFormulaEvaluator().evaluateAll();
        wb.setForceFormulaRecalculation(true);

        return wb;
    }

    protected String writeFile(String outputPath) throws Exception {
        String output = resourceBundleUtil.getStringUTF8(outputPath);
        FileOutputStream fileOutputStream = new FileOutputStream(output + fileName);
        wb.write(fileOutputStream);
        fileOutputStream.close();
        stream.close();
        return output + fileName;
    }

    protected void closeFile() throws Exception {
        stream.close();
    }

    protected int getContinueFlag(Row row,int cellIndex) {
        if (row == null) {
            return Constants.CONTINUE_BREAK;
        }
        Cell cell = row.getCell(cellIndex);
        if (cell == null) {
            return Constants.CONTINUE_BREAK;
        }
        String startFlag = cell.getStringCellValue();
        if (startFlag == null || startFlag.isEmpty()) {
            return Constants.CONTINUE_BREAK;
        }
        return Constants.CONTINUE_CONUE;
    }

    public static void main(String[] args) throws Exception {
        new Bill();
    }
}
