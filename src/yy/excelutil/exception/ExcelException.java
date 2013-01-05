package yy.excelutil.exception;

public class ExcelException extends Exception {
    String msgId;
    String msg;
    String[] params;

    public ExcelException(String msg) {
        super();
        this.msg = msg;
    }
    public String getMsgId() {
        return msgId;
    }
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String[] getParams() {
        return params;
    }
    public void setParams(String[] params) {
        this.params = params;
    }

}
