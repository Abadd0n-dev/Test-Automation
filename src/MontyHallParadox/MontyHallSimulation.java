package MontyHallParadox;

import java.util.Random;

public class MontyHallSimulation {
    private static final int TOTAL_GAMES = 10000;
    public static void main(String[] args) {
        int switchWins = 0;
        int stayWins = 0;
        Random random = new Random();

        for (int i = 0; i < TOTAL_GAMES; i++) {
            Game game = new Game();
            int playerChoice = random.nextInt(3);
            int newChoice = game.simulateGame(playerChoice);

            if (newChoice == game.getWinningDoor()) {
                switchWins++;
            } else {
                stayWins++;
            }
        }

        System.out.println("Игроки, которые меняли выбор, выиграли: " + switchWins + " раз.");
        System.out.println("Игроки, которые остались при своем выборе, выиграли: " + stayWins + " раз.");
    }
}
