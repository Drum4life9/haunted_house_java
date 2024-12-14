import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
/**
 * The Escape Engine generates a "maze-like" house with rooms.  It then 
 * controls game play to allow players to find their way out of the house.
 * @author  B. Myers
 * @version 18 November 2019
 */
public class HauntedHouseEngine
{
    // Create the blank room objects for the house.
    public static InfoRoom roomStart = new InfoRoom(1);
    public static InfoRoom room2 = new InfoRoom(2);
    public static InfoRoom room3 = new InfoRoom(3);
    public static QuizRoom room4;
    public static InfoRoom room5 = new InfoRoom(5);
    public static InfoRoom room6 = new InfoRoom(6);
    public static InfoRoom room7 = new InfoRoom(7);
    public static InfoRoom room8 = new InfoRoom(8);
    public static QuizRoom room9;
    public static InfoRoom room10 = new InfoRoom(10);
    public static QuizRoom room11;
    public static InfoRoom room12 = new InfoRoom(12);
    public static InfoRoom room13 = new InfoRoom(13);
    public static QuizRoom room14;
    public static Room room15 = new Room(15);
    
    public static Room end = new Room(16);        
    public static Room currentRoom;
    
    //info data
    private static boolean hasFL = false, hasBat = false;
    private static int[] combo, gatheredNums;
    private static int[] roomCounts;
    
    public static void runEngine()
    {
        Scanner input = new Scanner(System.in);
        String direction;
        
        combo = createCombo(4);
        
        // Build the rooms to the house and set the current room.
        buildRooms();
        currentRoom = room4;
        
        displayTitle();
        
        // Loop until the player exits the house
        do
        {
            //Get the adjacent rooms
            Room northOf = currentRoom.getNorth();
            Room eastOf = currentRoom.getEast();
            Room southOf = currentRoom.getSouth();
            Room westOf = currentRoom.getWest();
            
            // Determine the direction of each room
            boolean canGoNorth = currentRoom.canGoDir(northOf);
            boolean canGoEast = currentRoom.canGoDir(eastOf);
            boolean canGoSouth = currentRoom.canGoDir(southOf);
            boolean canGoWest = currentRoom.canGoDir(westOf);
            
            //Get direction to travel
            System.out.println(currentRoom);
            
            do {
                System.out.print("Options:\n1) Enter direction to go (n, s, e, w)\n2) Enter 'inv' for inventory\n3) Enter 'map' for map\n4) Enter 'notes' for note sheet\n");
                direction = input.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                if (direction.equals("inv"))
                    printInv();
                else if (direction.equals("map"))
                    printMap();
                else if (direction.equals("notes")) continue;
                else
                    break;
            } while (true);
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            
            // Set the current room to the new room
            if (canGoNorth && direction.equals("n")) currentRoom = northOf;
            else if (canGoEast && direction.equals("e")) currentRoom = eastOf;
            else if (canGoSouth && direction.equals("s")) currentRoom = southOf;
            else if (canGoWest && direction.equals("w")) currentRoom = westOf;
            else System.out.println("Your location did not change!");
            
            switch(currentRoom.id()) {
                case 1:
                    
                    break;
                case 2:
                        
                    break;
                case 3:
                    
                    break;
                case 4:
                    currentRoom.activateRoom();
                    break;
                case 5:
                    
                    break;
                case 6:
                    hasFL = true;
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 9:
                    currentRoom.activateRoom();
                    break;
                case 10:
                    
                    break;
                case 11:
                    currentRoom.activateRoom();
                    break;
                case 12:
                    hasBat = true;
                    break;
                case 13:
                    
                    break;
                case 14:
                    currentRoom.activateRoom();
                    break;
                case 15:
                    
                    break;
            }
            currentRoom.found();
            
            
        }while(currentRoom.getInMaze());
    }
    
    /**
     * Build each room of the house.
     */
    private static void buildRooms()
    {
        //ENGINE HANDLES ASSIGNMENT, ROOM HANDLES QUIZ AND INFO
        roomStart.found();
        roomStart.setColor("Black");
        roomStart.setString("Welcome!");
        
        
        room4 = new QuizRoom(4, 0);
        
        
        room9 = new QuizRoom(9, 0);
 
        
        room11 = new QuizRoom(11, 0);
        
        
        room14 = new QuizRoom(14, 0);
        end.setInMaze(false);
    }
    
    /**
     * Display the title using ASCII art and escape keys.
     * @see https://www.asciiart.eu/buildings-and-places/houses
     */
    private static void displayTitle()
    {
        System.out.println("   ____                       ___                ");
        System.out.println("  / __/_________ ____  ___   / _ \\___  ___  __ _ ");
        System.out.println(" / _/(_-< __/ _ `/ _ \\/ -_) / , _/ _ \\/ _ \\/  ' \\");
        System.out.println("/___/___|__/\\_,_/ .__/\\__/ /_/|_|\\___/\\___/_/_/_/");
        System.out.println("               /_/                               ");                                                                                                                                                                                                                                                     

        
    }
    
    private static int[] createCombo(int inp) {
        int[] c = new int[inp];
        gatheredNums = new int[inp];
        for (int i = 0; i < c.length; i++) {
            Random rn = new Random();
            int num = Math.abs((rn.nextInt() % 10) + 1);
            
            c[i] = num;
            gatheredNums[i] = -1;
        }
        
        return c;
    }
    
    public static void completeComboNum(int i) {
        gatheredNums[i] = combo[i];
    }
    
    private static void printInv() {
        String s = new String();
        s += "You have collected: \n";
        s += "\tFlashlight: ";
        s += (hasFL) ? "Yes\n" : "No\n";
        s += "\tBatteries: ";
        s += (hasBat) ? "Yes\n" : "No\n";
        s += "Your combo code so far: ";
        for (int i : gatheredNums) s += (i + " ");
        
        System.out.println(s + "\n\n");
    }
    
    private static void printMap() {
        System.out.println("+---------+"); //TODO DURING CLASS
        //use room1.printFound();
    }
}