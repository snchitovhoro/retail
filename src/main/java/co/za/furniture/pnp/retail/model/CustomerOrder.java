package co.za.furniture.pnp.retail.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private int orderNumber;

    private OrderStatus orderStatus;

    private Double orderAmount;

    private Long customerId;

    @ManyToMany
    private List<OrderLineItem> orderLineItem;
    public CustomerOrder() {
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<OrderLineItem> getOrderLineItem() {
        return orderLineItem;
    }

    public void setOrderLineItem(List<OrderLineItem> orderLineItem) {
        this.orderLineItem = orderLineItem;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "orderNumber=" + orderNumber +
                ", orderStatus=" + orderStatus +
                ", orderAmount=" + orderAmount +
                ", customerId=" + customerId +
                ", orderLineItem=" + orderLineItem +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerOrder)) return false;
        CustomerOrder that = (CustomerOrder) o;
        return getOrderNumber() == that.getOrderNumber() &&
                id.equals(that.id) &&
                getOrderStatus() == that.getOrderStatus() &&
                getOrderAmount().equals(that.getOrderAmount()) &&
                Objects.equals(getCustomerId(), that.getCustomerId()) &&
                Objects.equals(getOrderLineItem(), that.getOrderLineItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getOrderNumber(), getOrderStatus(), getOrderAmount(), getCustomerId(), getOrderLineItem());
    }
}
