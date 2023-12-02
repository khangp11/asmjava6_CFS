package com.poly.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name="users")
public class Users {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String image;
    private String fullname;
    private String gmail;
    private String phone_number;
    private String address;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    
    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
    
}
