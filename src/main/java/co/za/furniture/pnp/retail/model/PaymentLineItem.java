package co.za.furniture.pnp.retail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class PaymentLineItem {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;
    private Double amount;
    private PaymentType paymentType;
    private Long paymentId;
    private Date paymentDate;

    public PaymentLineItem() {
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "PaymentLineItem{" +
                "amount=" + amount +
                ", paymentType=" + paymentType +
                ", paymentId=" + paymentId +
                ", paymentDate=" + paymentDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentLineItem)) return false;
        PaymentLineItem that = (PaymentLineItem) o;
        return id.equals(that.id) &&
                getAmount().equals(that.getAmount()) &&
                getPaymentType() == that.getPaymentType() &&
                getPaymentId().equals(that.getPaymentId()) &&
                getPaymentDate().equals(that.getPaymentDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getAmount(), getPaymentType(), getPaymentId(), getPaymentDate());
    }
}
