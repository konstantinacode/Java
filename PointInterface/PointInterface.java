public interface PointInterface
{
    public void setX(double x);

    public double getX();

    public void setY(double y);

    public double getY();

    // return Euclidean distance between invoking point p and q
    public double distanceTo(PointInterface that);

    // scale Point closer by half to (0,0)
    public PointInterface scale();

    // find center between 2 Points
    public PointInterface center(PointInterface that);

    // return string representation of this point
    public String toString();
}
