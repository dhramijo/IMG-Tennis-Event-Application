package com.img.tennistournament.services;

import com.img.tennistournament.models.Match;
import com.img.tennistournament.models.enumeration.SummaryType;
import java.util.List;

public interface TournamentService {
  List<Match> getAllMatchesByCustomerId(Long customerId, SummaryType summaryType);
}
