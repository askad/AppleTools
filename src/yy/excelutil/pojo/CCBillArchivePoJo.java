package yy.excelutil.pojo;
/*
 * customs clearance
 * 报关单据存档表
 */
public class CCBillArchivePoJo extends BasePoJo {
    private String no;// 序号
    private String sailDate;// 开船日
    private String cabinNo;// 进舱号
    private String billNo;// 提单号
    private String destPort;// 目的港
    private String shipName;// 船名航次
    private String shipCompany;// 经营单位
    private String cooperateCompany;// 往来单位
    private String customBroker;// 报关行
    private String trackNo;// 寄报关行快递单号
    private String operater;// 操作
    private String customNo;//  海关编号
    private String backDate;// 退回公司日期
    private String rejectFlag;// 是否可退单
    private String rejectDate;// 退单日期
    private String rejectSign;// 退单签收
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getSailDate() {
        return sailDate;
    }
    public void setSailDate(String sailDate) {
        this.sailDate = sailDate;
    }
    public String getCabinNo() {
        return cabinNo;
    }
    public void setCabinNo(String cabinNo) {
        this.cabinNo = cabinNo;
    }
    public String getBillNo() {
        return billNo;
    }
    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }
    public String getDestPort() {
        return destPort;
    }
    public void setDestPort(String destPort) {
        this.destPort = destPort;
    }
    public String getShipName() {
        return shipName;
    }
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    public String getShipCompany() {
        return shipCompany;
    }
    public void setShipCompany(String shipCompany) {
        this.shipCompany = shipCompany;
    }
    public String getCooperateCompany() {
        return cooperateCompany;
    }
    public void setCooperateCompany(String cooperateCompany) {
        this.cooperateCompany = cooperateCompany;
    }
    public String getCustomBroker() {
        return customBroker;
    }
    public void setCustomBroker(String customBroker) {
        this.customBroker = customBroker;
    }
    public String getTrackNo() {
        return trackNo;
    }
    public void setTrackNo(String trackNo) {
        this.trackNo = trackNo;
    }
    public String getOperater() {
        return operater;
    }
    public void setOperater(String operater) {
        this.operater = operater;
    }
    public String getCustomNo() {
        return customNo;
    }
    public void setCustomNo(String customNo) {
        this.customNo = customNo;
    }
    public String getBackDate() {
        return backDate;
    }
    public void setBackDate(String backDate) {
        this.backDate = backDate;
    }
    public String getRejectFlag() {
        return rejectFlag;
    }
    public void setRejectFlag(String rejectFlag) {
        this.rejectFlag = rejectFlag;
    }
    public String getRejectDate() {
        return rejectDate;
    }
    public void setRejectDate(String rejectDate) {
        this.rejectDate = rejectDate;
    }
    public String getRejectSign() {
        return rejectSign;
    }
    public void setRejectSign(String rejectSign) {
        this.rejectSign = rejectSign;
    }
}
