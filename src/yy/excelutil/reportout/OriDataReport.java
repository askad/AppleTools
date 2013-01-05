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
import yy.excelutil.pojo.CCBillArchivePoJo;
import yy.excelutil.pojo.GoodsQueryPoJo;
import yy.excelutil.pojo.WeekAllocInfoPoJo;
import yy.util.DateUtil;

/*
 * 原始数据
 */
public class OriDataReport extends Report {

    public Map<String, Integer> posSite;

    public List<CCBillArchivePoJo> getCCBillArchivePoJoList(Workbook wb) throws Exception {
        List<CCBillArchivePoJo> ccBillArchivePoJoList = new ArrayList<CCBillArchivePoJo>();

        Map<String, Integer> posMap = getTitlePos();
        Sheet sheet = wb.getSheetAt(0);
        boolean flag = true;
        int i = 1;
        while (flag) {
            Row row = sheet.getRow(i);
            if (row == null) {
                break;
            }
            Cell cell = row.getCell(0);
            if (cell == null) {
                break;
            }
            String startFlag = cell.getStringCellValue();
            if (startFlag == null || startFlag.isEmpty()) {
                break;
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
        boolean flag = true;
        int i = 1;
        while (flag) {
            Row row = sheet.getRow(i);
            if (row == null) {
                break;
            }
            Cell cell = row.getCell(0);
            if (cell == null) {
                break;
            }
            String startFlag = cell.getStringCellValue();
            if (startFlag == null || startFlag.isEmpty()) {
                break;
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
            goodsQueryPoJoList.add(goodsQueryPoJo);
            i++;
        }
        return goodsQueryPoJoList;
    }

    public List<WeekAllocInfoPoJo> getWeekAllocInfoPoJoList(Workbook wb) throws Exception {
        List<WeekAllocInfoPoJo> weekAllocInfoPoJoList = new ArrayList<WeekAllocInfoPoJo>();
        Map<String, Integer> posMap = getTitlePos();
        Sheet sheet = wb.getSheetAt(0);
        boolean flag = true;
        int i = 1;
        while (flag) {
            Row row = sheet.getRow(i);
            if (row == null) {
                break;
            }
            Cell cell = row.getCell(0);
            if (cell == null) {
                break;
            }
            String startFlag = cell.getStringCellValue();
            if (startFlag == null || startFlag.isEmpty()) {
                break;
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

    public static void main(String[] as) {
    }
}
