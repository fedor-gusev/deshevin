package ru.itis.deshevin.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DrugDto {
    private UUID id;
    private String title;
    private String description;

    private String category;

    private String analogueClass;

}
