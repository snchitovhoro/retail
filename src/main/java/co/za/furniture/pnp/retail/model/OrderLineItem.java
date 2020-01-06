package co.za.furniture.pnp.retail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class OrderLineItem {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;
    private int quantity;
    private Long productId;

    public OrderLineItem() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "OrderLineItem{" +
                "quantity=" + quantity +
                ", productId=" + productId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderLineItem)) return false;
        OrderLineItem that = (OrderLineItem) o;
        return getQuantity() == that.getQuantity() &&
                id.equals(that.id) &&
                getProductId().equals(that.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getQuantity(), getProductId());
    }
}
