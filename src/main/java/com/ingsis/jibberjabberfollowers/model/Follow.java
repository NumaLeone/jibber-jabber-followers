package com.ingsis.jibberjabberfollowers.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Follow {

    @Id
    @SequenceGenerator(
            name = "follow_sequence",
            sequenceName = "follow_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "follow_sequence"
    )
    private Long id;
    private UUID followee;
    private UUID follower;

    public Follow() {
    }

    public Follow(UUID follower, UUID followee) {
        this.followee = followee;
        this.follower = follower;
    }

    public void setFollowee(UUID followee) {
        this.followee = followee;
    }

    public void setFollower(UUID follower) {
        this.follower = follower;
    }

    public UUID getFollower() {
        return follower;
    }

    public UUID getFollowee() {
        return followee;
    }

    public Long getId() {
        return id;
    }
}
