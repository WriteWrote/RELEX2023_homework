package org.obukhova.ssr.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users", schema = "ssr2023_hometask")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @ManyToMany//(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "userroles", schema = "ssr2023_hometask",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<RoleEntity> userRoles;

    public UserEntity() {
    }
}
