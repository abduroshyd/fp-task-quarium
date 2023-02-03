package dev.abduroshyd.service;

import dev.abduroshyd.payload.Fish;

import java.util.ArrayList;
import java.util.List;

/**
 * FillAquarium class is responsible for filling the aquarium with a specified number of fish.
 *
 * @author @abduroshyd
 * @version 1.0
 * @since 03/02/23
 */
public class FillAquarium {

    public static List<Fish> fillAquariumWithFish(int fishCount) {
        List<Fish> fishList = new ArrayList<>();
        // Loop through each fish
        for (int i = 1; i <= fishCount; i++) {

            // Create a new Fish object
            Fish fish = new Fish();

            // Add the Fish object to the fishList
            fishList.add(fish);

            // Print the Fish object
            System.out.println(fish);
        }

        return fishList;
    }

}
