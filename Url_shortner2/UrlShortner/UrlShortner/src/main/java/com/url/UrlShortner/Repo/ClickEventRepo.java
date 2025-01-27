package com.url.UrlShortner.Repo;

import com.url.UrlShortner.Models.ClickEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickEventRepo extends JpaRepository<ClickEvent,Long> {
}
