package com.example.springbootweb.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @NotBlank(message = "name is mandatory")
    private String name;
    @Email(message = "email not formatted correct")
    private String email;
    @Positive(message = "age is mandatory")
    private int age;
    private String contact_no;
    //@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="student_id",referencedColumnName = "id")
    //@JsonManagedReference
    private List<Address> address;

}
