package yy.excelutil.pojo;

/*
 * 货物查询单
 */
public class GoodsQueryPoJo extends BasePoJo {
    private String billNo;// 提单号
    private String shipName;// 船名航次
    private String warehouse;// 入库仓库
    private String delegateCount;// 委托件数
    private String packing;// 包装
    private String arriveCount;// 到货件数
    private String etDate;// ETD
    private String comments;// 备注

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getDelegateCount() {
        return delegateCount;
    }

    public void setDelegateCount(String delegateCount) {
        this.delegateCount = delegateCount;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getArriveCount() {
        return arriveCount;
    }

    public void setArriveCount(String arriveCount) {
        this.arriveCount = arriveCount;
    }

    public String getEtDate() {
        return etDate;
    }

    public void setEtDate(String etDate) {
        this.etDate = etDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
