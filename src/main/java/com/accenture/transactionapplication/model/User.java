package com.accenture.transactionapplication.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Getter
@Table(name = "users")
public class User extends BaseEntity {
    @Column(nullable = false, length = 200, name = "userName")
    private String userName;
    @Column(nullable = false, length = 150, name = "password")
    private String password;
    @ManyToMany
    private Set<Transaction> linkRoles;
}
