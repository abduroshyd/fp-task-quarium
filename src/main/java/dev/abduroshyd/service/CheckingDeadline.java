package dev.abduroshyd.service;

import dev.abduroshyd.constants.Messages;
import dev.abduroshyd.payload.Fish;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class to check if a {@link Fish} object has reached its deadline.
 *
 * @author @abduroshyd
 * @version 1.0
 * @since 02/02/23
 */
public class CheckingDeadline implements Runnable {

    /**
     * The Fish object to be checked for its deadline.
     */
    private Fish fish;

    private List<Fish> fishList;

    /**
     * Overridden method from the {@link Runnable} interface to run the thread.
     */
    @Override
    public void run() {
        while (!fish.getDeadline().isBefore(LocalDateTime.now())) {

        }

        fishDiedMessage();

        fishList.remove(fish);

        if (fishList.isEmpty()){
            System.out.println(Messages.noMoreFishLeft);
            System.exit(0);
        }

    }

    /**
     * A method to print a message indicating that the fish has reached its deadline.
     */
    private void fishDiedMessage() {
        System.out.println(
                "\n" + "\033[31m" +
                        fish + "- baliq umrini yashab bo'ldi" +
                        "\033[0m"
        );
    }


    public CheckingDeadline(Fish fish, List<Fish> fishList) {
        this.fish = fish;
        this.fishList = fishList;
    }

    /**
     * A default constructor.
     */
    public CheckingDeadline() {
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }
}