public class RequestData {
    public static final String Type_REMOVE="remove";
    public static final String Type_REPLACE="replace";
    String origdata;
    String type;

    public String getOrigdata() {
        return origdata;
    }

    public void setOrigdata(String origdata) {
        this.origdata = origdata;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
