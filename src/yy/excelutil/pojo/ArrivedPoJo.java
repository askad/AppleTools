package yy.excelutil.pojo;

/*
 * Arrived Report
 * 运抵范本
 */
public class ArrivedPoJo extends BasePoJo {
    private String shipName;// 船名
    private String shipNo;// 航次
    private String mSeabillNo;// 海运提单号
    private String mbillNo;// 提运单号
    private String count;// 件数
    private String weight;// 毛重
    private String name;// 品名

    public String getmSeabillNo() {
        return mSeabillNo;
    }

    public void setmSeabillNo(String mSeabillNo) {
        this.mSeabillNo = mSeabillNo;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    public String getMbillNo() {
        return mbillNo;
    }

    public void setMbillNo(String mbillNo) {
        this.mbillNo = mbillNo;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
