package com.semabaef.kotikiryadom.components.cat.entity;


import com.semabaef.kotikiryadom.components.condition.entity.Condition;
import com.semabaef.kotikiryadom.components.coordinates.entity.Coordinates;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "photo_url")
    private String photoUrl;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "condition_id")
    private Condition condition;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "coordinates_id")
    private Coordinates coordinates;

    @Column(name = "description")
    private String description;
}
