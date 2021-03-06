package com.ahmed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator{
    // == Fields ==
    private final Random random = new Random();
    private final int maxNumber;
    private final int minNumber;

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    @Override
    public int next() {
        // example:  min=5 max=20 -> max-min=15 -> range 0-15 + min(5) -> 5-20
        return random.nextInt(maxNumber - minNumber) + minNumber ;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
