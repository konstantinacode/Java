public class Point implements PointInterface
{
    private double x; // Cartesian
    private double y; // coordinates

    // create and initialize a point with given (x, y)
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getX()
    {
        return x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getY()
    {
        return y;
    }

    // return Euclidean distance between invoking point p and q
    public double distanceTo(PointInterface that)
    {
        double dx = this.x - that.getX();
        double dy = this.y - that.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    // scale Point closer by half to (0,0)
    public PointInterface scale()
    {
        return new Point(this.x / 2, this.y / 2);
    }

    // find center between 2 Points
    public PointInterface center(PointInterface that)
    {
        double centerX = (this.x + that.getX()) / 2;
        double centerY = (this.y + that.getY()) / 2;

        return new Point(centerX, centerY);
    }

    // return string representation of this point
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

    // test client
    public static void main(String[] args)
    {
        PointInterface p = new Point(1, 2);
        System.out.println("p  = " + p.toString());

        PointInterface q = new Point(3, 3);
        System.out.println("q  = " + q.toString());
        System.out.println("dist(p, q) = " + p.distanceTo(q));
        System.out.println("center between p and q = " + p.center(q));

        PointInterface scaled_p = p.scale();
        System.out.println("scaled p  = " + scaled_p.toString());
        System.out.println("dist(p, q) = " + scaled_p.distanceTo(q));
        System.out.println("center between p and q = " + scaled_p.center(q));
    }
}
