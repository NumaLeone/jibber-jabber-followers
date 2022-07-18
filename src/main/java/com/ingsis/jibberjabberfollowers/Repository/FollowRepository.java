package com.ingsis.jibberjabberfollowers.Repository;

import com.ingsis.jibberjabberfollowers.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findAllFolloweeByFollower(String follower);
    List<Follow> findAllFollowerByFollowee(String followee);

    List<Follow> findAllFollowByFollowee(String followee);

    List<Follow> findAllFollowByFollower(String follower);
}
