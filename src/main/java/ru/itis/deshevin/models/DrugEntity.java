package ru.itis.deshevin.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"analogueClass", "category", "users"})
@ToString(exclude = {"analogueClass", "users"})
@Table(name = "drug")
public class DrugEntity extends BaseEntity {

    private String title;

    @Column(columnDefinition="TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private AnalogueClassEntity analogueClass;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToMany(mappedBy = "favorites", cascade = CascadeType.DETACH)
    private Set<UserEntity> users;
}
