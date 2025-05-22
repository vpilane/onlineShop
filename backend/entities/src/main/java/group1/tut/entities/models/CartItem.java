package group1.tut.entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CartItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @Column(unique = true)
    private String name;
    private double price;
    private String imageUrl;
    private int quantity;

    public CartItem() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }   
    public CartItem(Long id, String name, double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return imageUrl;
    }

    public void setImage(String image) {
        this.imageUrl = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CartItem)) {
            return false;
        }
        CartItem other = (CartItem) object;
        return (this.id != null && this.id.equals(other.id)) || (this.id == null && other.id == null);
    }

    @Override
    public String toString() {
        return "za.ac.tut.entities.CartItem[ id=" + id + " ]";
    }
    
}
