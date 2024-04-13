package com.wastemanager.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "waste_center_authorizations")
public class WasteCenterAuthorizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String authorizationNumber; // Use descriptive name

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "waste_manager_id")
    private WasteManagerEntity wasteManager; // Use singular form

    // Getters, Setters, and other methods
}