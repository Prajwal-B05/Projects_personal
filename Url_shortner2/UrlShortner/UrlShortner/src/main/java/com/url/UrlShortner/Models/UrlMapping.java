package com.url.UrlShortner.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class UrlMapping {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long MappingId;
    private Integer ClickCount;
    private String OriginalUrl;
    private String ShortUrl;
    @CreationTimestamp
    private LocalDate CreatedDate;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "urlMapping")
    private List<ClickEvent> ClickEvents;


}
