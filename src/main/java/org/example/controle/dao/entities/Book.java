package org. example.controle.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Book {
    @Id
    @GeneratedValue
    long id_Book;
    String titre;
    String publisher;
    String datePublication;
    double price;
    String resume;

}