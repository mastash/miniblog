package pl.sda.spiring.miniblog12.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 200)
    private String title;

    @Column(name = "comment", length = 4000)
    private String commnent;

//    @Column(name = "text", length = 250)
//    private String text;

    @Column(name="added")
    private LocalDateTime added;// = LocalDateTime.now();
    }
