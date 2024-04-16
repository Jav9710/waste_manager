package com.wastemanager.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "waste_manager_address_id")
    private WasteManagerAddressEntity address;

    @JsonManagedReference
    @OneToMany(mappedBy = "wasteManager")
    private List<WasteCenterAuthorizationEntity> listOfWasteCenterAuthorizations = new ArrayList<>();

    @Column(name = "is_enabled")
    private Boolean enabled = Boolean.TRUE;

    @Version
    private Long version = 0L;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdDate;



    @LastModifiedDate
    private Date lastModifiedDate;

    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        createdDate = date;
        lastModifiedDate = date;
    }

    @PreUpdate
    protected void onUpdate() {
        lastModifiedDate = new Date();
    }
}
