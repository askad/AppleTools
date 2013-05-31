package yy.excelutil.reportout;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import yy.excelutil.common.Constants;
import yy.excelutil.common.WeekAllocInfoComparator;
import yy.excelutil.pojo.ArrivedPoJo;
import yy.excelutil.pojo.BookingDetailPoJo;
import yy.excelutil.pojo.CCBillArchivePoJo;
import yy.excelutil.pojo.GoodsQueryPoJo;
import yy.excelutil.pojo.WeekAllocInfoPoJo;
import yy.util.DateUtil;

/*
 * 原始数据
 */
public class OriDataReport extends Report {

    public Map<String, Integer> posSite;

    public List<ArrivedPoJo> getArrivedPoJoList(Workbook wb) throws Exception {
        List<ArrivedPoJo> arrivedPoJoList = new ArrayList<ArrivedPoJo>();

        Map<String, Integer> posMap = getTitlePos();
        Sheet sheet = wb.getSheetAt(0);
        int i = 1;
        while (true) {
            Row row = sheet.getRow(i);
            int flag = getContinueFlag(row, posMap);
            if (Constants.CONTINUE_BREAK == flag) {
                break;
            } else if (Constants.CONTINUE_CONUE == flag) {
                i++;
                continue;
            }
            ArrivedPoJo arrivedPoJo = new ArrivedPoJo();
            arrivedPoJo.setShipName(row.getCell(posMap.get(Constants.ARRIVED_POS_SHIPNAME)).getStringCellValue());// 船名
            // arrivedPoJo.setShipNo(row.getCell(posMap.get(Constants.ARRIVED_POS_SHIPNO)).getStringCellValue());//
            // 航次
            arrivedPoJo.setMbillNo(row.getCell(posMap.get(Constants.ARRIVED_POS_MBILLNO)).getStringCellValue());// 提运单号
            arrivedPoJo.setCount(row.getCell(posMap.get(Constants.ARRIVED_POS_COUNT)).getStringCellValue());// 件数
            arrivedPoJo.setWeight(row.getCell(posMap.get(Constants.ARRIVED_POS_WEIGHT)).getStringCellValue());// 毛重
            arrivedPoJo.setName(row.getCell(posMap.get(Constants.ARRIVED_POS_NAME)).getStringCellValue());// 品名

            arrivedPoJoList.add(arrivedPoJo);
            i++;
        }
        return arrivedPoJoList;
    }

    public List<BookingDetailPoJo> getBookingDetailPoJoList(Workbook wb) throws Exception {
        List<BookingDetailPoJo> bookingDetailPoJoList = new ArrayList<BookingDetailPoJo>();

        Map<String, Integer> posMap = getTitlePos();
        Sheet sheet = wb.getSheetAt(0);
        int i = 1;
        while (true) {
            Row row = sheet.getRow(i);
            int flag = getContinueFlag(row, posMap);
            if (Constants.CONTINUE_BREAK == flag) {
                break;
            } else if (Constants.CONTINUE_CONUE == flag) {
                i++;
                continue;
            }
            BookingDetailPoJo bookingDetailPoJo = new BookingDetailPoJo();
            bookingDetailPoJo.setShipName(row.getCell(posMap.get(Constants.BOOKING_POS_SHIPNAME)).getStringCellValue());// 船名
            // bookingDetailPoJo.setShipNo(row.getCell(posMap.get(Constants.BOOKING_POS_SHIPNO)).getStringCellValue());//
            // 航次
            bookingDetailPoJo.setMbillNo(row.getCell(posMap.get(Constants.BOOKING_POS_MBILLNO)).getStringCellValue());// 出口拼箱准单号
            bookingDetailPoJo.setName(row.getCell(posMap.get(Constants.BOOKING_POS_NAME)).getStringCellValue());// 货物名称
            bookingDetailPoJo.setCount(row.getCell(posMap.get(Constants.BOOKING_POS_COUNT)).getStringCellValue());// 件数
            bookingDetailPoJo.setPackageType(row.getCell(posMap.get(Constants.BOOKING_POS_PACKAGETYPE))
                    .getStringCellValue());// 包装类型
            bookingDetailPoJo.setWeight(row.getCell(posMap.get(Constants.BOOKING_POS_WEIGHT)).getStringCellValue());// 毛重
            bookingDetailPoJo.setVolume(row.getCell(posMap.get(Constants.BOOKING_POS_VOLUME)).getStringCellValue());// 体积
            bookingDetailPoJo.setComments(row.getCell(posMap.get(Constants.BOOKING_POS_COMMENTS)).getStringCellValue());// 备注
            bookingDetailPoJoList.add(bookingDetailPoJo);
            i++;
        }
        return bookingDetailPoJoList;
    }

    public List<CCBillArchivePoJo> getCCBillArchivePoJoList(Workbook wb) throws Exception {
        List<CCBillArchivePoJo> ccBillArchivePoJoList = new ArrayList<CCBillArchivePoJo>();

        Map<String, Integer> posMap = getTitlePos();
        Sheet sheet = wb.getSheetAt(0);
        int i = 1;
        while (true) {
            Row row = sheet.getRow(i);
            int flag = getContinueFlag(row, posMap);
            if (Constants.CONTINUE_BREAK == flag) {
                break;
            } else if (Constants.CONTINUE_CONUE == flag) {
                i++;
                continue;
            }
            CCBillArchivePoJo ccBillArchivePoJo = new CCBillArchivePoJo();
            ccBillArchivePoJo.setSailDate(row.getCell(posMap.get(Constants.BILL_POS_ETD)).getStringCellValue());
            ccBillArchivePoJo.setCabinNo(row.getCell(posMap.get(Constants.BILL_POS_CABINNO)).getStringCellValue());// "进舱号");
            ccBillArchivePoJo.setBillNo(row.getCell(posMap.get(Constants.BILL_POS_BILLNO)).getStringCellValue());// "提单号");
            ccBillArchivePoJo.setDestPort(row.getCell(posMap.get(Constants.BILL_POS_PORT)).getStringCellValue());// "目的港");
            ccBillArchivePoJo.setShipName(row.getCell(posMap.get(Constants.BILL_POS_SHIP)).getStringCellValue());// "船名航次");
            // ccBillArchivePoJo.setShipCompany("经营单位");
            ccBillArchivePoJo.setCooperateCompany(row.getCell(posMap.get(Constants.BILL_POS_CO)).getStringCellValue());// "往来单位");
            ccBillArchivePoJo.setCustomBroker(row.getCell(posMap.get(Constants.BILL_POS_BROKER)).getStringCellValue());// "报关行");
            // ccBillArchivePoJo.setTrackNo("寄报关行快递单号");
            // ccBillArchivePoJo.setOperater("操作");
            // ccBillArchivePoJo.setCustomNo(" 海关编号");
            // ccBillArchivePoJo.setBackDate("退回公司日期");
            // ccBillArchivePoJo.setRejectFlag("是否可退单");
            // ccBillArchivePoJo.setRejectDate("退单日期");
            // ccBillArchivePoJo.setRejectSign("退单签收");
            ccBillArchivePoJoList.add(ccBillArchivePoJo);
            i++;
        }
        return ccBillArchivePoJoList;
    }

    public List<GoodsQueryPoJo> getGoodsQueryPoJoList(Workbook wb) throws Exception {
        List<GoodsQueryPoJo> goodsQueryPoJoList = new ArrayList<GoodsQueryPoJo>();
        Map<String, Integer> posMap = getTitlePos();
        Sheet sheet = wb.getSheetAt(0);
        int i = 1;
        while (true) {
            Row row = sheet.getRow(i);
            int flag = getContinueFlag(row, posMap);
            if (Constants.CONTINUE_BREAK == flag) {
                break;
            } else if (Constants.CONTINUE_CONUE == flag) {
                i++;
                continue;
            }
            GoodsQueryPoJo goodsQueryPoJo = new GoodsQueryPoJo();
            goodsQueryPoJo.setBillNo(row.getCell(posMap.get(Constants.GOODS_POS_BILLNO)).getStringCellValue());// "提单号");
            goodsQueryPoJo.setShipName(row.getCell(posMap.get(Constants.GOODS_POS_SHIP)).getStringCellValue());// "船名航次");
            goodsQueryPoJo.setWarehouse(row.getCell(posMap.get(Constants.GOODS_POS_WAREHOUSE)).getStringCellValue());// "入库仓库");
            goodsQueryPoJo.setDelegateCount(row.getCell(posMap.get(Constants.GOODS_POS_DENO)).getStringCellValue());// "委托件数");
            goodsQueryPoJo.setPacking(row.getCell(posMap.get(Constants.GOODS_POS_TYPE)).getStringCellValue());// "包装");
            // goodsQueryPoJo.setArriveCount(row.getCell(32).getStringCellValue());//"到货件数");
            goodsQueryPoJo.setEtDate(row.getCell(posMap.get(Constants.GOODS_POS_ETD)).getStringCellValue());// "ETD");
            // goodsQueryPoJo.setComments(row.getCell(32).getStringCellValue());//"备注");
            goodsQueryPoJo.setWeight(row.getCell(posMap.get(Constants.GOODS_POS_WGHT)).getStringCellValue());// 重量
            goodsQueryPoJo.setVolume(row.getCell(posMap.get(Constants.GOODS_POS_VOLM)).getStringCellValue());// 体积

            goodsQueryPoJoList.add(goodsQueryPoJo);
            i++;
        }
        return goodsQueryPoJoList;
    }

    public List<WeekAllocInfoPoJo> getWeekAllocInfoPoJoList(Workbook wb) throws Exception {
        List<WeekAllocInfoPoJo> weekAllocInfoPoJoList = new ArrayList<WeekAllocInfoPoJo>();
        Map<String, Integer> posMap = getTitlePos();
        Sheet sheet = wb.getSheetAt(0);
        int i = 1;
        while (true) {
            Row row = sheet.getRow(i);

            int flag = getContinueFlag(row, posMap);
            if (Constants.CONTINUE_BREAK == flag) {
                break;
            } else if (Constants.CONTINUE_CONUE == flag) {
                i++;
                continue;
            }

            WeekAllocInfoPoJo weekAllocInfoPoJo = new WeekAllocInfoPoJo();
            String dateStr = row.getCell(posMap.get(Constants.WEEK_POS_DATE)).getStringCellValue();
            weekAllocInfoPoJo.setDate(DateUtil.getACDate(dateStr));// 日期 月-日 排序
            weekAllocInfoPoJo.setDestPort(row.getCell(posMap.get(Constants.WEEK_POS_PORT)).getStringCellValue());// 目的港
            weekAllocInfoPoJo.setHblNo(row.getCell(posMap.get(Constants.WEEK_POS_HBL)).getStringCellValue());// HB/L
            BigDecimal weight = new BigDecimal(row.getCell(posMap.get(Constants.WEEK_POS_LCLRT)).getStringCellValue());
            if (weight.compareTo(BigDecimal.ONE) < 0) {
                weight = BigDecimal.ONE;
            }
            weekAllocInfoPoJo.setLclWeight(weight.toString());// lclrt
            // weekAllocInfoPoJo.setTwenty(row.getCell(32).getStringCellValue());//
            // 20‘
            // weekAllocInfoPoJo.setForty(row.getCell(32).getStringCellValue());//
            // 40‘
            // weekAllocInfoPoJo.setFreightRate(row.getCell(32).getStringCellValue());//
            // 运价
            // weekAllocInfoPoJo.setCnyRate(row.getCell(32).getStringCellValue());//
            // 人民币收费
            weekAllocInfoPoJo.setStowageCompany(row.getCell(posMap.get(Constants.WEEK_POS_COER)).getStringCellValue());// 配载公司
            weekAllocInfoPoJoList.add(weekAllocInfoPoJo);
            i++;
        }
        Collections.sort(weekAllocInfoPoJoList, new WeekAllocInfoComparator());
        return weekAllocInfoPoJoList;
    }

    private int getContinueFlag(Row row, Map<String, Integer> posMap) {
        if (row == null) {
            return Constants.CONTINUE_BREAK;
        }
        Cell cell = row.getCell(0);
        if (cell == null) {
            return Constants.CONTINUE_BREAK;
        }
        String startFlag = cell.getStringCellValue();
        if (startFlag == null || startFlag.isEmpty()) {
            return Constants.CONTINUE_BREAK;
        }

        Cell cellCheck = row.getCell(posMap.get(Constants.CHECK_FIELD_RQETD));
        if (cellCheck != null) {
            String content = cellCheck.getStringCellValue();
            if (content == null || content.trim().isEmpty()) {
                return Constants.CONTINUE_CONUE;
            }
        } else {
            return Constants.CONTINUE_CONUE;
        }
        return Constants.CONTINUE_GO;
    }

    public static void main(String[] as) {
    }
}
