package com.img.tennistournament.services;

import com.img.tennistournament.exception.ResourceNotFoundException;
import com.img.tennistournament.models.Match;
import com.img.tennistournament.models.enumeration.SummaryType;
import com.img.tennistournament.repository.MatchRepository;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TournamentServiceImpl implements TournamentService {

  private final MatchRepository matchRepository;

  @Override
  public List<Match> getAllMatchesByCustomerId(Long customerId, SummaryType summaryType) {
    if (!matchRepository.existsByCustomersId(customerId)) {
      throw new ResourceNotFoundException("Matches Not found for Customer Id = " + customerId);
    }
    var retrievedMatches = matchRepository.findMatchesByCustomersId(customerId);
    if (summaryType != null) {
      buildMatchSummary(retrievedMatches, summaryType);
    }

    return retrievedMatches;
  }

  private void buildMatchSummary(List<Match> retrievedMatches, SummaryType summaryType) {

    if (SummaryType.AVB.equals(summaryType)) {
      retrievedMatches.forEach(match -> {
        var matchSummary = String.join(" vs ", match.getPlayerA(), match.getPlayerB());
        match.setSummary(matchSummary);
      });
    }

    if (SummaryType.AVB_TIME.equals(summaryType)) {
      retrievedMatches.forEach(match -> {
        var matchSummary = buildSummary(match);
        match.setSummary(matchSummary);
      });
    }
  }

  private String buildSummary(Match match) {
    var eventStartingTime = ChronoUnit.MINUTES.between(match.getStartDate(), LocalDateTime.now());
    if (eventStartingTime >= 0) {
      return String
          .format("%s vs %s, started %o minutes ago", match.getPlayerA(), match.getPlayerB(),
              eventStartingTime);
    } else {
      return String
          .format("%s vs %s, starts in %o minutes", match.getPlayerA(), match.getPlayerB(),
              eventStartingTime * -1);
    }
  }
}
