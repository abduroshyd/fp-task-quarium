package dev.abduroshyd.service;

import dev.abduroshyd.payload.Fish;

import java.util.List;

/**
 * Class for checking the deadlines of all Fish objects in a separate Thread.
 *
 * @author @abduroshyd
 * @version 1.0
 * @since 03/02/23
 */
public class CheckAllFishDeadlines {

    private final List<Fish> fishList;

    /**
     * This method checks the deadlines of all Fish objects in the given list
     * in different Threads.
     *
     */
    public void checkAllFishDeadlinesInDifferentThreads() {
        // Loop through each Fish object in the fishList
        for (Fish fish : fishList) {
            // Check the deadline for the current Fish object in a separate Thread
            checkingDeadline(fish,fishList);
        }
    }

    /**
     * This method checks the deadline of a Fish object in a separate thread.
     *
     * @param fish The Fish object to be checked
     */
    public void checkAllFishDeadlinesInDifferentThreads(Fish fish) {
        checkingDeadline(fish,fishList);
    }

    /**
     * This method checks if a Fish object has reached its deadline.
     */
    private void checkingDeadline(Fish fish,List<Fish> fishList) {
        // Create a new CheckingDeadline object with the Fish object and its list as its parameter
        CheckingDeadline checkingDeadline = new CheckingDeadline(fish,fishList);

        // Create a new Thread object with the CheckingDeadline object as its parameter
        Thread thread = new Thread(checkingDeadline);

        // Start the Thread
        thread.start();
    }

    public CheckAllFishDeadlines(List<Fish> fishList) {
        this.fishList = fishList;
    }
}
