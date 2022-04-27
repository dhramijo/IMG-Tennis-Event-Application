package com.img.tennistournament.controller;

import com.img.tennistournament.models.Match;
import com.img.tennistournament.models.enumeration.SummaryType;
import com.img.tennistournament.services.TournamentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TournamentController {

  private final TournamentService tournamentService;

  @GetMapping("/customer/{customerId}/matches")
  public ResponseEntity<List<Match>> getAllMatchesByCustomerId(
      @PathVariable(value = "customerId") Long customerId,
      @RequestParam(name = "summaryType", required = false) SummaryType summaryType) {
    return new ResponseEntity<>(tournamentService.getAllMatchesByCustomerId(customerId, summaryType), HttpStatus.OK);
  }

}
