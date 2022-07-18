package com.ingsis.jibberjabberfollowers.Controller;

import com.ingsis.jibberjabberfollowers.Service.FollowService;
import com.ingsis.jibberjabberfollowers.model.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping
    public void followUser(@RequestBody Follow follow){
        followService.followUser(follow);
    }
    @DeleteMapping
    public void unfollowUser(@RequestBody Follow follow){
        followService.unfollowUser(follow);
    }
    @GetMapping(path = "/{followee}")
    public List<String> getAllFollowersByFollowee(@PathVariable("followee") String followee){
     return followService.allFollowersByFollowee(followee);
    }
}
