package Alive;

import java.util.Random;
import java.util.Scanner;

public class GameConsole {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    //Map
    public static char[][] map;
    public static int mapWight;
    public static int mapHeight;
    public static int mapSizeMin = 3;
    public static int mapSizeMax = 6;
    public static char empty = 'О';
    public static char ready = '*';

    //Player
    public static char player = '@';
    public static String playerName = "Павел Степаныч";
    public static int playerHP = 100;
    public static int playerX;
    public static int playerY;
    public static final int playerMoveUp = 8;
    public static final int playerMoveLeft = 4;
    public static final int playerMoveRight = 6;
    public static final int playerMoveDown = 2;

    //Trap
    public static char trap = 'O';
    public static int trapAttack;
    public static int trapCount;
    public static int trapValueMin = 5;
    public static int trapValueMax = 11;


    public static void main(String[] args) {
         while (true) {
            createMap();
            spawnPlayer();
            spawnTrap();


            while (true) {
                showMap();
                movePlayer();
                if (!isPlayerAlive()) {
                    System.out.println(playerName + " мертв");
                    System.out.println("Игра окончена");
                    break;

                }   else if (isFullMap()) {
                    System.out.println(playerName + " прошел карту");
                    System.out.println("Но внезапно, " + playerName + " оказался в новой комнате");
                    break;
                }
            }

            }
        }




    public static void createMap() {
        mapWight = randomValue(mapSizeMin, mapSizeMax);
        mapHeight = randomValue(mapSizeMin, mapSizeMax);
        map = new char[mapHeight][mapWight];

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWight; x++) {
                map[y][x] = empty;
            }
        }

        System.out.println("Карта создана. Её размер - " + mapWight + " на " + mapHeight);
    }

    public static void showMap() {
        System.out.println("==========> Карта <==========");
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWight; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("=============================");
    }

    public static void spawnPlayer() {
        playerX = randomValue(0, mapWight - 1);
        playerY = randomValue(0, mapHeight - 1);
        map[playerY][playerX] = player;
        System.out.println(playerName + " появился в [" + (playerX + 1) + ":" + (playerY + 1) + "]");
    }

    public static void spawnTrap() {
        trapAttack = randomValue(trapValueMin, trapValueMax);
        trapCount = (mapWight + mapHeight) / 2;

        int trapX;
        int trapY;

        for (int i = 1; i <= trapCount; i++) {

            do {
                trapX = random.nextInt(mapWight);
                trapY = random.nextInt(mapHeight);
            } while (!isEmpty(trapX, trapY));

            map[trapY][trapX] = trap;
        }
        System.out.println(trapCount + " ловушки созданы. Урон одной такой = " + trapAttack);
    }

    public static void movePlayer() {

        int currentPlayerX = playerX;
        int currentPlayerY = playerY;

        int playerDestination;

        do {
            System.out.print("Управление: (Вверх: " + playerMoveUp + " | Вниз: " + playerMoveDown +
                    " | Влево: " + playerMoveLeft + " | Вправо: " + playerMoveRight + ") >>> ");

            playerDestination = scanner.nextInt();

            switch (playerDestination) {
                case playerMoveUp:
                    playerY -= 1;
                    break;
                case playerMoveDown:
                    playerY += 1;
                    break;
                case playerMoveLeft:
                    playerX -= 1;
                    break;
                case playerMoveRight:
                    playerX += 1;
                    break;
            }

        } while (!checkValidMove(currentPlayerX, currentPlayerY, playerX, playerY));

        playerMoveAction(currentPlayerX, currentPlayerY, playerX, playerY);
    }

    public static boolean isEmpty(int x, int y) {
        return map[y][x] == empty;
    }

    public static boolean isFullMap() {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWight; x++) {
                if (map[y][x] == empty) return false;
            }
        }
        return true;
    }

    public static boolean checkValidMove(int pastX, int pastY, int nextX, int nextY) {
        if (nextX >= 0 && nextX < mapWight && nextY >= 0 && nextY < mapHeight) {
            System.out.println(playerName + " ход в [" + (nextX + 1) + ":" + (nextY + 1) + "] успешен");
            return true;
        } else {
            System.out.println(" *звук удара лбом о стену*");
            playerX = pastX;
            playerY = pastY;
            return false;
        }
    }

    public static void playerMoveAction(int pastX, int pastY, int nextX, int nextY) {
        if (map[nextY][nextX] == trap) {
            playerHP -= trapAttack;
            trapCount--;
            System.out.println("Внимание! " + playerName + " был атакован. HP = " + playerHP);
        }

        map[nextY][nextX] = player;
        map[pastY][pastX] = ready;
    }

    public static int randomValue(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static boolean isPlayerAlive() {
        return playerHP > 0;
    }
}

