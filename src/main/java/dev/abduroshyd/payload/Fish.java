package dev.abduroshyd.payload;

import dev.abduroshyd.config.AppConfig;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

/**
 * The Fish class represents a fish with a deadline, a gender, and an order.
 *
 * @author @abduroshyd
 * @version 1.0
 * @since 02/02/23
 */
public class Fish {

    /**
     * The deadline of the fish.
     */
    private LocalDateTime deadline = LocalDateTime.now().plusSeconds(new Random().nextInt(AppConfig.MAX_FISH_LIFE_IN_SECONDS));
    /**
     * The gender of the fish (true if male, false if female).
     */
    private Boolean male = new Random().nextBoolean();
    /**
     * The order of the fish.
     */
    private UUID id = UUID.randomUUID();

    /**
     * Constructs a default Fish object.
     */
    public Fish() {
    }


    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "deadline=" + deadline +
                ", male=" + male +
                ", id=" + id +
                '}';
    }
}
