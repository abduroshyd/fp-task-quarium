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
            systemCommands();
        }

    }

    /**
     * A method which performs system commands such as add fish, meeting of fishes, and print fish list.
     */
    private static void systemCommands() {
        printCommandList();

        Scanner in = new Scanner(System.in);

        System.out.print(Messages.selectCommand);

        try {
            int command = in.nextInt();
            switch (command) {
                case 1 -> {
                    Fish savedFish = addFish();
                    new CheckAllFishDeadlines(fishList)
                            .checkAllFishDeadlinesInDifferentThreads(savedFish);
                }
                case 2 -> {
                    meeting();
                }
                case 3 -> {
                    printFishList();
                }
                default -> {
                    warningMessage();
                }
            }
        } catch (InputMismatchException e) {
            warningMessage();
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

    /**
     * This method is responsible for conducting a meeting between two fish. If there are less than 2 fish in the list, it will print a message indicating there are no fish left for meeting.
     * The method will list the fish in the list and ask the user to input the index numbers of the two fish to be met.
     * If the two selected fish have different genders, a new fish will be added to the list.
     * If the two selected fish have the same gender or the input is not valid, it will print an error message.
     */
    private static void meeting() {

        // Check if there are less than 2 fish in the list
        if (fishList.size() < 2) {
            System.out.println(Messages.noMoreFishLeftForMeeting);
            return;
        }

        // Printing list of fish with its indices
        for (int i = 1; i <= fishList.size(); i++) {
            System.out.println("\033[32m" + i + ")" + " \033[0m" + fishList.get(i - 1));
        }

        // Scan user input for meeting fish
        try {
            Scanner in = new Scanner(System.in);
            System.out.print(Messages.meetingInfo);
            String[] fishOrders = in.nextLine().split("\\+");

            // Trying to read valid value from scanner
            try {
                // Check if selected fish have different values
                if (!fishOrders[0].equals(fishOrders[1])) {
                    Fish first = fishList.get(Integer.parseInt(fishOrders[0]) - 1);
                    Fish second = fishList.get(Integer.parseInt(fishOrders[1]) - 1);
                    // Check if selected fish have different genders
                    if (!first.getMale().equals(second.getMale())) {
                        Fish fish = addFish();
                        new CheckAllFishDeadlines(fishList).checkAllFishDeadlinesInDifferentThreads(fish);
                    } else {
                        System.out.println(Messages.genderIsNotEqual);
                    }
                } else {
                    System.out.println(Messages.genderIsNotEqual);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(Messages.fishAlreadyDied);
            }
        } catch (NumberFormatException e) {
            warningMessage();
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

    /**
     * This method prints a warning message.
     */
    private static void warningMessage() {
        System.out.println(Messages.warning);
    }

    /**
     * This method prints command list of program
     */
    private static void printCommandList() {
        System.out.println("\033[34m" + "Buyruqlar: " + "\033[0m");
        System.out.println("1 - Baliq qo'shish ");
        System.out.println("2 - Uchrashuv ");
        System.out.println("3 - Baliqlar ro'yxati ");
    }
}