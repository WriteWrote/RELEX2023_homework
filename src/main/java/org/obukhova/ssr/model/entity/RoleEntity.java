package org.obukhova.ssr.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @ManyToMany//(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "userroles", schema = "ssr2023_hometask",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private List<UserEntity> users;

    public RoleEntity(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public RoleEntity() {
    }
}
