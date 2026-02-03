package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.Feed;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Long> {
}
