package org.achkata.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{
    private String title;
    @Column(columnDefinition = "text", nullable = false)
    private String url;
    @ManyToOne(optional = false)
    private User author;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Route route;



}
