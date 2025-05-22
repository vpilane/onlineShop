package group1.tut.entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String orderNo;
    private boolean isPaid;
    private boolean isPicked;
    private boolean isDelivered;
    private String trackOrder;

    public Orders( String orderNo, boolean isPaid, boolean isPicked, boolean isDelivered, String trackOrder) {
        this.orderNo = orderNo;
        this.isPaid = isPaid;
        this.isPicked = isPicked;
        this.isDelivered = isDelivered;
        this.trackOrder = trackOrder;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
    public void setIsPicked(boolean isPicked) {
        this.isPicked = isPicked;
    }
    public void setIsDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }
    public void setTrackOrder(String trackOrder) {
        this.trackOrder = trackOrder;
    }
    public String getTrackOrder() {
        return trackOrder;
    }   
    public boolean getIsPaid() {
        return isPaid;
    }
    public boolean getIsPicked() {
        return isPicked;
    }
    public boolean getIsDelivered() {
        return isDelivered;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public Long getId() {
        return id;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isPaid() {
        return isPaid;
    }
    public boolean isPicked() {
        return isPicked;
    }
    public boolean isDelivered() {
        return isDelivered;
    }
  

}
