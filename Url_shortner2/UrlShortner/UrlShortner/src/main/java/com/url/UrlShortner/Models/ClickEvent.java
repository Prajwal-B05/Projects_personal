package com.url.UrlShortner.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
public class ClickEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ClickId;

    @CreationTimestamp
    private LocalDate ClickDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "MappingId")
    private UrlMapping urlMapping;
}
