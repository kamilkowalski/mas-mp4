package custom;

public class Payment {
    private String method;
    private double value;

    public Payment(String method, double value) {
        setMethod(method);
        setValue(value);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
