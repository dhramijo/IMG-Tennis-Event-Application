package com.img.tennistournament.repository;

import com.img.tennistournament.models.Match;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
  List<Match> findMatchesByCustomersId(Long customerId);
  boolean existsByCustomersId(Long customerId);
}
