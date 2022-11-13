package com.rocktech.dps.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "drugs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String image;
    private String description;
    private String sideEffect;
    private String dosage;
    private String age;
    private Date mfDate;
    private Date exDate;
}
