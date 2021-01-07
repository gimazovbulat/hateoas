package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Resident {
    @Id
    private Long id;
    private String name;
    private Integer age;
    private Boolean wholeFloor;
    private Boolean isVip;

    public Resident bookWholeFloor(){
        if (wholeFloor == null){
            setWholeFloor(true);
            return this;
        }
        if (wholeFloor) {
            setWholeFloor(false);
        } else {
            setWholeFloor(true);
        }
        return this;
    }
}
