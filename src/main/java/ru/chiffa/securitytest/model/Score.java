package ru.chiffa.securitytest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "scores")
@Data
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @Column(name = "value")
    private Integer value;
}
