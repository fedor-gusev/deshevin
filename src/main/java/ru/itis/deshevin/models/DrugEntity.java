package ru.itis.deshevin.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"analogueClass", "category"})
@ToString(exclude = "analogueClass")
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

}
