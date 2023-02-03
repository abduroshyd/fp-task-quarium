package dev.abduroshyd.service;

import dev.abduroshyd.config.AppConfig;
import dev.abduroshyd.constants.Messages;

import java.util.Random;

/**
 * The InitializeAquarium class is responsible for initializing an aquarium by generating a random number of fish.
 *
 * @author @abduroshyd
 * @version 1.0
 * @since 03/02/23
 */
public class InitializeAquarium {

    public static int initializeAquarium() {

        // Initialize a Random object for generating random numbers
        Random random = new Random();

        // Generate a random number of fish between 1 and 5 (inclusive)
        int fishCount = random.nextInt(AppConfig.MAX_FISH_COUNT) + 1;

        // Print a greeting message
        System.out.println(Messages.greetings);

        // Print the number of fish in the aquarium
        System.out.println(fishCount + " ta baliq mavjud bo'lgan akvarium ishga tushdi \n Baliqlar: ");

        return fishCount;
    }

}
