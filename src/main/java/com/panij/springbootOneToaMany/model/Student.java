package com.panij.springbootOneToaMany.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    private String name;
    private String address;
    private String email;

    @OneToMany(targetEntity = Laptop.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="sid_fk",referencedColumnName = "sid")

    private List<Laptop> laptops;
}
