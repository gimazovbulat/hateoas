package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hotel {
    @Id
    private Long id;
    private String name;
    private Integer stars;
    @Column(name = "big")
    private Boolean isBig;
    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST}, orphanRemoval = true)
    private List<Resident> residents;
}
