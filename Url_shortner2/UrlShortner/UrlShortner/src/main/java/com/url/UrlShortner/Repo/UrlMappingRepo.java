package com.url.UrlShortner.Repo;

import com.url.UrlShortner.Models.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlMappingRepo extends JpaRepository<UrlMapping,Long> {
}
