import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Scanner;


public class Ai_testing {
    private static String board[][] = {
            {".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", "."},
            {"F1", "F1", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", "."},

    };


    public static void main(String[] args) {


        String[] CarPieces = {"A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11"};
        String[] LorryPieces = {"B1", "B2", "B3", "B4"};
        //int difficultyModifier =  MainMenu();
        Set<String> invalidPlacementContents = new HashSet<>();
        //creates a set/list of all values that cannot be used by the comparative statements
        initialiseInvalidSet(CarPieces, LorryPieces, invalidPlacementContents);

        Random randomNumbers = new Random();
        int amountOFLorriesPieces;
        int amountOfCarPieces;
        int piecesSuccessfullyPlaced;
        int doWhileLoopCheck = 0;
        do {
            // 4 lorry pieces in the board game,
            // 11 cars excluding the red car.
            amountOFLorriesPieces = randomNumbers.nextInt(4) + 1;
            amountOfCarPieces = randomNumbers.nextInt(6) + 5; // add back in the random value.

        } while (4 > (amountOfCarPieces + amountOFLorriesPieces) || (amountOfCarPieces + amountOFLorriesPieces) == 15); // While condition to ensure minimum pieces are generated, and maximum is avoided.

        for (int y = 0; y < amountOfCarPieces; y++) {
            // Generate start co-ordinate
            // Check if it does not have 'x' or '@' in that position.
            // Place first mark of a piece. Car being A and a number, Lorry being B and a number
            // randomise where the piece faces, 0 being vertical, 1 being horizontal.
            // Place second mark either vertically or horizontally next to the first mark.
            int startPositionX;
            int startPositionY;
            int direction;
            doWhileLoopCheck = 0;

            do {
                startPositionX = randomNumbers.nextInt(6);
                startPositionY = randomNumbers.nextInt(6);
                direction = randomNumbers.nextInt(2);
                System.out.println("Car " + (y + 1) + " of " + amountOfCarPieces + "\nX: " + startPositionX + "\tY: " + startPositionY + "\tDirection: " + direction);
                piecesSuccessfullyPlaced = 0;
                if (startPositionX == 2 && (startPositionY == 0 || startPositionY == 1) && direction == 1) {
                    // System.out.println("Start Cell Interference Horizontally");
                } else if (startPositionX == 2 && (startPositionY == 0 || startPositionY == 1) && direction == 1) {
                } else {
                    if (direction == 1) {
                        if (startPositionX == 5) {
                            if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX - 1][startPositionY])) {
                                board[startPositionX][startPositionY] = CarPieces[y];
                                board[startPositionX - 1][startPositionY] = CarPieces[y];
                                piecesSuccessfullyPlaced = 2;

                            }
                        } else if (startPositionX == 0) {
                            if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX + 1][startPositionY])) {
                                board[startPositionX][startPositionY] = CarPieces[y];
                                board[startPositionX + 1][startPositionY] = CarPieces[y];
                                piecesSuccessfullyPlaced = 2;
                            }
                        } else {
                            if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX + 1][startPositionY])) {
                                board[startPositionX][startPositionY] = CarPieces[y];
                                board[startPositionX + 1][startPositionY] = CarPieces[y];
                                piecesSuccessfullyPlaced = 2;
                            } else {
                                if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX - 1][startPositionY])) {
                                    board[startPositionX][startPositionY] = CarPieces[y];
                                    board[startPositionX - 1][startPositionY] = CarPieces[y];
                                    piecesSuccessfullyPlaced = 2;
                                }
                            }
                        }
                    } else {
                        if (startPositionY == 5) {
                            if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX][startPositionY - 1])) {
                                board[startPositionX][startPositionY] = CarPieces[y];
                                board[startPositionX][startPositionY - 1] = CarPieces[y];
                                piecesSuccessfullyPlaced = 2;

                            }
                        } else if (startPositionY == 0) {
                            if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX][startPositionY + 1])) {
                                board[startPositionX][startPositionY] = CarPieces[y];
                                board[startPositionX][startPositionY + 1] = CarPieces[y];
                                piecesSuccessfullyPlaced = 2;
                            }
                        } else {
                            if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX][startPositionY + 1])) {
                                board[startPositionX][startPositionY] = CarPieces[y];
                                board[startPositionX][startPositionY + 1] = CarPieces[y];
                                piecesSuccessfullyPlaced = 2;
                            } else {
                                if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX][startPositionY - 1])) {
                                    board[startPositionX][startPositionY] = CarPieces[y];
                                    board[startPositionX][startPositionY - 1] = CarPieces[y];
                                    piecesSuccessfullyPlaced = 2;
                                }
                            }
                        }
                    }
                }
                doWhileLoopCheck++;
                if (doWhileLoopCheck == 50) {
                    System.out.println("Loop Counter Met, Abandoning Random Location Generation for Piece " + CarPieces[y]);
                    break;
                }
            } while (piecesSuccessfullyPlaced != 2);
            printBoard(board);
        }

        System.out.println("=====End of Cars=====");
        //debug statement to prove board state post car placement
        for (int s = 0; s < amountOFLorriesPieces; s++) {
            int startPositionX;
            int startPositionY;
            int direction;
            doWhileLoopCheck = 0;


            do {
                startPositionX = randomNumbers.nextInt(6);
                startPositionY = randomNumbers.nextInt(6);
                direction = randomNumbers.nextInt(2);
                System.out.println("Lorry " + (s + 1) + " of " + amountOFLorriesPieces + "\nX: " + startPositionX + "\tY: " + startPositionY + "\tDirection: " + direction);
                piecesSuccessfullyPlaced = 0;
                if (direction == 1) {
                    if (startPositionX == 5) {
                        if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX - 1][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX - 2][startPositionY])) {

                            board[startPositionX][startPositionY] = LorryPieces[s];
                            board[startPositionX - 1][startPositionY] = LorryPieces[s];
                            board[startPositionX - 2][startPositionY] = LorryPieces[s];
                            piecesSuccessfullyPlaced = 3;
                        }
                    } else if (startPositionX == 0) {
                        if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX + 1][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX + 2][startPositionY])) {

                            board[startPositionX][startPositionY] = LorryPieces[s];
                            board[startPositionX + 1][startPositionY] = LorryPieces[s];
                            board[startPositionX + 2][startPositionY] = LorryPieces[s];
                            piecesSuccessfullyPlaced = 3;
                        }
                    } else if (startPositionX == 4 || startPositionX == 1) {
                        if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX + 1][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX - 1][startPositionY])) {

                            board[startPositionX][startPositionY] = LorryPieces[s];
                            board[startPositionX + 1][startPositionY] = LorryPieces[s];
                            board[startPositionX - 1][startPositionY] = LorryPieces[s];
                            piecesSuccessfullyPlaced = 3;
                        }
                    } else {
                        if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX + 1][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX + 2][startPositionY])) {
                            board[startPositionX][startPositionY] = LorryPieces[s];
                            board[startPositionX + 1][startPositionY] = LorryPieces[s];
                            board[startPositionX + 2][startPositionY] = LorryPieces[s];
                            piecesSuccessfullyPlaced = 3;
                        } else {
                            if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX - 1][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX - 2][startPositionY])) {

                                board[startPositionX][startPositionY] = LorryPieces[s];
                                board[startPositionX - 1][startPositionY] = LorryPieces[s];
                                board[startPositionX - 2][startPositionY] = LorryPieces[s];
                                piecesSuccessfullyPlaced = 3;
                            }
                        }
                    }
                } else {
                    if (startPositionY == 5) {
                        if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX][startPositionY - 1]) && !invalidPlacementContents.contains(board[startPositionX][startPositionY - 2])) {
                            board[startPositionX][startPositionY] = LorryPieces[s];
                            board[startPositionX][startPositionY - 1] = LorryPieces[s];
                            board[startPositionX][startPositionY - 2] = LorryPieces[s];
                            piecesSuccessfullyPlaced = 3;
                        }
                    } else if (startPositionY == 4 || startPositionY == 1) {
                        if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX][startPositionY - 1]) && !invalidPlacementContents.contains(board[startPositionX][startPositionY + 1])) {

                            board[startPositionX][startPositionY] = LorryPieces[s];
                            board[startPositionX][startPositionY + 1] = LorryPieces[s];
                            board[startPositionX][startPositionY - 1] = LorryPieces[s];
                            piecesSuccessfullyPlaced = 3;
                        }
                    } else if (startPositionY == 0) {
                        if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX][startPositionY + 1]) && !invalidPlacementContents.contains(board[startPositionX][startPositionY + 2])) {
                            board[startPositionX][startPositionY] = LorryPieces[s];
                            board[startPositionX][startPositionY + 1] = LorryPieces[s];
                            board[startPositionX][startPositionY + 2] = LorryPieces[s];
                            piecesSuccessfullyPlaced = 3;
                        }
                    } else {
                        if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX][startPositionY + 1]) && !invalidPlacementContents.contains(board[startPositionX][startPositionY + 2])) {
                            board[startPositionX][startPositionY + 1] = LorryPieces[s];
                            board[startPositionX][startPositionY] = LorryPieces[s];
                            piecesSuccessfullyPlaced = 3;
                            board[startPositionX][startPositionY + 2] = LorryPieces[s];
                        } else {
                            try {
                                if (!invalidPlacementContents.contains(board[startPositionX][startPositionY]) && !invalidPlacementContents.contains(board[startPositionX][startPositionY - 1]) && !invalidPlacementContents.contains(board[startPositionX][startPositionY - 2])) {
                                    board[startPositionX][startPositionY] = LorryPieces[s];
                                    board[startPositionX][startPositionY - 1] = LorryPieces[s];
                                    board[startPositionX][startPositionY - 2] = LorryPieces[s];
                                    piecesSuccessfullyPlaced = 3;
                                }
                            } catch (Exception e) {
                                System.out.println("bad results, trying again");
                            }
                        }
                    }
                }
                doWhileLoopCheck++;
                if (doWhileLoopCheck == 50) {
                    System.out.println("Loop Counter Met, Abandoning Random Location Generation for Piece " + LorryPieces[s]);
                    break;
                }
            } while (piecesSuccessfullyPlaced != 3);
            printBoard(board);
        }
    }


    private static void initialiseInvalidSet(String[] carPieces, String[] lorryPieces, Set<String> invalidPlacementContents) {
        invalidPlacementContents.addAll(Arrays.asList(carPieces));
        invalidPlacementContents.addAll(Arrays.asList(lorryPieces));

        invalidPlacementContents.add("F1");
    }

    private static void printBoard(String[][] board) {
        System.out.print("=================================\n");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    private static int MainMenu(){

        Random random = new Random();
        int difficultyCars = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to AI puzzle Solver.");
        System.out.println("Please select one of the opinions listed to continue");
        System.out.println();


        System.out.println("1: Easy");
        System.out.println("2: Intermediate");
        System.out.println("3: Advanced");
        System.out.println("4: Expert");
        System.out.println("5: Quit");
        System.out.println(" ");

        int result;
        result = input.nextInt();

        switch (result){
            case 1:
                int choice = random.nextInt(2);
                if ( choice == 0){
                    difficultyCars = 4;
                    break;
                }
                else{
                    difficultyCars = 5;
                    break;
                }
            case 2:
                int choice2 = random.nextInt(2);
                if ( choice2 == 0){
                    difficultyCars = 6;
                    break;
                }
                else{
                    difficultyCars = 7;
                    break;
                }
            case 3:
                int choice3 = random.nextInt(2);
                if ( choice3 == 0){
                    difficultyCars = 8;
                    break;
                }
                else{
                    difficultyCars = 9;
                    break;
                }
            case 4:
                int choice4 = random.nextInt(2);
                if ( choice4 == 0){
                    difficultyCars = 10;
                    break;
                }
                else{
                    difficultyCars = 11;
                    break;
                }
            case 5:
                System.out.println("Exiting program now....");
                System.exit(difficultyCars);
        }
        return difficultyCars;
    }
}

// TODO: 23/04/2021 Add a menu for debugging, Used for when i eventually add everything into function calls.

// TODO: 23/04/2021 Add a reset board feature 
// TODO: 23/04/2021 Need to fix it so cars can not be places horizontally in front of the goal car. Same goes for the lorries.
// TODO: 23/04/2021 Fix the duplicate code issue, use functions or something.
// TODO: 23/04/2021 Show progress to Myra, hope she is impressed / relieved xDDD
// TODO: 23/04/2021 Write about the inefficiency of my method in my report, and suggest alternate ways of changing / optimising it.

// queue that goes through the loop..
// ai slides, uninformed search....
// put a limit on the depth of the search

// so that should skip there, im thinking that we need to add the placed cars into the invaild placement array?