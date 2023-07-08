package org.obukhova.ssr.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles", schema = "ssr2023_hometask")
@Getter
@Setter
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    public RoleEntity(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public RoleEntity() {
    }
}
