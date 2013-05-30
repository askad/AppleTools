package yy.excelutil.reportout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import yy.excelutil.common.Constants;
import yy.excelutil.common.ResourceBundleUtil;
import yy.excelutil.exception.ExcelException;

public class Report {

    private String[] ALL_TITLE = { "", "状态", "ETD", "业务编号", "网", "指", "提单类别", "要求ETD", "运输状态", "目的港", "委托方", "CO",
            "SpLocal", "客服", "销售", "差异", "件数", "重量", "体积", "报关状态", "进仓情况", "运输", "驳运", "大件", "包装", "拼箱号", "同行编号",
            "海外代理", "EI", "确认", "出单状态", "运费", "计费重量", "危冷", "H.B/L NO.", "船名航次", "查验", "预报关日", "审", "进仓编号", "OA", "FL",
            "航线", "M.B/L NO.", "来源", "起运港代码", "卸货港代码", "目的港代码", "付款地点", "签单地", "中文品名", "运输条款", "ETA", "二程船", "2nd ETD",
            "2nd ETA", "委托方编号", "联系人", "电话", "FAX", "直接客户", "代理编号", "货物来源", "货物来源编号", "bookingno", "仓库", "车队", "报关行",
            "装箱方式", "20'", "40'", "HQ", "45'", "整箱航线", "锁财务", "锁操作", "锁文件", "操作编码", "操作", "拼发展", "文件编号", "受理人", "文件",
            "受理人", "受理日期", "备注", "通知代理的备注", "进仓通知", "唛头不符", "尺码不符", "件数不付", "分单", "主并单号", "预借", "内托", "委外", "试报关?",
            "订仓", "报关", "保险", "商检", "仓储", "熏蒸", "装箱", "退关", "关封", "中转", "出MBL", "港区", "船公司", "卸货港", "海外操作", "客服文件",
            "M运费", "订舱", "代理状态", "代理日期", "进仓日", "订舱", "报价", "优惠幅度", "批价主管", "价格级别", "实际开航日", "cportfrom", "cportto",
            "refno1", "财务审单人", "操作审单人", "文件审单人", "审文件", "批", "提单状态", "进口运费条款", "代理资料", "折扣", "出单类型(宁波)" };

    // 开船日 进舱号 提单号 目的港 船名航次 往来单位 报关行
    // private String[] TITLE_DESC_BILL = { "ETD", "业务编号", "M.B/L NO.", "目的港",
    // "船名航次", "委托方", "报关行" };
    // 提单号,船名航次,入库仓库,委托件数,包装,ETD
    // private String[] TITLE_DESC_GOODS = { "M.B/L NO.", "船名航次", "仓库", "件数",
    // "包装", "ETD" };
    // 日期,目的港,HB/L,lclrt,配载公司
    // private String[] TITLE_DESC_WEEK = { "受理日期", "目的港", "M.B/L NO.", "体积",
    // "订舱" };

    private String MSG_CHANGE_EX = "EXCEL表格有变化，请修改配置文件！出错列：";

    private static Map<String, Integer> POS_MAP;

    protected InputStream stream;
    protected Workbook wb;
    private ResourceBundleUtil resourceBundleUtil;

    String fileName;

    public Report() {
        ResourceBundleUtil resourceBundleUtilLocal = getResourceBundleUtil();

        try {
            String manFlag = resourceBundleUtilLocal.getStringUTF8(Constants.MANUAL_FLAG);
            if (Constants.MANUAL_FLAG_Y.equals(manFlag)) {
                String allTitle = resourceBundleUtilLocal.getStringUTF8(Constants.ALL_TITLE_TEXT);
                String splitSign = resourceBundleUtilLocal.getStringUTF8(Constants.SPLIT_SIGN);
                String[] titles = allTitle.split(splitSign);
                if (titles != null) {
                    ALL_TITLE = titles;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected boolean checkDataPos(Workbook wb) throws Exception {
        boolean flag = true;
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(0);
        for (int i = 1; i < ALL_TITLE.length; i++) {
            Cell cell = row.getCell(i);
            if (cell != null) {
                String value = cell.getStringCellValue();
                if (value != null) {
                    if (ALL_TITLE[i].equals(value.trim())) {
                    } else {
                        String forceFlag = getResourceBundleUtil().getStringUTF8(Constants.FORCE_FLAG);
                        flag = false;
                        if (Constants.FORCE_FLAG_Y.equals(forceFlag)) {
                            continue;
                        }
                        throw new ExcelException(MSG_CHANGE_EX + value);
                    }
                }
            }
        }
        // if (ALL_TITLE.length != j) {
        // throw new ExcelException(MSG_CHANGE_EX);
        // }
        return flag;
    }

    private ResourceBundleUtil getResourceBundleUtil() {
        if (resourceBundleUtil == null) {
            resourceBundleUtil = ResourceBundleUtil.getInstance();
        }
        return resourceBundleUtil;
    }

    protected Workbook readFile(String templateKey) throws Exception {

        ResourceBundleUtil resourceBundleUtil = ResourceBundleUtil.getInstance();
        String tempPath = resourceBundleUtil.getStringUTF8(templateKey);
        File f = new File(tempPath);
        fileName = f.getName();
        stream = new FileInputStream(f);
        wb = WorkbookFactory.create(stream);
        return wb;
    }

    protected void writeFile(String outputPath) throws Exception {

        ResourceBundleUtil resourceBundleUtil = ResourceBundleUtil.getInstance();
        String output = resourceBundleUtil.getStringUTF8(outputPath);
        FileOutputStream fileOutputStream = new FileOutputStream(output + fileName);
        wb.write(fileOutputStream);
        fileOutputStream.close();
        stream.close();
    }

    protected void closeFile() throws Exception {
        stream.close();
    }

    protected Map<String, Integer> getTitlePos() throws Exception {

        ResourceBundleUtil resourceBundleUtil = ResourceBundleUtil.getInstance();
        if (POS_MAP == null) {
            POS_MAP = new HashMap<String, Integer>();
            for (int i = 0; i < Constants.PROPERTY_BILL.length; i++) {
                String key = Constants.PROPERTY_BILL[i];
                String value = resourceBundleUtil.getStringUTF8(key);
                int pos = Integer.parseInt(value);
                POS_MAP.put(key, pos);
            }
            for (int i = 0; i < Constants.PROPERTY_GOODS.length; i++) {
                String key = Constants.PROPERTY_GOODS[i];
                String value = resourceBundleUtil.getStringUTF8(key);
                int pos = Integer.parseInt(value);
                POS_MAP.put(key, pos);
            }
            for (int i = 0; i < Constants.PROPERTY_WEEK.length; i++) {
                String key = Constants.PROPERTY_WEEK[i];
                String value = resourceBundleUtil.getStringUTF8(key);
                int pos = Integer.parseInt(value);
                POS_MAP.put(key, pos);
            }
            for (int i = 0; i < Constants.PROPERTY_BOOKING.length; i++) {
                String key = Constants.PROPERTY_BOOKING[i];
                String value = resourceBundleUtil.getStringUTF8(key);
                int pos = Integer.parseInt(value);
                POS_MAP.put(key, pos);
            }
            String key = Constants.CHECK_FIELD_RQETD;
            int pos = Integer.parseInt(resourceBundleUtil.getStringUTF8(key));
            POS_MAP.put(key, pos);
        }

        return POS_MAP;
    }

    public static void main(String[] args) throws Exception {
        new Report();
    }
}
