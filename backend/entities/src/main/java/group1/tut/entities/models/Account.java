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
public class Account  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String gender;
    private String contact;
    private String address;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;    
    private String role;
    private String trackOrder;
    private String orderNo;


}
