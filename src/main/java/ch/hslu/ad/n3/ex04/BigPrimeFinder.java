package ch.hslu.ad.sw07.ex04;

import java.math.BigInteger;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Callable;

public class BigPrimeFinder implements Callable<BigInteger> {

    private static final int NUM_BITS = 1024;

    @Override
    public BigInteger call() throws Exception {
        boolean foundPrime = false;
        BigInteger number;
        do {
            number = new BigInteger(NUM_BITS, new Random());
            foundPrime = number.isProbablePrime(Integer.MAX_VALUE);
        } while (!foundPrime);
        return number;
    }

}
