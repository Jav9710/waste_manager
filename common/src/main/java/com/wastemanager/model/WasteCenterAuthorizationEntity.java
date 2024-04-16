package com.wastemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private String authorizationNumber;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "waste_manager_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private WasteManagerEntity wasteManager;

}