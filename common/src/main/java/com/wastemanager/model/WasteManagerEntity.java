package com.wastemanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "waste_managers")
public class WasteManagerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String nif;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "waste_manager_address_id")
    private WasteManagerAddressEntity address; // Use a descriptive name

    @OneToMany(mappedBy = "wasteManager", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WasteCenterAuthorizationEntity> listOfWasteCenterAuthorizations = new ArrayList<>(); // Use plural form

    @Column(name = "is_enabled")
    private Boolean enabled = Boolean.TRUE;

    @Version
    private Long version = 0L;

    @CreationTimestamp
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;
}
