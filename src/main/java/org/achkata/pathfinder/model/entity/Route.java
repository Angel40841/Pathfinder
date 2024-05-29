package org.achkata.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "routes")
public class Route extends BaseEntity{
    @Column(columnDefinition = "LONGTEXT", name = "gpx_coordinates")
    private String gpxCoordinates;
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "video_url")
    private String videoUrl;
    @ManyToOne(optional = false)
    private User author;
    @OneToMany(targetEntity = Comment.class, mappedBy = "route")
    private Set<Comment> comments;
    @OneToMany(targetEntity = Picture.class, mappedBy = "route")
    private Set<Picture> pictures;
    @ManyToMany
    private Set<Category> categories;

    public Route() {
        this.comments = new HashSet<>();
        this.pictures = new HashSet<>();
        this.categories = new HashSet<>();
    }
}
