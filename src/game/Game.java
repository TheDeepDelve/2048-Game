package game;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private int[][] gameBoard;
    private Random r = new Random();
    private GameState state;
    private int score;
    public int highScore;

    public Game() {

        gameBoard = new int[4][4];
        addNewNumbers();
        addNewNumbers();
        state = GameState.CONTINUE;
    }


    public int[][] getGameBoard() {
        return gameBoard;
    }

    public GameState gameState() {
        return state;
    }

    public int getScore(){
        return score;
    }
    public int getHighScore(){
        return highScore;
    }

    public void printArray() {
        for (int[] x : gameBoard) {
            System.out.format("%6d%6d%6d%6d", x[0], x[1], x[2], x[3]);
            System.out.println();
        }
        System.out.println();

    }

    public void addNewNumbers() {
        if(checkBoardFull()){
            return;
        }
        ArrayList<Integer> emptySpacesX = new ArrayList<Integer>();
        ArrayList<Integer> emptySpacesY = new ArrayList<Integer>();
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (gameBoard[x][y] == 0) {
                   emptySpacesX.add(x);
                   emptySpacesY.add(y);
                }
            }
        }
        int choice = r.nextInt(emptySpacesX.size());
        int numberChooser = r.nextInt(10);
        int newNumber = 2;
        if (numberChooser == 0) {
            newNumber = 4;
        }
        int X = emptySpacesX.get(choice);
        int Y = emptySpacesY.get(choice);
        gameBoard[X][Y] = newNumber;
    }

    public void pushUp() {

        System.out.println("pushing up..");
        for (int y = 0; y < 4; y++) {
            boolean[] alreadyCombined = {false, false, false, false};
            for (int x = 1; x < 4; x++) {
                if (gameBoard[x][y] != 0) {
                    int value = gameBoard[x][y];
                    int X = x - 1;
                    while (X >= 0 && gameBoard[X][y] == 0) {
                        X--;

                    }
                    if (X == -1) {
                        gameBoard[0][y] = value;
                        gameBoard[x][y] = 0;
                    } else if (gameBoard[X][y] != value) {
                        gameBoard[x][y] = 0;
                        gameBoard[X + 1][y] = value;

                    } else {
                        if (alreadyCombined[X]) {
                            gameBoard[x][y] = 0;
                            gameBoard[X + 1][y] = value;

                        } else {
                            gameBoard[x][y] = 0;
                            gameBoard[X][y] *= 2;
                            score+=gameBoard[X][y];
                            alreadyCombined[X] = true;

                        }
                    }
                }
            }
        }
    }

    public void pushDown() {

        System.out.println("pushing down..");
        for (int y = 0; y < 4; y++) {
            boolean[] alreadyCombined = {false, false, false, false};
            for (int x = 2; x > -1; x--) {
                if (gameBoard[x][y] != 0) {
                    int value = gameBoard[x][y];
                    int X = x + 1;
                    while (X <= 3 && gameBoard[X][y] == 0) {
                        X++;

                    }
                    if (X == 4) {
                        gameBoard[3][y] = value;
                        gameBoard[x][y] = 0;
                    } else if (gameBoard[X][y] != value) {
                        gameBoard[x][y] = 0;
                        gameBoard[X - 1][y] = value;

                    } else {
                        if (alreadyCombined[X]) {
                            gameBoard[x][y] = 0;
                            gameBoard[X - 1][y] = value;

                        } else {
                            gameBoard[x][y] = 0;
                            gameBoard[X][y] *= 2;
                            score+=gameBoard[X][y];
                            alreadyCombined[X] = true;

                        }
                    }
                }
            }
        }
    }

    public void pushLeft() {

        System.out.println("pushing left..");
        for (int x = 0; x < 4; x++) {
            boolean[] alreadyCombined = {false, false, false, false};
            for (int y = 1; y < 4; y++) {
                if (gameBoard[x][y] != 0) {
                    int value = gameBoard[x][y];
                    int Y = y - 1;
                    while (Y >= 0 && gameBoard[x][Y] == 0) {
                        Y--;

                    }
                    if (Y == -1) {
                        gameBoard[x][0] = value;
                        gameBoard[x][y] = 0;
                    } else if (gameBoard[x][Y] != value) {
                        gameBoard[x][y] = 0;
                        gameBoard[x][Y + 1] = value;

                    } else {
                        if (alreadyCombined[Y]) {
                            gameBoard[x][y] = 0;
                            gameBoard[x][Y + 1] = value;

                        } else {
                            gameBoard[x][y] = 0;
                            gameBoard[x][Y] *= 2;
                            score+=gameBoard[x][Y];
                            alreadyCombined[Y] = true;

                        }
                    }
                }
            }
        }
    }

    public void pushRight() {

        System.out.println("pushing Right..");
        for (int x = 0; x < 4; x++) {
            boolean[] alreadyCombined = {false, false, false, false};
            for (int y = 2; y > -1; y--) {
                if (gameBoard[x][y] != 0) {
                    int value = gameBoard[x][y];
                    int Y = y + 1;
                    while (Y <= 3 && gameBoard[x][Y] == 0) {
                        Y++;

                    }
                    if (Y == 4) {
                        gameBoard[x][3] = value;
                        gameBoard[x][y] = 0;
                    } else if (gameBoard[x][Y] != value) {
                        gameBoard[x][y] = 0;
                        gameBoard[x][Y - 1] = value;

                    } else {
                        if (alreadyCombined[Y]) {
                            gameBoard[x][y] = 0;
                            gameBoard[x][Y - 1] = value;

                        } else {
                            gameBoard[x][y] = 0;
                            gameBoard[x][Y] *= 2;
                            score+=gameBoard[x][Y];
                            alreadyCombined[Y] = true;

                        }
                    }
                }
            }
        }
    }

    public boolean checkFor2048() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (gameBoard[x][y] == 2048) {

                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkBoardFull() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (gameBoard[x][y] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkHasMoves() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (x == 0) {
                    if (y != 0) {
                        if (gameBoard[x][y] == gameBoard[x][y - 1]) {
                            return true;
                        }
                    }
                } else {
                    if (y != 0) {
                        if (gameBoard[x][y] == gameBoard[x][y - 1]) {
                            return true;
                        }

                    }
                    if (gameBoard[x][y] == gameBoard[x - 1][y]) {
                        return true;
                    }
                }
            }


        }
        return false;


    }
    public void checkState(){
        if(checkFor2048()){
            state=GameState.WIN;
        }
        else if(checkBoardFull()){
            if(checkHasMoves()){
                state=GameState.CONTINUE;
            }
            else{
                state=GameState.LOSE;
            }
        }else{
            state=GameState.CONTINUE;
        }
    }
}