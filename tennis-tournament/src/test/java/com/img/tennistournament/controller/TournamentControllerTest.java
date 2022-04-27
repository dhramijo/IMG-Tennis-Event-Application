package com.img.tennistournament.controller;

import static com.img.tennistournament.utils.CommonUtil.getMatches;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.img.tennistournament.models.Match;
import com.img.tennistournament.services.TournamentService;
import com.img.tennistournament.utils.ResourceFileLoaderUtils;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class TournamentControllerTest {

    @Autowired private MockMvc mvc;

    @MockBean private TournamentService tournamentService;

    @Test
    void test_get_list_of_matches() throws Exception {

        var matches = getMatches("payloads/Matches.json");

        var expectedMatches = Arrays.asList(matches);
        when(tournamentService.getAllMatchesByCustomerId(anyLong(), any())).thenReturn(expectedMatches);

        mvc.perform(get("/api/v1/customer/1/matches")
            .accept(MediaType.APPLICATION_JSON)
            .param("summaryType", ""))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(4)))
            .andExpect(jsonPath("$.[0].playerA", is(expectedMatches.get(0).getPlayerA())))
            .andExpect(jsonPath("$.[0].playerB", is(expectedMatches.get(0).getPlayerB())));
    }

    @Test
    void test_get_list_of_matches_with_avb() throws Exception {

        var matches = getMatches("payloads/MatchesAVB.json");

        var expectedMatches = Arrays.asList(matches);
        when(tournamentService.getAllMatchesByCustomerId(anyLong(), any())).thenReturn(expectedMatches);

        mvc.perform(get("/api/v1/customer/1/matches")
            .accept(MediaType.APPLICATION_JSON)
            .param("summaryType", "AVB"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(4)))
            .andExpect(jsonPath("$.[0].playerA", is(expectedMatches.get(0).getPlayerA())))
            .andExpect(jsonPath("$.[0].playerB", is(expectedMatches.get(0).getPlayerB())))
            .andExpect(jsonPath("$.[0].summary",
                is(expectedMatches.get(0).getPlayerA() + " vs " + expectedMatches.get(0).getPlayerB())));
    }

    @Test
    void test_get_list_of_matches_with_avb_time() throws Exception {

        var matches = getMatches("payloads/MatchesAVBTime.json");

        var expectedMatches = Arrays.asList(matches);
        when(tournamentService.getAllMatchesByCustomerId(anyLong(), any())).thenReturn(expectedMatches);

        mvc.perform(get("/api/v1/customer/1/matches")
            .accept(MediaType.APPLICATION_JSON)
            .param("summaryType", "AVB_TIME"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(4)))
            .andExpect(jsonPath("$.[0].playerA", is(expectedMatches.get(0).getPlayerA())))
            .andExpect(jsonPath("$.[0].playerB", is(expectedMatches.get(0).getPlayerB())))
            .andExpect(jsonPath("$.[0].summary", containsString("started")))
            .andExpect(jsonPath("$.[1].summary", containsString("starts")));
    }
}
