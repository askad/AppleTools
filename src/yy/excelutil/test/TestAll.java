package yy.excelutil.test;

import yy.excelutil.reportout.CCBillArchiveReport;
import yy.excelutil.reportout.GoodsQueryReport;
import yy.excelutil.reportout.WeekAllocInfoReport;

public class TestAll {
    public static void main(String[] arg) throws Exception {
        CCBillArchiveReport.main(arg);
        GoodsQueryReport.main(arg);
        WeekAllocInfoReport.main(arg);
    }
}
