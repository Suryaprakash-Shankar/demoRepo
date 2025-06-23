package com.colllege.collegeDemo.Modle;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Test_Case")

public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Mobile")
    private String Mobile;

    @Column(name="Address")
    private String Address;


}
