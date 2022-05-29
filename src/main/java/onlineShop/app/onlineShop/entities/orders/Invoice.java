package onlineShop.app.onlineShop.entities.orders;

import onlineShop.app.onlineShop.entities.people.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice {
    @GeneratedValue
    @Id
    private long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private Date invoiceDate;
    private Date invoicePayed;
    @OneToMany
    private List<OrderItem> ordering;

    public List<OrderItem> getOrdering() {
        return ordering;
    }

    public void setOrdering(List<OrderItem> ordering) {
        this.ordering = ordering;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getInvoicePayed() {
        return invoicePayed;
    }

    public void setInvoicePayed(Date invoicePayed) {
        this.invoicePayed = invoicePayed;
    }


}
