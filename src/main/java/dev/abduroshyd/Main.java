/**
 * Main class which performs various functionalities for an aquarium.
 *
 * @author @abduroshyd
 * @version 1.0
 */
package dev.abduroshyd;

import dev.abduroshyd.config.AppConfig;
import dev.abduroshyd.constants.Messages;
import dev.abduroshyd.payload.Fish;
import dev.abduroshyd.service.*;

import java.util.*;

/**
 * Created by @abduroshyd on 03/02/23.
 */
public class Main {

    /**
     * A list of Fish objects.
     */
    private static List<Fish> fishList;

    /**
     * Main method which initializes the aquarium and fill it with fish.
     * Then performs system commands to add, check, and print fishes.
     *
     * @param args An array of command-line arguments passed to the program.
     * @throws InterruptedException Thrown when a thread is waiting, sleeping, or otherwise occupied,
     *                              and the thread is interrupted, either before or during the activity.
     */
    public static void main(String[] args) throws InterruptedException {

        // Initializes the aquarium
        int fishCount = InitializeAquarium.initializeAquarium();

        // Fill the aquarium with fish
        fishList = FillAquarium.fillAquariumWithFish(fishCount);

        // Check the deadline of all fish, each in a separate threads
        CheckAllFishDeadlines checkDeadlines = new CheckAllFishDeadlines(fishList);
        checkDeadlines.checkAllFishDeadlinesInDifferentThreads();

        // Loop until all fish are dead
        while (!fishList.isEmpty()) {
            meeting();
        }

    }

    /**
     * A method which prints the list of fish.
     */
    private static void printFishList() {
        for (Fish fish : fishList) {
            System.out.println(fish);
        }
    }



    private static void meeting() {
        if (fishList.size() > 1) {
            Fish first = fishList.get(new Random().nextInt(fishList.size()));
            Fish second = fishList.get(new Random().nextInt(fishList.size()));
            if (!first.getMale().equals(second.getMale())) {
                new CheckAllFishDeadlines(fishList).checkAllFishDeadlinesInDifferentThreads(addFish());
            } else {
                System.out.println(Messages.genderIsNotEqual);
            }
        } else {
            System.out.println(Messages.noMoreFishLeftForMeeting);
        }

        int totalMills = new Random().nextInt(1000);

        int seconds = (totalMills / 100);

        System.out.println(seconds + "s dan keyin yangi uchrashuv bo'lib o'tadi");

        try {
            Thread.sleep(totalMills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method adds a new fish to the fish list.
     * If the maximum capacity of the list has reached,
     * the method will print a message indicating that
     * the list is out of capacity and terminate the program.
     * <p>
     * Otherwise, it will add the new fish to the list,
     * retrieve the reference to the newly added fish,
     * and print a message indicating the successful addition of the fish.
     *
     * @return the newly added fish
     */
    private static Fish addFish() {
        if (fishList.size() >= AppConfig.MAX_CAPACITY) {
            System.out.println(Messages.outOfCapacity);
            System.exit(0);
        }

        fishList.add(new Fish());
        Fish fish = fishList.get(fishList.size() - 1);
        System.out.println(fish + " => " + Messages.successFullySaved);
        return fish;
    }
}