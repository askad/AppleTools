package yy.excelutil.pojo;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class QuoteBillPoJo {
    // private String billNo;
    private String ton;
    private String cube;
    private BigDecimal coefficient;
    private String rate;

    private String paidDesc;
    private String collDesc;

    private List<String> audWmPaid;
    private List<String> usdWmPaid;
    private List<String> audCheckPaid;
    private List<String> usdCheckPaid;
    private List<String>[] allDataPaid = new List[4];

    private List<String> audWmColl;
    private List<String> usdWmColl;
    private List<String> audCheckColl;
    private List<String> usdCheckColl;
    private List<String>[] allDataColl = new List[4];

    private BigDecimal totalAudPaid;
    private BigDecimal totalUsdPaid;
    private BigDecimal totalAudColl;
    private BigDecimal totalUsdColl;
    private BigDecimal totalUsdRefund;
    private BigDecimal totalAudRefund;
    private BigDecimal totalRefund;

    public QuoteBillPoJo() {
        audWmPaid = new LinkedList<String>();
        usdWmPaid = new LinkedList<String>();
        audCheckPaid = new LinkedList<String>();
        usdCheckPaid = new LinkedList<String>();
        allDataPaid[0] = audWmPaid;
        allDataPaid[1] = usdWmPaid;
        allDataPaid[2] = audCheckPaid;
        allDataPaid[3] = usdCheckPaid;

        audWmColl = new LinkedList<String>();
        usdWmColl = new LinkedList<String>();
        audCheckColl = new LinkedList<String>();
        usdCheckColl = new LinkedList<String>();
        allDataColl[0] = audWmColl;
        allDataColl[1] = usdWmColl;
        allDataColl[2] = audCheckColl;
        allDataColl[3] = usdCheckColl;
    }

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public String getPaidDesc() {
        return paidDesc;
    }

    public void setPaidDesc(String paidDesc) {
        this.paidDesc = paidDesc;
    }

    public String getCollDesc() {
        return collDesc;
    }

    public void setCollDesc(String collDesc) {
        this.collDesc = collDesc;
    }

    public List<String> getAudWmPaid() {
        return audWmPaid;
    }

    public void setAudWmPaid(List<String> audWmPaid) {
        this.audWmPaid = audWmPaid;
    }

    public List<String> getUsdWmPaid() {
        return usdWmPaid;
    }



    public void setUsdWmPaid(List<String> usdWmPaid) {
        this.usdWmPaid = usdWmPaid;
    }



    public List<String> getAudCheckPaid() {
        return audCheckPaid;
    }



    public void setAudCheckPaid(List<String> audCheckPaid) {
        this.audCheckPaid = audCheckPaid;
    }



    public List<String> getUsdCheckPaid() {
        return usdCheckPaid;
    }



    public void setUsdCheckPaid(List<String> usdCheckPaid) {
        this.usdCheckPaid = usdCheckPaid;
    }



    public List<String>[] getAllDataPaid() {
        return allDataPaid;
    }



    public void setAllDataPaid(List<String>[] allDataPaid) {
        this.allDataPaid = allDataPaid;
    }



    public List<String> getAudWmColl() {
        return audWmColl;
    }



    public void setAudWmColl(List<String> audWmColl) {
        this.audWmColl = audWmColl;
    }



    public List<String> getUsdWmColl() {
        return usdWmColl;
    }



    public void setUsdWmColl(List<String> usdWmColl) {
        this.usdWmColl = usdWmColl;
    }



    public List<String> getAudCheckColl() {
        return audCheckColl;
    }



    public void setAudCheckColl(List<String> audCheckColl) {
        this.audCheckColl = audCheckColl;
    }



    public List<String> getUsdCheckColl() {
        return usdCheckColl;
    }



    public void setUsdCheckColl(List<String> usdCheckColl) {
        this.usdCheckColl = usdCheckColl;
    }



    public List<String>[] getAllDataColl() {
        return allDataColl;
    }



    public void setAllDataColl(List<String>[] allDataColl) {
        this.allDataColl = allDataColl;
    }



    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTon() {
        return ton;
    }

    public void setTon(String ton) {
        this.ton = ton;
    }

    public String getCube() {
        return cube;
    }

    public void setCube(String cube) {
        this.cube = cube;
    }

     public BigDecimal getTotalAudPaid() {
        return totalAudPaid;
    }

    public void setTotalAudPaid(BigDecimal totalAudPaid) {
        this.totalAudPaid = totalAudPaid;
    }

    public BigDecimal getTotalUsdPaid() {
        return totalUsdPaid;
    }

    public void setTotalUsdPaid(BigDecimal totalUsdPaid) {
        this.totalUsdPaid = totalUsdPaid;
    }

    public BigDecimal getTotalAudColl() {
        return totalAudColl;
    }

    public void setTotalAudColl(BigDecimal totalAudColl) {
        this.totalAudColl = totalAudColl;
    }

    public BigDecimal getTotalUsdColl() {
        return totalUsdColl;
    }

    public void setTotalUsdColl(BigDecimal totalUsdColl) {
        this.totalUsdColl = totalUsdColl;
    }

    public BigDecimal getTotalUsdRefund() {
        return totalUsdRefund;
    }

    public void setTotalUsdRefund(BigDecimal totalUsdRefund) {
        this.totalUsdRefund = totalUsdRefund;
    }

    public BigDecimal getTotalAudRefund() {
        return totalAudRefund;
    }

    public void setTotalAudRefund(BigDecimal totalAudRefund) {
        this.totalAudRefund = totalAudRefund;
    }

    public BigDecimal getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(BigDecimal totalRefund) {
        this.totalRefund = totalRefund;
    }
}
