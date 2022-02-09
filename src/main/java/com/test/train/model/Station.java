package com.test.train.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Getter
@Setter
@Entity(name = "station")
public class Station {
    @Id
    private Integer id;
    private String name;

}
