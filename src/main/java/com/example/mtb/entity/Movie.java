package com.example.mtb.entity;
import com.example.mtb.enums.Certificate;
import com.example.mtb.enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "movie_id")
    private String movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ElementCollection
    private Set<String> castList;

    @Column(name = "runtime")
    private Duration runtime;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "certificate")
    private Certificate certificate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

}

