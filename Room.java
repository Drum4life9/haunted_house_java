import java.util.ArrayList;
/**
 * Write a description of class Room here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Room
{
    private Room north, south, east, west;
    private String desc, color;
    private boolean inMaze = true, found = false;
    private int id;
    
    public Room(int i) {id = i;}
    
    Room getNorth() {return this.north;}
    Room getSouth() {return this.south;}
    Room getEast() {return this.east;}
    Room getWest() {return this.west;}    
    
    ArrayList<Room> getRooms() {
        ArrayList<Room> rs = new ArrayList<Room>();
        rs.add(north);
        rs.add(south);
        rs.add(east);
        rs.add(west);

        return rs;
    }
    
    void setNorth(Room r) {this.north = r;}
    void setSouth(Room s) {this.south = s;}
    void setEast(Room e) {this.east = e;}
    void setWest(Room w) {this.west = w;}
    
    boolean canGoDir(Room r) {
        if (r == null) return false;
        return r.getRooms().contains(this);
    } 
    
    void setDesc(String s) {desc = s;}
    
    void setInMaze(boolean b) {inMaze = b;}
    
    void setColor(String s) {color = s;}
    
    void found() {found = true;}
    
    int id() {return id;}
    
    String printFound() {
        String m = new String();
        if (found) {
            m += color;
            for (int i = 0; i <= 7 - color.length(); i++)
                m += " ";
            return m;
        }
        return "        ";
    }
    
    boolean getInMaze() {return inMaze;}
    
    public String toString() {
        String s = new String();
        
        s += "\nPossible directions are: \n";
        if (north != null) s += "\tnorth\n";
        if (south != null) s += "\tsouth\n";
        if (east != null) s += "\teast\n";
        if (west != null) s += "\twest\n  ";
        
        return s;
    }
    
    public void activateRoom() {}
}
