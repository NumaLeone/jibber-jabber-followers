package com.ingsis.jibberjabberfollowers.Repository;

import com.ingsis.jibberjabberfollowers.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FollowRepository extends JpaRepository<Follow, UUID> {
    List<Follow> findAllFollowByFollowee(UUID followee);

    List<Follow> findAllFollowByFollower(UUID follower);

    Optional<Follow> findByFollowerAndFollowee(UUID follower, UUID followee);

    Follow findFollowByFollowerAndFollowee(UUID follower, UUID followee);

}
