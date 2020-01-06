package co.za.furniture.pnp.retail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    @Column(unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(unique = true)
    private String customerID;
    private String customerAddress;
    private String emailAddress;
    private String customerFirstName;
    private String customerLastName;
    private String customerPhoneNumber;
    private String customerCellphoneNumber;

    public Customer() {
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerCellphoneNumber() {
        return customerCellphoneNumber;
    }

    public void setCustomerCellphoneNumber(String customerCellphoneNumber) {
        this.customerCellphoneNumber = customerCellphoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", customerCellphoneNumber='" + customerCellphoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(getCustomerID(), customer.getCustomerID()) &&
                Objects.equals(getCustomerAddress(), customer.getCustomerAddress()) &&
                Objects.equals(getEmailAddress(), customer.getEmailAddress()) &&
                Objects.equals(getCustomerFirstName(), customer.getCustomerFirstName()) &&
                Objects.equals(getCustomerLastName(), customer.getCustomerLastName()) &&
                Objects.equals(getCustomerPhoneNumber(), customer.getCustomerPhoneNumber()) &&
                Objects.equals(getCustomerCellphoneNumber(), customer.getCustomerCellphoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getCustomerID(), getCustomerAddress(), getEmailAddress(), getCustomerFirstName(), getCustomerLastName(), getCustomerPhoneNumber(), getCustomerCellphoneNumber());
    }
}
