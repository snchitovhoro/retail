package co.za.furniture.pnp.retail.model;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String productId;

    private Long categoryId;

    @NotBlank(message = "Product Name cannot be blank")
    private String productName;

    private String image;

    private Double productCost;
    private Double productPrice;
    private int quantity;
    @LastModifiedDate private DateTimeAtCompleted lastUpdate;

    public Product() {
    }

    public Product(String productId, Long categoryId, String productName, String image,
                   Double productCost, Double productPrice, int quantity, DateTimeAtCompleted lastUpdate) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.image = image;
        this.productCost = productCost;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public DateTimeAtCompleted getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(DateTimeAtCompleted lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", categoryId=" + categoryId +
                ", productName='" + productName + '\'' +
                ", image='" + image + '\'' +
                ", productCost=" + productCost +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getQuantity() == product.getQuantity() &&
                getId().equals(product.getId()) &&
                getProductId().equals(product.getProductId()) &&
                Objects.equals(getCategoryId(), product.getCategoryId()) &&
                getProductName().equals(product.getProductName()) &&
                Objects.equals(getImage(), product.getImage()) &&
                Objects.equals(getProductCost(), product.getProductCost()) &&
                getProductPrice().equals(product.getProductPrice()) &&
                Objects.equals(getLastUpdate(), product.getLastUpdate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductId(), getCategoryId(), getProductName(), getImage(), getProductCost(), getProductPrice(), getQuantity(), getLastUpdate());
    }
}
