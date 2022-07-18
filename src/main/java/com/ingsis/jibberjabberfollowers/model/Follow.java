package com.ingsis.jibberjabberfollowers.model;

import javax.persistence.*;

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
    private String followee;
    private String follower;

    public Follow() {
    }

    public Follow(String followee, String follower) {
        this.followee = followee;
        this.follower = follower;
    }

    public void setFollowee(String followee) {
        this.followee = followee;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollower() {
        return follower;
    }

    public String getFollowee() {
        return followee;
    }

    public Long getId() {
        return id;
    }
}
