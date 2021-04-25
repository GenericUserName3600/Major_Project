import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Ai_testing {

    static final char twoWideCar = 'A';
    static final char threewidecar = 'B';
    static final char goal_Car = 'X';
    static final char end_point = '@';
    static final char border = '*';


    public static void main(String[] args) {
        String[][] board = {
                {".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", "."},
                {"X", "X", ".", ".", ".", "@"},
                {".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", "."},

        };

        String[] CarPieces = {"A1", "A2", "A3", "A4", "A5", "A5", "A6", "A7", "A8", "A9", "A10", "A11"};
        String[] LorryPieces = {"B1", "B2", "B3", "B4"};

        Set<String> invalidPlacementContents = new HashSet<>();
        //creates a set/list of all values that cannot be used by the comparative statements
        for(int x=0;x<CarPieces.length;x++){
            invalidPlacementContents.add(CarPieces[x]);
        }
        for(int x=0;x<LorryPieces.length;x++){
            invalidPlacementContents.add(LorryPieces[x]);
        }
        invalidPlacementContents.add("@");

        Random randomNumbers = new Random();
        int amountOFLorriesPieces;
        int amountOfCarPieces;
        do {
            // 4 lorry pieces in the board game,
            // 11 cars excluding the red car.
            amountOFLorriesPieces = randomNumbers.nextInt(4) + 1;
            amountOfCarPieces = 3; // add back in the random value.

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

            do {
                startPositionX = randomNumbers.nextInt(6);
                startPositionY = randomNumbers.nextInt(6);
                direction = randomNumbers.nextInt(2);
                System.out.println("Car " + (y+1) + " of " + amountOfCarPieces +"\nX: " + startPositionX + "\tY: " + startPositionY + "\tDirection: " + direction);
                if (direction == 1) {
                    if (startPositionX == 5) {
                        if (board[startPositionX - 1][startPositionY].equals(".") && board[startPositionX][startPositionY].equals(".") && !board[startPositionX - 1][startPositionY].equals("X") && !board[startPositionX][startPositionY].equals("X")) {
                            board[startPositionX][startPositionY] = CarPieces[y];
                            board[startPositionX - 1][startPositionY] = CarPieces[y];

                        }
                    } else if (startPositionX == 0) {
                        if (board[startPositionX + 1][startPositionY].equals(".") && board[startPositionX][startPositionY].equals(".") && !board[startPositionX + 1][startPositionY].equals("X") && !board[startPositionX][startPositionY].equals("X")) {
                            board[startPositionX][startPositionY] = CarPieces[y];
                            board[startPositionX + 1][startPositionY] = CarPieces[y];
                        }
                    } else {
                        if (board[startPositionX + 1][startPositionY].equals(".") && board[startPositionX][startPositionY].equals(".") && !board[startPositionX + 1][startPositionY].equals("X") && !board[startPositionX][startPositionY].equals("X")) {
                            board[startPositionX][startPositionY] = CarPieces[y];
                            board[startPositionX + 1][startPositionY] = CarPieces[y];
                        } else {
                            if (!board[startPositionX + 1][startPositionY].equals("X") && !board[startPositionX][startPositionY].equals("X")) {
                                board[startPositionX][startPositionY] = CarPieces[y];
                                board[startPositionX - 1][startPositionY] = CarPieces[y];
                            }
                        }
                    }
                } else {
                    if (startPositionY == 5) {
                        if (board[startPositionX][startPositionY - 1].equals(".") && board[startPositionX][startPositionY].equals(".") && !board[startPositionX][startPositionY - 1].equals("X") && !board[startPositionX][startPositionY].equals("X")) {
                            board[startPositionX][startPositionY] = CarPieces[y];
                            board[startPositionX][startPositionY - 1] = CarPieces[y];

                        }
                    } else if (startPositionY == 0) {
                        if (board[startPositionX][startPositionY + 1].equals(".") && board[startPositionX][startPositionY].equals(".") && !board[startPositionX][startPositionY + 1].equals("X") && !board[startPositionX][startPositionY].equals("X")) {
                            board[startPositionX][startPositionY] = CarPieces[y];
                            board[startPositionX][startPositionY + 1] = CarPieces[y];
                        }
                    } else {
                        if (board[startPositionX][startPositionY + 1].equals(".") && board[startPositionX][startPositionY].equals(".") && !board[startPositionX][startPositionY + 1].equals("X") && !board[startPositionX][startPositionY].equals("X")) {
                            board[startPositionX][startPositionY] = CarPieces[y];
                            board[startPositionX][startPositionY + 1] = CarPieces[y];
                        } else {
                            if (!board[startPositionX][startPositionY - 1].equals("X") && !board[startPositionX][startPositionY].equals("X")) {
                                board[startPositionX][startPositionY] = CarPieces[y];
                                board[startPositionX][startPositionY - 1] = CarPieces[y];
                            }
                        }
                    }
                }
            } while (!board[startPositionX][startPositionY].equals(CarPieces[y])
                    && (!board[startPositionX - 1][startPositionY].equals(CarPieces[y])
                    || !board[startPositionX + 1][startPositionY].equals(CarPieces[y])));
        }

        printBoard(board);
        //debug statement to prove boardstate post car placement
        for (int s = 0; s < amountOFLorriesPieces; s++) {
            int startPositionX;
            int startPositionY;
            int direction;
            int piecesSuccessfullyPlaced;

            do {
                startPositionX = randomNumbers.nextInt(6);
                startPositionY = randomNumbers.nextInt(6);
                direction = randomNumbers.nextInt(2);
                System.out.println("Lorry " + (s+1) + " of " + (amountOFLorriesPieces-1) +"\nX: " + startPositionX + "\tY: " + startPositionY + "\tDirection: " + direction);
                piecesSuccessfullyPlaced=0;
                if (direction == 1) {
                    if (startPositionX == 5) {
                        if (board[startPositionX - 2][startPositionY].equals(".") && board[startPositionX - 1][startPositionY].equals(".") && board[startPositionX][startPositionY].equals(".")
                                && !board[startPositionX - 2][startPositionY].equals("X")
                                && !board[startPositionX - 1][startPositionY].equals("X")
                                && !board[startPositionX][startPositionY].equals("X")) {

                            board[startPositionX][startPositionY] = LorryPieces[s];
                            board[startPositionX - 1][startPositionY] = LorryPieces[s];
                            board[startPositionX - 2][startPositionY] = LorryPieces[s];
                            piecesSuccessfullyPlaced=3;
                        }
                    } else if (startPositionX == 0) {
                        if (board[startPositionX + 2][startPositionY].equals(".") && board[startPositionX + 1][startPositionY].equals(".") && board[startPositionX][startPositionY].equals(".")
                                && !board[startPositionX + 2][startPositionY].equals("X") && !board[startPositionX + 1][startPositionY].equals("X") && !board[startPositionX][startPositionY].equals("X")) {

                            board[startPositionX][startPositionY] = LorryPieces[s];
                            board[startPositionX + 1][startPositionY] = LorryPieces[s];
                            board[startPositionX + 2][startPositionY] = LorryPieces[s];
                            piecesSuccessfullyPlaced=3;
                        }
                    } else if (startPositionX == 4) {
                        if (board[startPositionX - 1][startPositionY].equals(".") && board[startPositionX + 1][startPositionY].equals(".") && board[startPositionX][startPositionY].equals(".")
                                && !board[startPositionX - 1][startPositionY].equals("X") && !board[startPositionX + 1][startPositionY].equals("X") && !board[startPositionX][startPositionY].equals("X")) {

                            board[startPositionX][startPositionY] = LorryPieces[s];
                            board[startPositionX + 1][startPositionY] = LorryPieces[s];
                            board[startPositionX - 1][startPositionY] = LorryPieces[s];
                            piecesSuccessfullyPlaced=3;
                        }
                    } else {
                        if (board[startPositionX + 2][startPositionY].equals(".") && board[startPositionX + 1][startPositionY].equals(".") && board[startPositionX][startPositionY].equals(".")
                                && !board[startPositionX + 2][startPositionY].equals("X") && !board[startPositionX + 1][startPositionY].equals("X") && !board[startPositionX][startPositionY].equals("X")) {
                            board[startPositionX][startPositionY] = LorryPieces[s];
                            board[startPositionX + 1][startPositionY] = LorryPieces[s];
                            board[startPositionX + 2][startPositionY] = LorryPieces[s];
                            piecesSuccessfullyPlaced=3;
                        } else {
                            if (board[startPositionX - 2][startPositionY].equals(".") && board[startPositionX - 1][startPositionY].equals(".") && board[startPositionX][startPositionY].equals(".")
                                    && !board[startPositionX - 2][startPositionY].equals("X") && !board[startPositionX - 1][startPositionY].equals("X") && !board[startPositionX][startPositionY].equals("X")) {

                                board[startPositionX][startPositionY] = LorryPieces[s];
                                board[startPositionX - 1][startPositionY] = LorryPieces[s];
                                board[startPositionX - 2][startPositionY] = LorryPieces[s];
                                piecesSuccessfullyPlaced=3;
                            }
                        }
                    }
                } else {
                    if (startPositionX == 5) {
                        if (board[startPositionX][startPositionY - 2].equals(".") && board[startPositionX][startPositionY - 1].equals(".") && board[startPositionX][startPositionY].equals(".")
                                && !board[startPositionX][startPositionY].equals("X")
                                && !board[startPositionX][startPositionY - 1].equals("X")
                                && !board[startPositionX][startPositionY - 2].equals("X")) {

                            board[startPositionX][startPositionY] = LorryPieces[s];
                            board[startPositionX][startPositionY - 1] = LorryPieces[s];
                            board[startPositionX][startPositionY - 2] = LorryPieces[s];
                            piecesSuccessfullyPlaced=3;
                        }
                    } else if (startPositionX == 4) {
                        if (board[startPositionX - 1][startPositionY].equals(".") && board[startPositionX + 1][startPositionY].equals(".") && board[startPositionX][startPositionY].equals(".")
                                && !board[startPositionX - 1][startPositionY].equals("X") && !board[startPositionX + 1][startPositionY].equals("X") && !board[startPositionX][startPositionY].equals("X")) {

                            board[startPositionX][startPositionY] = LorryPieces[s];
                            board[startPositionX + 1][startPositionY] = LorryPieces[s];
                            board[startPositionX - 1][startPositionY] = LorryPieces[s];
                            piecesSuccessfullyPlaced=3;

                        } else if (startPositionX == 0) {
                            if (board[startPositionX][startPositionY + 2].equals(".") && board[startPositionX][startPositionY + 1].equals(".") && board[startPositionX][startPositionY].equals(".")
                                    && !board[startPositionX][startPositionY + 2].equals("X") && !board[startPositionX][startPositionY + 1].equals("X") && !board[startPositionX][startPositionY].equals("X")) {

                                board[startPositionX][startPositionY] = LorryPieces[s];
                                board[startPositionX][startPositionY + 1] = LorryPieces[s];
                                board[startPositionX][startPositionY + 2] = LorryPieces[s];
                                piecesSuccessfullyPlaced=3;
                            }
                        } else {
                            if (board[startPositionX][startPositionY + 2].equals(".") && board[startPositionX][startPositionY + 1].equals(".") && board[startPositionX][startPositionY].equals(".")
                                    && !board[startPositionX][startPositionY + 2].equals("X") && !board[startPositionX][startPositionY + 1].equals("X") && !board[startPositionX][startPositionY].equals("X")) {
                                board[startPositionX][startPositionY] = LorryPieces[s];
                                board[startPositionX][startPositionY + 1] = LorryPieces[s];
                                board[startPositionX][startPositionY + 2] = LorryPieces[s];
                                piecesSuccessfullyPlaced=3;
                            } else {
                                if (board[startPositionX][startPositionY + 2].equals(".") && board[startPositionX][startPositionY + 1].equals(".") && board[startPositionX][startPositionY].equals(".")
                                        && !board[startPositionX][startPositionY + 2].equals("X") && !board[startPositionX][startPositionY + 1].equals("X") && !board[startPositionX][startPositionY].equals("X")) {

                                    board[startPositionX][startPositionY] = LorryPieces[s];
                                    board[startPositionX][startPositionY + 1] = LorryPieces[s];
                                    board[startPositionX][startPositionY + 2] = LorryPieces[s];
                                    piecesSuccessfullyPlaced=3;
                                }
                            }
                        }
                    }
                }

            }
            while (piecesSuccessfullyPlaced!=3);
            printBoard(board);


        }
        printBoard(board);
        System.out.println();

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
}
// TODO: 23/04/2021 Add a menu for debugging, Used for when i eventually add everything into function calls.
// TODO: 23/04/2021 Fix  the issue where the lorries override the cars... Simple logic error i believe ???
// TODO: 23/04/2021 Add a reset board feature 
// TODO: 23/04/2021 Need to fix it so cars can not be places horizontally in front of the goal car. Same goes for the lorries.
// TODO: 23/04/2021 Fix the duplicate code issue, use functions or something.
// TODO: 23/04/2021 Show progress to Myra, hope she is impressed / relieved xDDD
// TODO: 23/04/2021 Write about the inefficiency of my method in my report, and suggest alternate ways of changing / optmising it.

// queue that goes through the loop..
// ai slides, uninformed search....
// put a limit on the depth of the search
