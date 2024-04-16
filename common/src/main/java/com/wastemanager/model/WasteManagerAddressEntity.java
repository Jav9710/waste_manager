package com.wastemanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "waste_manager_addresses")
public class WasteManagerAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String direccion;

    @Column(name = "is_enabled")
    private Boolean isEnabled = Boolean.TRUE;

    @Version
    private Long version = 0L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
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

