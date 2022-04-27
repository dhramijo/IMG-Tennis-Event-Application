package com.img.tennistournament.models;


import com.img.tennistournament.models.enumeration.LicenseType;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "License")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class License {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Enumerated(EnumType.STRING)
  private LicenseType licenseType;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "licenses")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Set<Customer> customers = new HashSet<>();

}
