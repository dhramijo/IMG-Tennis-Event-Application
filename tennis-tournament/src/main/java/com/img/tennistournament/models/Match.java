package com.img.tennistournament.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Match")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Match {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("matchId")
  private long id;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  @JsonProperty("startDate")
  private LocalDateTime startDate;

  @JsonProperty("playerA")
  private String playerA;

  @JsonProperty("playerB")
  private String playerB;

  @JsonProperty("summary")
  private String summary;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "matches")
  @JsonIgnore
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Customer> customers = new HashSet<>();

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "tournament_id")
  @JsonIgnore
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Tournament tournament;

}
