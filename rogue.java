package rogue;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;

public class rogue {
    private static boolean inGame = false;

    private static int playerX;
    private static int playerY;
    private static int width;
    private static int height;
    private static int currentLevel = 1;
    private static int gold = 0;
    private static int hp = 100;
    private static int str = 10;
    private static int exp = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        clearConsole();
        System.out.println("Welcome to the cursed realm of Rogue!");
        System.out.println("Your sole purpose here is to amass treasures");
        System.out.println("and ascend the unfathomable depths of THE DUNGEON.");
        System.out.println("Remember, your journey shall end when darkness consumes you.");
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
                System.out.print("What is your choice, adventurer? ");
            }

            int choice = scanner.nextInt();

            if (!inGame) {
                switch (choice) {
                    case 1:
                        clearConsole();
                        startNewGame();
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
                            startNewGame();
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

    public static void startNewGame() {
        Scanner scanner = new Scanner(System.in);
        inGame = true;
        width = 80;
        height = 30;
        currentLevel = 0;
        gold = 0;
        hp = 100;
        str = 10;
        exp = 0;
        System.out.println("You step into the abyss, embarking on a new quest...");
        System.out.println("| Level: " + currentLevel + " | Gold: " + gold + " | HP: " + hp + " | STR: " + str + " | EXP: " + exp + " |");

        int choice = scanner.nextInt();


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
        System.out.println("Pick up Item:      ','");
        System.out.println("Ascend Stairs:     '<'");
        System.out.println("Descend Stairs:    '>'");
        System.out.println("Rest in Shadows:   '.'");
        System.out.println("Quaff a Potion:    'q'");
        System.out.println("Read a Scroll:     'r'");
        System.out.println("Unequip:           'T'");
        System.out.println("Manage Inventory:  'i'");
        System.out.println("Abandon Quest:     'q'");
        System.out.println("Identify Item:     'I'");
        System.out.println("Discard Items:     'd'");
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
        System.out.println("Elixir of Life:         !");
        System.out.println("Mysterious Scroll:      ?");
        System.out.println("Glittering Bounty:      $");
        System.out.println("Enchanted Relics:       &");
        System.out.println("Arcane Wand:            \"");
        System.out.println("Stacked Relics:         ]");
        System.out.println("Glimmering Ring:        =");
        System.out.println("Adversaries (HP > 10):  )");
        System.out.println("Adversaries (HP > 30):  }");
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
    }
}
