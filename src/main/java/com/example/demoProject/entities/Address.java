package com.example.demoProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_user_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_address", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500,name = "address")
    private String address;

    @Enumerated
    private addressType addressType;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "user_address_id")
    private User user;

    public enum addressType{
        HOME_address,
        WORK_address,
        OTHER
    }
}
