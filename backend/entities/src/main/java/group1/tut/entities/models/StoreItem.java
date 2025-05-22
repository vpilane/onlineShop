package group1.tut.entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StoreItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;
    private double price;
    private String imageURL;
    private String category;
    private int quantity;

    public StoreItem() {
    }

    

    public StoreItem(String name, double price, String imageURL, String category, int quantity) {
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
        this.category = category;
        this.quantity = quantity;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getQuantity() {
        return quantity;
    }   
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return imageURL;
    }

    public void setImage(String image) {
        this.imageURL = image;
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
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        StoreItem other = (StoreItem) object;
        if (id == null || other.id == null) return false;
        return id.equals(other.id);
    }

    @Override
    public String toString() {
        return "za.ac.tut.entities.StoreItem[ id=" + id + " ]";
    }
}
