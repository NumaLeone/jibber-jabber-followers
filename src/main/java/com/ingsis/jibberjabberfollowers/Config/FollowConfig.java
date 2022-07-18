package com.ingsis.jibberjabberfollowers.Config;

import com.ingsis.jibberjabberfollowers.Repository.FollowRepository;
import com.ingsis.jibberjabberfollowers.model.Follow;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FollowConfig {
    @Bean
    CommandLineRunner commandLineRunner(FollowRepository followRepository){
        return args -> {
            Follow follow = new Follow("numa","guido");
            Follow follow1 = new Follow("numa", "milba");
            List<Follow> testFollows = new ArrayList<>();
            testFollows.add(follow);
            testFollows.add(follow1);
            followRepository.saveAll(testFollows);
        };
    }
}
