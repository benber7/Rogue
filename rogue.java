package rogue;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


public class rogue {

    public class CharacterStats {
        //PLAYER
        public static final int PLAYER_HEALTH = 100;
        public static final int PLAYER_DAMAGE = 15;

        //ENEMIES-EASY
        public static final int BAT_HEALTH = 10;
        public static final int BAT_DAMAGE = 5;
        public static final int HOBBIT_HEALTH = 20;
        public static final int HOBBIT_DAMAGE = 10;
        public static final int LEPRECHAUN_HEALTH = 25;
        public static final int LEPRECHAUN_DAMAGE = 8;
        public static final int ELF_HEALTH = 30;
        public static final int ELF_DAMAGE = 15;

        //ENEMIES-MEDIUM
        public static final int ZOMBIE_HEALTH = 35;
        public static final int ZOMBIE_DAMAGE = 10;
        public static final int ARCHER_HEALTH = 40;
        public static final int ARCHER_DAMAGE = 10;
        public static final int WEREWOLF_HEALTH = 45;
        public static final int WEREWOLF_DAMAGE = 14;
        public static final int ORC_HEALTH = 50;
        public static final int ORC_DAMAGE = 12;
        
        //ENEMIES-HARD
        public static final int RUST_MONSTER_HEALTH = 60;
        public static final int RUST_MONSTER_DAMAGE = 10;
        public static final int VAMPIRE_HEALTH = 70;
        public static final int VAMPIRE_DAMAGE = 16;
        public static final int PURPLE_WORM_HEALTH = 80;
        public static final int PURPLE_WORM_DAMAGE = 18;
        public static final int DRAGON_HEALTH = 100;
        public static final int DRAGON_DAMAGE = 20;

        //ITEMS
    }
    public class GameStats {
        public static final int WIDTH = 50;
        public static final int HEIGHT = 20;
        public static final int CURRENT_LEVEL = 1;
        public static final int GOLD = 0;
        public static final int EXP = 0;
    }
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

    private static boolean inGame = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        clearConsole();
        System.out.println("Welcome to the " + color.ANSI_PURPLE + "cursed" + color.ANSI_RESET + " realm of Rogue!");
        System.out.println("Your sole purpose here is to amass " + color.ANSI_YELLOW + "treasures" + color.ANSI_RESET);
        System.out.println("and ascend the unfathomable depths of " + color.ANSI_RED + "THE DUNGEON" + color.ANSI_RESET + ".");
        System.out.println("Remember, your journey shall end when " + color.ANSI_BLACK + "darkness" + color.ANSI_RESET + " consumes you.");
        System.out.println("---------------------------------------------------------------------");

        int quitAttempts = 0;
        
        while (true) {
            if (!inGame) {
                System.out.println("Main Menu:");
                System.out.println("1. Embark on a New Quest");
                System.out.println("2. Grasp the Art of Control");
                System.out.println("3. Decrypt the Visual Scrolls");
                System.out.println("4. Confront the Shadows");
                System.out.println("5. Retreat from this Wretched Place");
                System.out.print("What is your choice, " + color.ANSI_GREEN + "adventurer" + color.ANSI_RESET + "? ");
            }

            int choice = scanner.nextInt();

            if (!inGame) {
                switch (choice) {
                    case 1:
                        clearConsole();
                        game();
                        break;
                    case 2:
                        clearConsole();
                        printCommands();
                        break;
                    case 3:
                        clearConsole();
                        printVisualCues();
                        break;
                    case 4:
                        clearConsole();
                        printEnemies();
                        break;
                    case 5:
                        if (quitAttempts == 2) {
                            clearConsole();
                            System.out.println("Alas, there is no escape. You are bound to this realm... forever");
                            game();
                        } else {
                            if (quitAttempts == 0) {
                                clearConsole();
                                System.out.println("Are you certain you wish to depart?");
                            } else if (quitAttempts == 1) {
                                clearConsole();
                                System.out.println("Do you truly wish to leave this forsaken place?");
                            }
                            quitAttempts++;
                        }
                        break;
                    default:
                        clearConsole();
                        System.out.println("Thy choice is tainted. Please enter a valid option.");
                }
            }
        }
    }   

    public static void game() {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        Enemy enemy = new Enemy();
        inGame = true;
        int width = GameStats.WIDTH;
        int height = GameStats.HEIGHT;
        int currentLevel = GameStats.CURRENT_LEVEL;
        int gold = GameStats.GOLD;
        int hp = CharacterStats.PLAYER_HEALTH;
        int str = CharacterStats.PLAYER_DAMAGE;
        int exp = GameStats.EXP;
        System.out.println("You step into the abyss, embarking on a new quest...");
        System.out.println("---------------------------------------------------");
        System.out.println("");
        MapGenerator mapGenerator = new MapGenerator(width, height, player);
        mapGenerator.displayMap(player);
        System.out.println("");
        System.out.println("---------------------------------------------------");
        System.out.println("| Level: " + currentLevel + " | " + color.ANSI_YELLOW + "Gold: " + gold + color.ANSI_RESET + " | "  + color.ANSI_GREEN + "HP: " + hp + color.ANSI_RESET + 
                           " | " + color.ANSI_RED + "STR: " + str + color.ANSI_RESET + " | " + color.ANSI_CYAN + "EXP: " + exp + color.ANSI_RESET + " |");
        System.out.println("---------------------------------------------------");
        System.out.println("");

            while (inGame) {
                String input = scanner.nextLine();
                char choice = input.length() > 0 ? input.charAt(0) : ' ';
                switch (choice) {
                    //Move/Attack
                    case 'i':
                        clearConsole();
                        player.moveUp();
                        enemy.moveTowardsPlayer(player);
                        mapGenerator.updateMap(player);
                        break;
                    case 'j':
                        clearConsole();
                        player.moveLeft();
                        enemy.moveTowardsPlayer(player);
                        mapGenerator.updateMap(player);
                        break;
                    case 'k':
                        clearConsole();
                        player.moveDown();
                        enemy.moveTowardsPlayer(player);
                        mapGenerator.updateMap(player);
                        break;
                    case 'l':
                        clearConsole();
                        player.moveRight();
                        enemy.moveTowardsPlayer(player);
                        mapGenerator.updateMap(player);
                        break;
                    case 'q':
                        clearConsole();
                        System.out.println("This feature is not implemented");
                        System.out.println("---------------------------------------------------");
                        System.out.println("");
                        break;
                    case 'm':
                        clearConsole();
                        printCommands();
                        break;
                    default:
                        clearConsole();
                        System.out.println("Thy choice is tainted. Please enter a valid option.");
                        System.out.println("---------------------------------------------------");
                        System.out.println("");
                        printCommands();
                        continue;
                }
                System.out.println("Player position: " + player.getX() + ", " + player.getY());
                System.out.println("---------------------------------------------------");
                System.out.println("");
                enemy.moveTowardsPlayer(player);

                mapGenerator.displayMap(player);
                System.out.println("");
                System.out.println("---------------------------------------------------");
                System.out.println("| Level: " + currentLevel + " | " + color.ANSI_YELLOW + "Gold: " + gold + color.ANSI_RESET + " | "  + color.ANSI_GREEN + "HP: " + hp + color.ANSI_RESET + 
                                " | " + color.ANSI_RED + "STR: " + str + color.ANSI_RESET + " | " + color.ANSI_CYAN + "EXP: " + exp + color.ANSI_RESET + " |");
                System.out.println("---------------------------------------------------");
                System.out.println("");
            }
    }

    public static class Player {
        private int previousX;
        private int previousY;
        private int x, y;
        public Player() {
            Random random = new Random();
            this.x = random.nextInt(GameStats.WIDTH);
            this.y = random.nextInt(GameStats.HEIGHT);
        }
        public void moveUp() {
            if (this.y > 0) {
                this.previousX = this.x;
                this.previousY = this.y;
                this.y--;
            }
        }
        public void moveDown() {
            if (this.y < GameStats.HEIGHT - 1) {
                this.previousX = this.x;
                this.previousY = this.y;
                y++;
            }
        }
        public void moveLeft() {
            if (this.x > 0) {
                this.previousX = this.x;
                this.previousY = this.y;
                x--;
            }
        }
        public void moveRight() {
            if (this.x < GameStats.WIDTH - 1) {
                this.previousX = this.x;
                this.previousY = this.y;
                x++;
            }
        }
        public int getPreviousX() {
            return this.previousX;
        }
    
        public int getPreviousY() {
            return this.previousY;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }

    public static class Enemy {
        private int x, y;
        private char type;
    
        public Enemy() {
            this.x = 0;
            this.y = 0;
        }
    
        public Enemy(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        public int getX() {
            return x;
        }
    
        public int getY() {
            return y;
        }
    
        public char getType() {
            return type;
        }

        public void moveTowardsPlayer(Player player) {
            int diffX = Math.abs(player.getX() - x);
            int diffY = Math.abs(player.getY() - y);
    
            if (diffX <= 5 && diffY <= 5) {
                if (player.getX() > x) {
                    x++;
                } else if (player.getX() < x) {
                    x--;
                }
    
                if (player.getY() > y) {
                    y++;
                } else if (player.getY() < y) {
                    y--;
                }
            }
        }
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error purging the shadows.");
        }
    }
    public static void printCommands() {
        System.out.println("------------");
        System.out.println("Commands of the Chosen:");
        System.out.println("------------");
        System.out.println("Move North:        'i'");
        System.out.println("Move West:         'j'");
        System.out.println("Move South:        'k'");
        System.out.println("Move East:         'l'");
        System.out.println("Attack North:      'i'");
        System.out.println("Attack West:       'j'");
        System.out.println("Attack South:      'k'");
        System.out.println("Attack East:       'l'");
        //System.out.println("Pick up Item:      ','");
        //System.out.println("Ascend Stairs:     '<'");
        //System.out.println("Descend Stairs:    '>'");
        //System.out.println("Rest in Shadows:   '.'");
        //System.out.println("Quaff a Potion:    'q'");
        //System.out.println("Read a Scroll:     'r'");
        //System.out.println("Unequip:           'T'");
        //System.out.println("Manage Inventory:  'i'");
        System.out.println("Abandon Quest:     'q'");
        //System.out.println("Identify Item:     'I'");
        //System.out.println("Discard Items:     'd'");
        System.out.println("Scroll the Manual: 'm'");
        System.out.println("------------");
    }
    public static void printVisualCues() {
        System.out.println("------------");
        System.out.println("Mystical Signs and Omens:");
        System.out.println("------------");
        System.out.println("Thyself:                @");
        System.out.println("Portal Upward:          <");
        System.out.println("Portal Downward:        >");
        System.out.println("Impenetrable Wall:      #");
        System.out.println("Worn Path:              .");
        System.out.println("Ancient Doorway:        +");
        System.out.println("Nourishment:            %");
        //System.out.println("Elixir of Life:         !");
        //System.out.println("Mysterious Scroll:      ?");
        System.out.println("Glittering Bounty:      $");
        //System.out.println("Enchanted Relics:       &");
        //System.out.println("Arcane Wand:            \"");
        //System.out.println("Stacked Relics:         ]");
        //System.out.println("Glimmering Ring:        =");
        //System.out.println("Adversaries (HP > 10):  )");
        //System.out.println("Adversaries (HP > 30):  }");
        System.out.println("------------");
    }
    public static void printEnemies() {
        System.out.println("------------");
        System.out.println("Adversaries of the Abyss:");
        System.out.println("------------");
        System.out.println("Archer:         A");
        System.out.println("Bat:            B");
        System.out.println("Dragon:         D");
        System.out.println("Elf:            E");
        System.out.println("Hobbit:         H");
        System.out.println("Leprechaun:     L");
        System.out.println("Orc:            O");
        System.out.println("Purple Worm:    P");
        System.out.println("Rust Monster:   R");
        System.out.println("Vampire:        V");
        System.out.println("Werewolf:       W");
        System.out.println("Zombie:         Z");
        System.out.println("------------");
        /*
        System.out.println("Artifacts and Relics:");
        System.out.println("------------");
        System.out.println("Potion of Vitality:        a");
        System.out.println("Scroll of Summoning:       b");
        System.out.println("Dagger of Shadows:         d");
        System.out.println("Scroll of Illumination:    e");
        System.out.println("Scroll of Revelation:      h");
        System.out.println("Scroll of Provisions:      o");
        System.out.println("Scroll of Punishment:      p");
        System.out.println("Ring of Warding:           r");
        System.out.println("Scroll of Enchantment:     s");
        System.out.println("Scroll of Cartography:     v");
        System.out.println("Shortsword of Retribution: w");
        System.out.println("Longsword of Valor:        x");
        System.out.println("------------");
        */
    }
}