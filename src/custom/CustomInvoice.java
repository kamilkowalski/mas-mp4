package custom;

import java.util.HashSet;
import java.util.Set;

public class CustomInvoice {
    private String number;
    private double total;

    private Set<Payment> payments = new HashSet<>();

    public CustomInvoice(String number, double total) {
        setNumber(number);
        setTotal(total);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalPayments() {
        return payments.stream().mapToDouble(p -> p.getValue()).sum();
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void addPayment(Payment payment) throws Exception {
        if (!payments.contains(payment)) {
            double futureTotalPayments = getTotalPayments() + payment.getValue();
            if (futureTotalPayments > getTotal()) {
                throw new Exception("Płatności na kwotę " + futureTotalPayments + " przekraczają sumę  faktury " + getTotal());
            }

            payments.add(payment);
        }
    }
}
