package coderdudos.printdonation.connection.request;

public class PayRequest extends Request {

    private String nib, expiredate, code;

    public String getNib() {
        return nib;
    }

    public void setNib(String nib) {
        this.nib = nib;
    }

    public String getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(String expiredate) {
        this.expiredate = expiredate;
    }

    public String getCode() {
        return code;
    }

    public PayRequest(String nib, String expiredate, String code) {
        super();
        this.nib = nib;
        this.expiredate = expiredate;
        this.code = code;
        this.setRequestType(requestType.payment);
    }

    public void setCode(String code) {
        this.code = code;
    }
}