import MontyHallParadox.Door;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoorTest {

    @Test
    void testDoorCreation() {
        Door door = new Door(1);
        assertEquals(1, door.getId());
        assertFalse(door.hasPrize(), "New door should not initially have a prize.");
    }

    @Test
    void testSetPrize() {
        Door door = new Door(1);
        door.setPrize(true);
        assertTrue(door.hasPrize(), "Door should have a prize after setting it to true.");
    }

    @Test
    void testSetPrizeTwice() {
        Door door = new Door(1);
        door.setPrize(true);
        assertTrue(door.hasPrize(), "Door should have a prize after setting it to true.");

        door.setPrize(false);
        assertFalse(door.hasPrize(), "Door should not have a prize after setting it to false.");
    }
}
