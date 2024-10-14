import MontyHallParadox.Game;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @ParameterizedTest
    @MethodSource("provideTestScenarios")
    void testGameSwitch(int winningDoorIndex, int firstChoiceIndex, int expectedNewChoice) {
        Game game = new Game();

        // Установим приз на нужную дверь вручную
        for (int i = 0; i < 3; i++) {
            if (i == winningDoorIndex) {
                game.doors.get(i).setPrize(true);
            } else {
                game.doors.get(i).setPrize(false);
            }
        }

        int newChoice = game.simulateGame(firstChoiceIndex);
        assertEquals(expectedNewChoice, newChoice);
    }

    static Stream<Object[]> provideTestScenarios() {
        return Stream.of(
                new Object[]{0, 1, 2},  // Приз за дверью 0, игрок сначала выбирает дверь 1, меняет на 2
                new Object[]{1, 2, 0},  // Приз за дверью 1, игрок сначала выбирает дверь 2, меняет на 0
                new Object[]{2, 0, 1}   // Приз за дверью 2, игрок сначала выбирает дверь 0, меняет на 1
        );
    }
}
