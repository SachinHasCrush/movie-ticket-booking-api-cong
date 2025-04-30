package com.example.mtb.entity;



import com.example.mtb.enums.ScreenType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@ToString
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String screenId;
    private ScreenType screenType;
    private Integer capacity;
    private Integer noOfRows;

    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.PERSIST)
    private List<Seat> seats;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    private String createdBy;


}


