package ru.itis.deshevin.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DrugEntity extends BaseEntity {

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private AnalogueClassEntity analogueClass;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

}
