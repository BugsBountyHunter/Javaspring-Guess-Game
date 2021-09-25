package com.ahmed;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class GameImpl implements Game{

    // == Fields ==
    private final NumberGenerator numberGenerator;
    private final int guessCount;

    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuess;
    private boolean validNumberRange = true;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator,@GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    // == init ==
    @PostConstruct
    @Override
    public void reset() {
        biggest = numberGenerator.getMaxNumber();
        smallest = numberGenerator.getMinNumber();
        guess = numberGenerator.getMinNumber();
        remainingGuess = guessCount;
        number = numberGenerator.next();

    }

    @PreDestroy
    public void preDestroy(){
        log.info("in Game preDestroy()");
    }

    // == Public Method ==
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuess;
    }

    @Override
    public int getGuessCount() {
        return guessCount;
    }



    @Override
    public void check() {
        checkValidNumberRange();
        if(validNumberRange){
            if(guess > number){
                biggest = guess - 1;
            }else if (guess < number){
                smallest = guess + 1;
            }
        }
        remainingGuess--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuess <= 0;
    }

    // == private methods ==
    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
