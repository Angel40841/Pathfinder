package org.achkata.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{
    @Column(nullable = false)
    private boolean approved;
    @Column(nullable = false)
    private Instant created;
    @Column(columnDefinition = "text", nullable = false, name = "text_content")
    private String content;
    @ManyToOne(optional = false)
    private User author;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Route route;
}
