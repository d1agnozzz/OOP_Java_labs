/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

//    public boolean equals(Location location){
//        return (this.xCoord == location.xCoord && this.yCoord == location.yCoord);
//    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Location)) return false;
        if (this == obj) return true;

        Location location = (Location)obj;
        return (this.xCoord == location.xCoord &&
                this.yCoord == location.yCoord);
    }

    @Override
    public int hashCode(){
        return xCoord * 31 + yCoord;
    }
}
