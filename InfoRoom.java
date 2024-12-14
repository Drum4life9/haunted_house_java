
/**
 * Write a description of class InfoRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InfoRoom extends Room
{
    private String info;
    
    public InfoRoom(int i) {super(i);}
    
    public void setString(String s) {info = s;}
    
    public String toString() {
        String s = super.toString();
        
        return info + "\n" + s;
    }

}
