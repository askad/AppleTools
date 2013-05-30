package yy.excelutil.pojo;

/*
 * Booking Detail
 * 委托明细
 */
public class BookingDetailPoJo extends BasePoJo {

    private String shipName;// 船名
    private String shipNo;// 航次
    private String mbillNo;// 出口拼箱准单号
    private String name;// 货物名称
    private String count;// 件数
    private String packageType;// 包装类型
    private String weight;// 毛重
    private String volume;// 体积
    private String comments;// 备注

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
