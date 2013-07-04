package yy.excelutil.common;

public class Constants {

    public final static int CONTINUE_GO = 0;
    public final static int CONTINUE_BREAK = 1;
    public final static int CONTINUE_CONUE = 2;

    public final static String ENCODE_UTF8 = "UTF-8";
    public final static String CCBILLARCHIVE_TEMPLATE = "CCBILLARCHIVE_TEMPLATE";
    public final static String CCBILLARCHIVE_DATA = "CCBILLARCHIVE_DATA";

    public final static String GOODSQUERY_TEMPLATE = "GOODSQUERY_TEMPLATE";
    public final static String GOODSQUERY_DATA = "GOODSQUERY_DATA";

    public final static String WEEKALLOCINFO_TEMPLATE = "WEEKALLOCINFO_TEMPLATE";
    public final static String WEEKALLOCINFO_DATA = "WEEKALLOCINFO_DATA";

    public final static String BOOKINGDETAIL_TEMPLATE = "BOOKINGDETAIL_TEMPLATE";
    public final static String BOOKINGDETAIL_DATA = "BOOKINGDETAIL_DATA";

    public final static String ARRIVED_TEMPLATE = "ARRIVED_TEMPLATE";
    public final static String ARRIVED_DATA = "ARRIVED_DATA";

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
            GOODS_POS_DENO, GOODS_POS_TYPE, GOODS_POS_ETD, GOODS_POS_WGHT, GOODS_POS_VOLM };

    // 日期,目的港,HB/L,lclrt,配载公司
    public final static String WEEK_POS_DATE = "每周配货情况汇报_日期";
    public final static String WEEK_POS_PORT = "每周配货情况汇报_目的港";
    public final static String WEEK_POS_HBL = "每周配货情况汇报_HB/L";
    public final static String WEEK_POS_LCLRT = "每周配货情况汇报_lclrt";
    public final static String WEEK_POS_COER = "每周配货情况汇报_配载公司";
    public final static String[] PROPERTY_WEEK = { WEEK_POS_DATE, WEEK_POS_PORT, WEEK_POS_HBL, WEEK_POS_LCLRT,
            WEEK_POS_COER };

    // 船名,航次,出口拼箱准单号,货物名称,件数,包装类型,毛重,体积,备注
    public final static String BOOKING_POS_SHIPNAME = "装箱委托明细_船名";
    public final static String BOOKING_POS_SHIPNO = "装箱委托明细_航次";
    public final static String BOOKING_POS_MBILLNO = "装箱委托明细_出口拼箱准单号";
    public final static String BOOKING_POS_NAME = "装箱委托明细_货物名称";
    public final static String BOOKING_POS_COUNT = "装箱委托明细_件数";
    public final static String BOOKING_POS_PACKAGETYPE = "装箱委托明细_包装类型";
    public final static String BOOKING_POS_WEIGHT = "装箱委托明细_毛重";
    public final static String BOOKING_POS_VOLUME = "装箱委托明细_体积";
    public final static String BOOKING_POS_COMMENTS = "装箱委托明细_备注";
    public final static String[] PROPERTY_BOOKING = { BOOKING_POS_SHIPNAME, BOOKING_POS_SHIPNO, BOOKING_POS_MBILLNO,
            BOOKING_POS_NAME, BOOKING_POS_COUNT, BOOKING_POS_PACKAGETYPE, BOOKING_POS_WEIGHT, BOOKING_POS_VOLUME,
            BOOKING_POS_COMMENTS };

    // 运输工具名称,航次,提运单号,件数,毛重,品名
    public final static String ARRIVED_POS_SHIPNAME = "运抵_船名";
    public final static String ARRIVED_POS_SHIPNO = "运抵_航次";
    public final static String ARRIVED_POS_MBILLNO = "运抵_提运单号";
    public final static String ARRIVED_POS_COUNT = "运抵_件数";
    public final static String ARRIVED_POS_WEIGHT = "运抵_毛重";
    public final static String ARRIVED_POS_NAME = "运抵_品名";

    public final static String[] PROPERTY_ARRIVED = { ARRIVED_POS_SHIPNAME, ARRIVED_POS_SHIPNO, ARRIVED_POS_MBILLNO,
            ARRIVED_POS_COUNT, ARRIVED_POS_WEIGHT, ARRIVED_POS_NAME, };

    public final static String WARN_CHANGE_EXCEL = "EXCEL was changed!";
    public final static String ERROR_MISSED_EXCEL = "Pls input the B/L No.!";
}
