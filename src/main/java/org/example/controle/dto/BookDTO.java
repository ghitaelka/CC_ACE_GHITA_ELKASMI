package org. example.controle.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BookDTO {
    private String titre;
    private String  publisher;
    private String  datePublication;
    private Double price;
    private String  resume;


}