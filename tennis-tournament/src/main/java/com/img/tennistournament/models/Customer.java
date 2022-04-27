package com.img.tennistournament.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "customer_license",
      joinColumns = { @JoinColumn(name = "customer_fk") },
      inverseJoinColumns = { @JoinColumn(name = "license_fk") }
  )
  @EqualsAndHashCode.Exclude
  private Set<License> licenses = new HashSet<>();

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "customer_match",
      joinColumns = { @JoinColumn(name = "customer_fk") },
      inverseJoinColumns = { @JoinColumn(name = "match_fk") }
  )
  @EqualsAndHashCode.Exclude
  private Set<Match> matches = new HashSet<>();

}
