package group1.tut.entities.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Store {
    @Id
    private Long storeId;
    private String storeName;
    private String storeLocation;
    private String storeContact;
    private boolean isSpecialOffer;
    private Date storeOfferStartDate;
    private Date storeOfferEndDate;

    public Store() {
    }
    public Store(Long storeId, String storeName, String storeLocation, String storeContact, 
            boolean isSpecialOffer, Date storeOfferStartDate, Date storeOfferEndDate) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeLocation = storeLocation;
        this.storeContact = storeContact;
        this.isSpecialOffer = isSpecialOffer;
        this.storeOfferStartDate = storeOfferStartDate;
        this.storeOfferEndDate = storeOfferEndDate;
    }
    public Long getStoreId() {
        return storeId;
    }
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getStoreLocation() {
        return storeLocation;
    }
    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }
    public String getStoreContact() {
        return storeContact;
    }
    public void setStoreContact(String storeContact) {
        this.storeContact = storeContact;
    }
    
    
    public boolean isSpecialOffer() {
        return isSpecialOffer;
    }
    public void setSpecialOffer(boolean isSpecialOffer) {
        this.isSpecialOffer = isSpecialOffer;
    }
    public Date getStoreOfferStartDate() {
        return storeOfferStartDate;
    }
    public void setStoreOfferStartDate(Date storeOfferStartDate) {
        this.storeOfferStartDate = storeOfferStartDate;
    }
    public Date getStoreOfferEndDate() {
        return storeOfferEndDate;
    }
    public void setStoreOfferEndDate(Date storeOfferEndDate) {
        this.storeOfferEndDate = storeOfferEndDate;
    }
    
     
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeId != null ? storeId.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Store other = (Store) object;
        if (storeId == null || other.storeId == null) return false;
        return storeId.equals(other.storeId);
    }

    
}
