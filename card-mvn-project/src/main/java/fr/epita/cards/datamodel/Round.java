package fr.epita.cards.datamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROUNDS")
public class Round {

    @Id
    @Column(name = "ID")
    private int id;



}
