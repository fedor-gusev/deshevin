package ru.itis.deshevin.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "drugs")
@ToString(exclude = "drugs")
@Table(name = "category")
public class CategoryEntity extends BaseEntity {

    private String title;

    @OneToMany(mappedBy = "category")
    private Set<DrugEntity> drugs;

}
