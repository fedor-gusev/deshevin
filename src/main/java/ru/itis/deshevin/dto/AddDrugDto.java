package ru.itis.deshevin.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddDrugDto {
    private String title;
    private String description;
    private UUID categoryId;
    private UUID analogueId;
}
