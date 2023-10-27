package rogue;

import java.util.Random;

public class MapGenerator {
    private static final char PLAYER = '@';
    private static final char STAIR_UP = '<';
    private static final char STAIR_DOWN = '>';
    private static final char WALL = '#';
    private static final char FLOOR = '.';
    private static final char SPACE = ' ';
    private static final char DOOR = '+';
    private static final char NOURISHMENT = '%';
    private static final char ELIXIR = '!';
    private static final char SCROLL = '?';
    private static final char BOUNTY = '$';
    private static final char RELIC = '&';
    private static final char WAND = '"';
    private static final char STACKED_RELICS = ']';
    private static final char RING = '=';
    private static final char ADVERSARY_1 = ')';
    private static final char ADVERSARY_2 = '}';

    private char[][] map;
    private int width;
    private int height;
    private Random random;

    public MapGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        map = new char[width][height];
        random = new Random();
    }

    public void generateMap() {
        fillMap(WALL);
        generateRoomsAndCorridors();
        placeDoors();
        placeStairs();
    }

    public void displayMap() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(map[x][y]);
            }
            System.out.println();
        }
    }

    private void fillMap(char tile) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                map[x][y] = tile;
            }
        }
    }

    private void generateRoomsAndCorridors() {
        // Implement room and corridor generation here
        // Use random placement and sizes
    }

    private void placeDoors() {
        // Implement door placement in corridors
        // Replace some WALL tiles with DOOR tiles
    }

    private void placeStairs() {
        // Place STAIR_UP and STAIR_DOWN at appropriate locations
    }
}