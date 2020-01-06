package co.za.furniture.pnp.retail.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;
    @ManyToMany
    private List<PaymentLineItem> paymentLineItems;
    private PaymentType paymentType;
    @CreatedDate private Date dateCreated;
    @LastModifiedDate private Date lastUpdate;
    private Double amount;
    private Long customerId;

    public Payment() {
    }

    public List<PaymentLineItem> getPaymentLineItems() {
        return paymentLineItems;
    }

    public void setPaymentLineItems(List<PaymentLineItem> paymentLineItems) {
        this.paymentLineItems = paymentLineItems;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentLineItems=" + paymentLineItems +
                ", paymentType=" + paymentType +
                ", dateCreated=" + dateCreated +
                ", lastUpdate=" + lastUpdate +
                ", amount=" + amount +
                ", customerId=" + customerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return id.equals(payment.id) &&
                Objects.equals(getPaymentLineItems(), payment.getPaymentLineItems()) &&
                getPaymentType() == payment.getPaymentType() &&
                getDateCreated().equals(payment.getDateCreated()) &&
                getLastUpdate().equals(payment.getLastUpdate()) &&
                getAmount().equals(payment.getAmount()) &&
                Objects.equals(getCustomerId(), payment.getCustomerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getPaymentLineItems(), getPaymentType(), getDateCreated(), getLastUpdate(), getAmount(), getCustomerId());
    }
}
