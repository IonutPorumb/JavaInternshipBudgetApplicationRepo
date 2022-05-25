package com.accenture.transactionapplication.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@ToString
@Getter
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity {
    @Column(nullable = false, length = 150)
    private String name;

}
