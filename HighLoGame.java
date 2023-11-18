import java.util.Random;
import java.util.Scanner;

enum DifficultyLevel {
    EASY, MEDIUM, HARD
}

enum GameResult {
    GO_HIGHER, GO_LOWER, CORRECT, GAME_OVER
}

// Utility class for generating random numbers
class RandomNumberGenerator {
    private static final Random random = new Random();

    // Generate a random number within a specified range
    static int generateRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}

// Class representing a player
class Player {
    private String playerName;
    private int score;

    Player(String playerName) {
        this.playerName = playerName;
        this.score = 0;
    }

    // Getter methods
    String getPlayerName() {
        return playerName;
    }

    int getScore() {
        return score;
    }

    // Increment player's score
    void incrementScore() {
        score++;
    }
}

// Class representing the scoreboard
class Scoreboard {
    private int gamesPlayed;
    private int wins;
    private int losses;
    private int highestScore;

    // Record game outcome
    void recordGameResult(GameResult result) {
        gamesPlayed++;

        if (result == GameResult.CORRECT) {
            wins++;
        } else if (result == GameResult.GAME_OVER) {
            losses++;
        }

        if (result != GameResult.GAME_OVER && result != GameResult.GO_LOWER) {
            // Update highest score only for wins and correct guesses
            highestScore = Math.max(highestScore, gamesPlayed);
        }
    }

    // Display scoreboard
    void displayScoreboard() {
        System.out.println("\n----- Scoreboard -----");
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Highest Score: " + highestScore);
        System.out.println("----------------------\n");
    }
}

// Class representing the HiLo guessing game
class Game {
    private final Player player;
    private final Scoreboard scoreboard;
    private final int maxGuesses;
    private int selectedNumber;
    private int remainingGuesses;

    Game(Player player, Scoreboard scoreboard, int maxGuesses, int difficultyLevel) {
        this.player = player;
        this.scoreboard = scoreboard;
        this.maxGuesses = maxGuesses;
        this.remainingGuesses = maxGuesses;
        initializeGame(difficultyLevel);
    }

    // Initialize the game by selecting a random number
    private void initializeGame(int difficultyLevel) {
        switch (difficultyLevel) {
            case 1:
                selectedNumber = RandomNumberGenerator.generateRandomNumber(1, 10);
                break;
            case 2:
                selectedNumber = RandomNumberGenerator.generateRandomNumber(1, 100);
                break;
            case 3:
                selectedNumber = RandomNumberGenerator.generateRandomNumber(1, 1000);
                break;
            default:
                throw new IllegalArgumentException("Invalid difficulty level");
        }
    }

    // Make a guess and return the result
    GameResult makeGuess(int guess) {
        remainingGuesses--;

        if (guess < selectedNumber) {
            return GameResult.GO_HIGHER;
        } else if (guess > selectedNumber) {
            return GameResult.GO_LOWER;
        } else {
            player.incrementScore();
            scoreboard.recordGameResult(GameResult.CORRECT);
            return GameResult.CORRECT;
        }
    }

    // Getters for game state
    int getRemainingGuesses() {
        return remainingGuesses;
    }

    int getMaxGuesses() {
        return maxGuesses;
    }

    int getSelectedNumber() {
        return selectedNumber;
    }
}

// Class representing the game controller
class GameController {
    private final Scanner scanner;
    private final Player player;
    private final Scoreboard scoreboard;

    GameController() {
        this.scanner = new Scanner(System.in);
        this.player = new Player("Player1");
        this.scoreboard = new Scoreboard();
    }

    // Start the game
    void startGame(int difficultyLevel) {
        System.out.println("Welcome to the HiLo Game!");
        System.out.println("Difficulty Level: " + difficultyLevel);
        System.out.println("Can you guess the number?\n");

        while (true) {
            Game game = new Game(player, scoreboard, 3, difficultyLevel);

            while (game.getRemainingGuesses() > 0) {
                displayGameStatus(game);
                int guess = getPlayerGuess();
                GameResult result = game.makeGuess(guess);

                if (result == GameResult.CORRECT) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    scoreboard.displayScoreboard();
                    break;
                } else if (result == GameResult.GO_HIGHER) {
                    System.out.println("Go higher!");
                } else if (result == GameResult.GO_LOWER) {
                    System.out.println("Go lower!");
                }
            }

            if (game.getRemainingGuesses() == 0) {
                System.out.println("Game over! The correct number was: " + game.getSelectedNumber());
                scoreboard.recordGameResult(GameResult.GAME_OVER);
                scoreboard.displayScoreboard();
            }

            if (!playAgain()) {
                break;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    // Display the current game status
    private void displayGameStatus(Game game) {
        System.out.println("Remaining Guesses: " + game.getRemainingGuesses());
        System.out.println("Enter your guess: ");
    }

    // Get the player's guess from user input
    private int getPlayerGuess() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Ask the player if they want to play again
    private boolean playAgain() {
        System.out.println("Do you want to play again? (y/n)");
        String response = scanner.nextLine().toLowerCase();
        return response.equals("y");
    }
}

public class HiLoGameDemo {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame(2); // Choose difficulty level (1: easy, 2: medium, 3: hard)
    }
}