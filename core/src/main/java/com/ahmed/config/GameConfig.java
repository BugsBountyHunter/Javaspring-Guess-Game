package com.ahmed.config;

import com.ahmed.GuessCount;
import com.ahmed.MaxNumber;
import com.ahmed.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:/config/game.properties"})
@ComponentScan(basePackages = {"com.ahmed"})
public class GameConfig {
    // == Fields ==
    @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.minNumber:5}")
    private int minNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    // == bean Methods ==

    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }

}
