package com.ingsis.jibberjabberfollowers.Service;

import com.ingsis.jibberjabberfollowers.Repository.FollowRepository;
import com.ingsis.jibberjabberfollowers.model.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowService {
    private final FollowRepository followRepository;

    @Autowired
    public FollowService(FollowRepository followRepository){ this.followRepository = followRepository; }

    public List<Follow> getAllFollows(){return followRepository.findAll();}

    public void followUser(Follow follow){
        if(!followRepository.findAllFollowByFollower(follow.getFollower()).contains(follow)){
            followRepository.save(follow);
        }
        else {throw new IllegalStateException("This user already follows " + follow.getFollowee() +".");}
    }

    public void unfollowUser(Follow follow){
        if(getFollowees(follow.getFollower()).contains(follow)){
            followRepository.delete(follow);
        }

        else {throw new IllegalStateException(follow.getFollower() + " doesn't follow " + follow.getFollowee() +".");}
    }
    public List<String> allFollowersByFollowee(String followee){
        return getFollowers(followee);
    }
    public List<Follow> allFolloweeByFollowers(String follower){
        return followRepository.findAllFollowByFollower(follower);
    }

    public List<String> getFollowers(String followee){
        List<String> followers = new ArrayList<>();
        for (Follow follow : followRepository.findAllFollowByFollowee(followee)) {
            followers.add(follow.getFollower());
        }
        return followers;
    }
    public List<String> getFollowees(String follower){
        List<String> followers = new ArrayList<>();
        for (Follow follow : followRepository.findAllFollowByFollowee(follower)) {
            followers.add(follow.getFollowee());
        }
        return followers;
    }

}
