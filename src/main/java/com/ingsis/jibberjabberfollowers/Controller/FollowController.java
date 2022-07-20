package com.ingsis.jibberjabberfollowers.Controller;

import com.ingsis.jibberjabberfollowers.Service.FollowService;
import com.ingsis.jibberjabberfollowers.model.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "v1/follow")
public class FollowController {

    private final FollowService followService;

    @Autowired
    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @GetMapping(path="/getAll")
    public List<Follow> getFollows() {
        return followService.getAllFollows();
    }
    @PostMapping("/{followerId}/{followeeId}")
    public void followUser(@PathVariable UUID followerId, @PathVariable UUID followeeId){
        followService.followUser(followerId,followeeId);
    }


//    @PostMapping("/{followId}")
//    public void follow(@Valid @PathVariable("followId") UUID userId) {
//        followService.follow(userId);
//    }


    @DeleteMapping("/user/{follower}/unfollow/{followee}")
    public void unfollowUser(@PathVariable UUID follower, @PathVariable UUID followee){
        followService.unfollow(follower,followee);
    }
    @GetMapping(path = "followee/{followee}")
    public List<Follow> getAllFollowersByFollowee(@PathVariable("followee") UUID followee){
     return followService.allFollowsByFollowee(followee);
    }
    @GetMapping(path = "follower/{follower}")
    public List<Follow> getAllFolloweeByFollower(@PathVariable("follower") UUID follower){
        return followService.allFollowByFollowers(follower);
    }
}
