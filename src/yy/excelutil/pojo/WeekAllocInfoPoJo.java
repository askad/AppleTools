package yy.excelutil.pojo;

/*
 * 每周配货情况汇报
 */
public class WeekAllocInfoPoJo extends BasePoJo {
    private String date;// 日期
    private String destPort;// 目的港
    private String hblNo;// HB/L
    private String lclWeight;// lcl rt
    private String twenty;// 20‘
    private String forty;// 40‘
    private String freightRate;// 运价
    private String cnyRate;// 人民币收费
    private String stowageCompany;// 配载公司

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDestPort() {
        return destPort;
    }

    public void setDestPort(String destPort) {
        this.destPort = destPort;
    }

    public String getHblNo() {
        return hblNo;
    }

    public void setHblNo(String hblNo) {
        this.hblNo = hblNo;
    }

    public String getLclWeight() {
        return lclWeight;
    }

    public void setLclWeight(String lclWeight) {
        this.lclWeight = lclWeight;
    }

    public String getTwenty() {
        return twenty;
    }

    public void setTwenty(String twenty) {
        this.twenty = twenty;
    }

    public String getForty() {
        return forty;
    }

    public void setForty(String forty) {
        this.forty = forty;
    }

    public String getFreightRate() {
        return freightRate;
    }

    public void setFreightRate(String freightRate) {
        this.freightRate = freightRate;
    }

    public String getCnyRate() {
        return cnyRate;
    }

    public void setCnyRate(String cnyRate) {
        this.cnyRate = cnyRate;
    }

    public String getStowageCompany() {
        return stowageCompany;
    }

    public void setStowageCompany(String stowageCompany) {
        this.stowageCompany = stowageCompany;
    }
}
