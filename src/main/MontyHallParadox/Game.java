package main.MontyHallParadox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public final List<Door> doors;
    private final Random random;

    public Game() {
        doors = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            doors.add(new Door(i));
        }
        random = new Random();
        // Случайным образом устанавливаем приз
        doors.get(random.nextInt(3)).setPrize(true);
    }

    public int getWinningDoor() {
        for (Door door : doors) {
            if (door.hasPrize()) {
                return door.getId();
            }
        }
        return -1;
    }

    public int simulateGame(int initialChoice) {
        int winningDoor = getWinningDoor();
        int doorToOpen = getDoorToOpen(winningDoor, initialChoice);
        return getNewChoice(initialChoice, doorToOpen);
    }

    private int getDoorToOpen(int winningDoor, int playerChoice) {
        for (Door door : doors) {
            if (door.getId() != winningDoor && door.getId() != playerChoice) {
                return door.getId(); // Возвращаем дверь с козой
            }
        }
        return -1;
    }

    private int getNewChoice(int playerChoice, int doorToOpen) {
        for (Door door : doors) {
            if (door.getId() != playerChoice && door.getId() != doorToOpen) {
                return door.getId(); // Возвращаем новый выбор двери
            }
        }
        return -1;
    }
}
