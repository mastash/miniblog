package pl.sda.spiring.miniblog12.entity;

import lombok.Getter;
import lombok.Setter;



import javax.persistence.*;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="role_name", length = 25, unique = true)
    private String roleName;


}
