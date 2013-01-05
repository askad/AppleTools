package yy.excelutil.reportout;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import yy.excelutil.common.Constants;
import yy.excelutil.common.ConstantsMap;
import yy.excelutil.pojo.GoodsQueryPoJo;

/*
 * 货物查询单
 */
public class GoodsQueryReport extends Report {

    public void writeReport(List<GoodsQueryPoJo> goodsQueryPoJoList, Workbook wb) throws Exception {
        Sheet sheet = wb.getSheetAt(0);
        Map<String, String> box = ConstantsMap.getBoxDesc();
        for (int i = 0; i < goodsQueryPoJoList.size(); i++) {
            GoodsQueryPoJo goodsQueryPoJo = goodsQueryPoJoList.get(i);
            Row row = sheet.createRow(i + 3);
            int j = 0;
            Cell cell = row.createCell(j++);
            cell.setCellValue(goodsQueryPoJo.getBillNo());// 提单号
            cell = row.createCell(j++);
            cell.setCellValue(goodsQueryPoJo.getShipName());// 船名航次
            cell = row.createCell(j++);
            cell.setCellValue(goodsQueryPoJo.getWarehouse());// 入库仓库
            cell = row.createCell(j++);
            cell.setCellValue(goodsQueryPoJo.getDelegateCount());// 委托件数
            cell = row.createCell(j++);
            String boxDesc = goodsQueryPoJo.getPacking();
            if (box.containsKey(boxDesc)) {
                boxDesc = box.get(boxDesc);
            }else{
                boxDesc = ConstantsMap.getSpecialName(boxDesc);
            }
            cell.setCellValue(boxDesc);// 包装
            cell = row.createCell(j++);
            cell.setCellValue(goodsQueryPoJo.getArriveCount());// 到货件数
            cell = row.createCell(j++);
            cell.setCellValue(goodsQueryPoJo.getEtDate());// ETD
            cell = row.createCell(j++);
            cell.setCellValue(goodsQueryPoJo.getComments());// 备注

        }
    }

    public static void main(String[] arg) throws Exception {
        GoodsQueryReport goodsQueryReport = new GoodsQueryReport();
        Workbook wb = goodsQueryReport.readFile(Constants.GOODSQUERY_TEMPLATE);

        OriDataReport oriDataReport = new OriDataReport();
        Workbook wbRd = oriDataReport.readFile(Constants.GOODSQUERY_DATA);
        // 数据校验
        goodsQueryReport.checkDataPos(wbRd);
        List<GoodsQueryPoJo> goodsQueryPoJoList = oriDataReport.getGoodsQueryPoJoList(wbRd);
        oriDataReport.closeFile();
        // List<GoodsQueryPoJo> goodsQueryPoJoList = new
        // ArrayList<GoodsQueryPoJo>();
        // GoodsQueryPoJo goodsQueryPoJo = new GoodsQueryPoJo();
        // goodsQueryPoJo.setBillNo("提单号");
        // goodsQueryPoJo.setShipName("船名航次");
        // goodsQueryPoJo.setWarehouse("入库仓库");
        // goodsQueryPoJo.setDelegateCount("委托件数");
        // goodsQueryPoJo.setPacking("包装");
        // goodsQueryPoJo.setArriveCount("到货件数");
        // goodsQueryPoJo.setEtDate("ETD");
        // goodsQueryPoJo.setComments("备注");
        // goodsQueryPoJoList.add(goodsQueryPoJo);
        goodsQueryReport.writeReport(goodsQueryPoJoList, wb);
        goodsQueryReport.writeFile(Constants.OUTPUT_PATH);
    }
}
