package rogue;

import java.util.Random;

public class MapGenerator {
    public class color {
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";

    }
    public class forMap {
        private static final char PLAYER = '@';
        private static final char STAIR_UP = '<';
        private static final char STAIR_DOWN = '>';
        private static final char WALL = '#';
        private static final char FLOOR = '.';
        private static final char SPACE = ' ';
        private static final char DOOR = '+';
        private static final char NOURISHMENT = '%';
        //private static final char ELIXIR = '!';
        //private static final char SCROLL = '?';
        private static final char BOUNTY = '$';
        //private static final char RELIC = '&';
        //private static final char WAND = '"';
        //private static final char STACKED_RELICS = ']';
        //private static final char RING = '=';
        //private static final char ADVERSARY_1 = ')';
        //private static final char ADVERSARY_2 = '}';
    
        //Enemy types
        private static final char BAT = 'B';
        private static final char ZOMBIE = 'Z';
        private static final char LEPRECHAUN = 'L';
        private static final char HOBBIT = 'H';
        private static final char ELF = 'E';
        private static final char ARCHER = 'A';
        private static final char ORC = 'O';
        private static final char RUST_MONSTER = 'R';
        private static final char WEREWOLF = 'W';
        private static final char VAMPIRE = 'V';
        private static final char PURPLE_WORM = 'P';
        private static final char DRAGON = 'D';
    
        //Items
        /*
        private static final char POTION_OF_RESTORE_STRENGTH = 'a';
        private static final char SCROLL_OF_CREATE_MONSTER = 'b';
        private static final char DAGGER = 'd';
        private static final char SCROLL_OF_LIGHT = 'e';
        private static final char SCROLL_OF_IDENTITY = 'h';
        private static final char SCROLL_OF_FOOD_DETECTION = 'o';
        private static final char SCROLL_OF_PUNISHMENT = 'p';
        private static final char RING_OF_PROTECTION = 'r';
        private static final char SCROLL_OF_ENCHANTMENT = 's';
        private static final char SCROLL_OF_MAGIC_MAPPING = 'v';
        private static final char SHORT_SWORD = 'w';
        private static final char LONG_SWORD = 'x';
        */
    }

    private char[][] map;
    private int width;
    private int height;
    private int currentLevel;
    private Random random;

    public MapGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new char[width][height];
        this.random = new Random();
        initializeMap();
    }

    private void initializeMap() {
        fillMapWithFloors();
        fillMapWithEnemies();
        fillMapWithLoot();
        placeStairs();
        spawnPlayer();
    }

    public void spawnPlayer() {
        int playerX = random.nextInt(width);
        int playerY = random.nextInt(height);
        map[playerX][playerY] = forMap.PLAYER;
    }

    private void fillMapWithFloors() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                map[x][y] = forMap.FLOOR;
            }
        }
    }

    private void placeStairs() {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        map[x][y] = forMap.STAIR_DOWN;
    }

    private void fillMapWithEnemies() {
        char[] enemyTypes = {
            forMap.BAT,
            forMap.ZOMBIE,
            forMap.LEPRECHAUN,
            forMap.HOBBIT,
            forMap.ELF,
            forMap.ARCHER,
            forMap.ORC,
            forMap.RUST_MONSTER,
            forMap.WEREWOLF,
            forMap.VAMPIRE,
            forMap.PURPLE_WORM,
            forMap.DRAGON
        };
        int maxEnemyLevel = Math.min(currentLevel / 3 + 3, enemyTypes.length);
        int numberOfEnemies = random.nextInt(10) + 1;
        for (int i = 0; i < numberOfEnemies; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int enemyLevel = random.nextInt(maxEnemyLevel);
            char enemyType = enemyTypes[enemyLevel];
            if (enemyType == forMap.BAT && currentLevel <= 4) {
                enemyLevel = random.nextInt(Math.min(3, maxEnemyLevel));
                enemyType = enemyTypes[enemyLevel];
            } else if (enemyType == forMap.ZOMBIE && currentLevel <= 7) {
                enemyLevel = random.nextInt(Math.min(5, maxEnemyLevel));
                enemyType = enemyTypes[enemyLevel];
            } else if (enemyType == forMap.LEPRECHAUN && currentLevel <= 11) {
                enemyLevel = random.nextInt(Math.min(7, maxEnemyLevel));
                enemyType = enemyTypes[enemyLevel];
            } else if (enemyType == forMap.HOBBIT && currentLevel <= 16) {
                enemyLevel = random.nextInt(Math.min(9, maxEnemyLevel));
                enemyType = enemyTypes[enemyLevel];
            } else if (enemyType == forMap.ELF && currentLevel <= 21) {
                enemyLevel = random.nextInt(Math.min(11, maxEnemyLevel));
                enemyType = enemyTypes[enemyLevel];
            } else if (enemyType == forMap.ARCHER && currentLevel <= 21) {
                enemyLevel = random.nextInt(Math.min(11, maxEnemyLevel));
                enemyType = enemyTypes[enemyLevel];
            } else if (enemyType == forMap.ORC && currentLevel <= 26) {
                enemyLevel = random.nextInt(Math.min(13, maxEnemyLevel));
                enemyType = enemyTypes[enemyLevel];
            } else if (enemyType == forMap.RUST_MONSTER && currentLevel <= 29) {
                enemyLevel = random.nextInt(Math.min(15, maxEnemyLevel));
                enemyType = enemyTypes[enemyLevel];
            } else if (enemyType == forMap.WEREWOLF && currentLevel <= 35) {
                enemyLevel = random.nextInt(Math.min(17, maxEnemyLevel));
                enemyType = enemyTypes[enemyLevel];
            } else if (enemyType == forMap.VAMPIRE && currentLevel <= 40) {
                enemyLevel = random.nextInt(Math.min(19, maxEnemyLevel));
                enemyType = enemyTypes[enemyLevel];
            } else if (enemyType == forMap.PURPLE_WORM && currentLevel <= 44) {
                enemyLevel = random.nextInt(Math.min(21, maxEnemyLevel));
                enemyType = enemyTypes[enemyLevel];
            } else if (enemyType == forMap.DRAGON && currentLevel <= 49) {
                enemyLevel = random.nextInt(Math.min(23, maxEnemyLevel));
            }
            map[x][y] = enemyType;
        }
    }

    private void fillMapWithLoot() {
        int numberOfLoot = random.nextInt(6) + 1;
        boolean hasNourishment = false;
        boolean hasBounty = false;
        for (int i = 0; i < numberOfLoot; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            if (!hasNourishment) {
                map[x][y] = forMap.NOURISHMENT;
                hasNourishment = true;
            } else if (!hasBounty) {
                map[x][y] = forMap.BOUNTY;
                hasBounty = true;
            } else {
                int lootType = random.nextInt(2);
                if (lootType == 0) {
                    map[x][y] = forMap.NOURISHMENT;
                } else {
                    map[x][y] = forMap.BOUNTY;
                }
            }
        }
    }

    private String getColor(char character) {
        switch (character) {
            case forMap.BAT:
                return color.ANSI_PURPLE;
            case forMap.ZOMBIE:
                return color.ANSI_GREEN;
            case forMap.LEPRECHAUN:
                return color.ANSI_YELLOW;
            case forMap.HOBBIT:
                return color.ANSI_BLUE;
            case forMap.ELF:
                return color.ANSI_CYAN;
            case forMap.ARCHER:
                return color.ANSI_RED;
            case forMap.ORC:
                return color.ANSI_PURPLE;
            case forMap.RUST_MONSTER:
                return color.ANSI_PURPLE;
            case forMap.WEREWOLF:
                return color.ANSI_RED;
            case forMap.VAMPIRE:
                return color.ANSI_RED;
            case forMap.PURPLE_WORM:
                return color.ANSI_PURPLE;
            case forMap.DRAGON:
                return color.ANSI_RED;
            case forMap.NOURISHMENT:
                return color.ANSI_GREEN;
            case forMap.BOUNTY:
                return color.ANSI_YELLOW;
            case forMap.FLOOR:
                return color.ANSI_BLACK;
            default:
                return color.ANSI_RESET;
        }
    }

    public void displayMap() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                char tile = map[x][y];
                String colorCode = getColor(tile);
                System.out.print(colorCode + tile + color.ANSI_RESET);
            }
            System.out.println();
        }
    }
}