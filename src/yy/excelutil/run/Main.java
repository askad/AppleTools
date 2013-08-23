package yy.excelutil.run;

import yy.excelutil.billout.QuoteBill;
import yy.excelutil.exception.ExcelException;
import yy.excelutil.reportout.ArrivedReport;
import yy.excelutil.reportout.BookingDetailReport;
import yy.excelutil.reportout.CCBillArchiveReport;
import yy.excelutil.reportout.GoodsQueryReport;
import yy.excelutil.reportout.WeekAllocInfoReport;

public class Main {
    public static void main(String[] arg) throws Exception {

        if (arg == null || arg.length == 0) {
            try {
                CCBillArchiveReport.main(arg);
                GoodsQueryReport.main(arg);
                WeekAllocInfoReport.main(arg);
                BookingDetailReport.main(arg);
                ArrivedReport.main(arg);
            } catch (ExcelException e) {
                System.out.println(e.getMsg());
            }

            return;
        }
        String para = arg[0];

        if ("1".equals(para)) {
            try {
                CCBillArchiveReport.main(arg);
            } catch (ExcelException e) {
                System.out.println(e.getMsg());
            }
            return;
        }
        if ("2".equals(para)) {
            try {
                GoodsQueryReport.main(arg);
            } catch (ExcelException e) {
                System.out.println(e.getMsg());
            }
            return;
        }
        if ("3".equals(para)) {
            try {
                WeekAllocInfoReport.main(arg);
            } catch (ExcelException e) {
                System.out.println(e.getMsg());
            }
            return;
        }
        if ("4".equals(para)) {
            try {
                BookingDetailReport.main(arg);
            } catch (ExcelException e) {
                System.out.println(e.getMsg());
            }
            return;
        }
        if ("5".equals(para)) {
            try {
                ArrivedReport.main(arg);
            } catch (ExcelException e) {
                System.out.println(e.getMsg());
            }
            return;
        }
        if ("6".equals(para)) {
            try {
                QuoteBill.main(arg);
            } catch (ExcelException e) {
                System.out.println(e.getMsg());
            }
            return;
        }
    }
}
