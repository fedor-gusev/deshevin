package ru.itis.deshevin.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.itis.deshevin.enums.Role;
import ru.itis.deshevin.enums.Status;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {

    /**
     * Business logic
     */

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany
    @JoinTable(
            name = "user_favorite_drugs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "drug_id")
    )
    private List<DrugEntity> favorites;

    /**
     * User info
     */

    private String username;

    private String firstName;

    private String lastName;

    private String city;

}
