package com.img.tennistournament.services;

import static org.assertj.core.api.Assertions.assertThat;

import com.img.tennistournament.repository.MatchRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = "/test-data.sql")
class TournamentServiceTest {

  @Autowired private TournamentService tournamentService;

  @Autowired private MatchRepository matchRepository;

  @Test
  void test_get_list_of_matches() {

    var matchesByCustomersId = matchRepository.findMatchesByCustomersId(1l);

    var returnedListOfMatches = tournamentService.getAllMatchesByCustomerId(1L, null);

    assertThat(matchesByCustomersId)
        .usingRecursiveFieldByFieldElementComparatorIgnoringFields("startDate", "summary")
        .isEqualTo(returnedListOfMatches);

  }
}