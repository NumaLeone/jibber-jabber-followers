package com.ingsis.jibberjabberfollowers.Service;

import com.ingsis.jibberjabberfollowers.Repository.FollowRepository;
import com.ingsis.jibberjabberfollowers.model.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FollowService {
    private final FollowRepository followRepository;


    @Autowired
    public FollowService(FollowRepository followRepository){ this.followRepository = followRepository; }

    public List<Follow> getAllFollows(){return followRepository.findAll();}

    public void followUser(UUID followerId, UUID followeeId){
        Follow follow = followRepository.findFollowByFollowerAndFollowee(followerId,followeeId);
        if(follow != null){
            followRepository.delete(follow);
            throw new IllegalStateException("User " + follow.getFollower() +"unfollowed" + follow.getFollowee() + ".");
        }
        else {
            Follow newFollow = new Follow(followerId,followeeId);
            followRepository.save(newFollow);
        }
    }

    public void unfollow(UUID follower, UUID followee) {
        Follow follow = followRepository.findByFollowerAndFollowee(follower, followee).orElseThrow(() -> new IllegalArgumentException("No follow found"));
        followRepository.delete(follow);
    }

    public List<Follow> allFollowsByFollowee(UUID followee){
        return followRepository.findAllFollowByFollowee(followee);
    }
    public List<Follow> allFollowByFollowers(UUID follower){
        return followRepository.findAllFollowByFollower(follower);
    }

}
