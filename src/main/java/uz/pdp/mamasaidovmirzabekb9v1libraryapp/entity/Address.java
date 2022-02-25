package uz.pdp.mamasaidovmirzabekb9v1libraryapp.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String home;



}
