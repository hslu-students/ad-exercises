package ch.hslu.ad.exercise;

import java.util.concurrent.RecursiveTask;

public class ParallelFibonacci extends RecursiveTask<Integer> {

    private Integer number;
    public ParallelFibonacci(Integer number) {
        this.number = number;
    }

    @Override
    protected Integer compute() {
        if (this.number > 1) {
            var task1 = new ParallelFibonacci(number - 1).fork();
            var task2 = new ParallelFibonacci(number - 2).fork();
            return task1.join() + task2.join();
        } else {
            return number;
        }
    }
}