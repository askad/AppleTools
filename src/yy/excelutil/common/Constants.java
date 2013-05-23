package yy.excelutil.common;

public class Constants {

    public final static int CONTINUE_GO=0;
    public final static int CONTINUE_BREAK=1;
    public final static int CONTINUE_CONUE=2;

    public final static String ENCODE_UTF8="UTF-8";
    public final static String CCBILLARCHIVE_TEMPLATE = "CCBILLARCHIVE_TEMPLATE";
    public final static String CCBILLARCHIVE_DATA = "CCBILLARCHIVE_DATA";

    public final static String GOODSQUERY_TEMPLATE = "GOODSQUERY_TEMPLATE";
    public final static String GOODSQUERY_DATA = "GOODSQUERY_DATA";

    public final static String WEEKALLOCINFO_TEMPLATE = "WEEKALLOCINFO_TEMPLATE";
    public final static String WEEKALLOCINFO_DATA = "WEEKALLOCINFO_DATA";

    public final static String OUTPUT_PATH = "OUTPUT_PATH";
    public final static String CONFIG_PATH = "config";

    public final static String ACCEPT_DATE = "ACCEPT_DATE";

    public final static String MANUAL_FLAG = "MANUAL_FLAG";
    public final static String MANUAL_FLAG_Y = "Y";

    public final static String FORCE_FLAG = "FORCE_FLAG";
    public final static String FORCE_FLAG_Y = "Y";

    public final static String ALL_TITLE_TEXT = "ALL_TITLE";
    public final static String SPLIT_SIGN = "SPLIT_SIGN";

    public final static String CHECK_FIELD_RQETD = "要求ETD";

    // 开船日 进舱号 提单号 目的港 船名航次 往来单位 报关行
    public final static String BILL_POS_ETD = "报关单据存档表_开船日";
    public final static String BILL_POS_CABINNO = "报关单据存档表_进舱号";
    public final static String BILL_POS_BILLNO = "报关单据存档表_提单号";
    public final static String BILL_POS_PORT = "报关单据存档表_目的港";
    public final static String BILL_POS_SHIP = "报关单据存档表_船名航次";
    public final static String BILL_POS_CO = "报关单据存档表_往来单位";
    public final static String BILL_POS_BROKER = "报关单据存档表_报关行";
    public final static String[] PROPERTY_BILL = { BILL_POS_ETD, BILL_POS_CABINNO, BILL_POS_BILLNO, BILL_POS_PORT,
            BILL_POS_SHIP, BILL_POS_CO, BILL_POS_BROKER };

    // 提单号,船名航次,入库仓库,委托件数,包装,ETD
    public final static String GOODS_POS_BILLNO = "货物查询单_提单号";
    public final static String GOODS_POS_SHIP = "货物查询单_船名航次";
    public final static String GOODS_POS_WAREHOUSE = "货物查询单_入库仓库";
    public final static String GOODS_POS_DENO = "货物查询单_委托件数";
    public final static String GOODS_POS_TYPE = "货物查询单_包装";
    public final static String GOODS_POS_ETD = "货物查询单_ETD";
    public final static String GOODS_POS_WGHT = "货物查询单_重量";
    public final static String GOODS_POS_VOLM = "货物查询单_体积";
    public final static String[] PROPERTY_GOODS = { GOODS_POS_BILLNO, GOODS_POS_SHIP, GOODS_POS_WAREHOUSE,
            GOODS_POS_DENO, GOODS_POS_TYPE, GOODS_POS_ETD, GOODS_POS_WGHT, GOODS_POS_VOLM};

    // 日期,目的港,HB/L,lclrt,配载公司
    public final static String WEEK_POS_DATE = "每周配货情况汇报_日期";
    public final static String WEEK_POS_PORT = "每周配货情况汇报_目的港";
    public final static String WEEK_POS_HBL = "每周配货情况汇报_HB/L";
    public final static String WEEK_POS_LCLRT = "每周配货情况汇报_lclrt";
    public final static String WEEK_POS_COER = "每周配货情况汇报_配载公司";
    public final static String[] PROPERTY_WEEK = { WEEK_POS_DATE, WEEK_POS_PORT, WEEK_POS_HBL, WEEK_POS_LCLRT,
            WEEK_POS_COER };

    public final static String WARN_CHANGE_EXCEL = "EXCEL有变化!";
}
