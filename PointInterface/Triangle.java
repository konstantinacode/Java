public class Triangle
{
    // class uses three Point instances as its three vertices
    private PointInterface v1;
    private PointInterface v2;
    private PointInterface v3;

    // create and initialize a Triangle given three instances of Point
    public Triangle(PointInterface v1, PointInterface v2, PointInterface v3)
    {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    // sum of any two sides must be larger than the remaining side
    public boolean checkValidity()
    {
        double side1 = v1.distanceTo(v2);
        double side2 = v2.distanceTo(v3);
        double side3 = v3.distanceTo(v1);

        if ((side1 + side2 > side3) && (side1 + side3 > side2)
                && (side2 + side3 > side1))
            return true;

        return false;
    }

    // Method to test for a scalene triangle.
    public boolean isScalene()
    {
        double side1 = v1.distanceTo(v2);
        double side2 = v1.distanceTo(v3);
        double side3 = v2.distanceTo(v3);

        if (side1 == side2 || side1 == side3 || side2 == side3)
            return false;

        return true;
    }

    // Method to test for an isosceles triangle.
    public boolean isIsosceles()
    {
        double side1 = v1.distanceTo(v2);
        double side2 = v1.distanceTo(v3);
        double side3 = v2.distanceTo(v3);

        // two sides equal but not all three
        if ((side1 == side2 || side1 == side3 || side2 == side3)
                && !(side1 == side2 && side2 == side3))
            return true;

        return false;
    }

    // Method to test for an equilateral triangle.
    public boolean isEquilateral()
    {
        double side1 = v1.distanceTo(v2);
        double side2 = v1.distanceTo(v3);
        double side3 = v2.distanceTo(v3);

        if (side1 == side2 && side2 == side3)
            return true;

        return false;
    }

    public String getType()
    {
        if (isEquilateral())
            return "Equilateral";
        else if (isIsosceles())
            return "Isosceles";
        else
            return "Scalene";
    }

    // return the length of the perimeter in double. You should use the
    // distanceTo()
    // method of Point to compute the perimeter
    public double getPerimeter()
    {
        return v1.distanceTo(v2) + v2.distanceTo(v3) + v3.distanceTo(v1);
    }

    // using Heron's Formula
    // A = sqrt(s(s - a)(s - b)(s - c))
    public double getArea()
    {
        double s = getPerimeter()/2;
        double a = v1.distanceTo(v2);
        double b = v2.distanceTo(v3);
        double c = v3.distanceTo(v1);

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    // return string representation of this triagle
    public String toString()
    {
        return "[(v1=" + v1.toString() + ", v2=" + v2.toString() + ", v3="
                + v3.toString() + "]";
    }

    // test client
    public static void main(String[] args)
    {
        PointInterface v1 = new Point(0, 0);
        PointInterface v2 = new Point(1, 2);
        PointInterface v3 = new Point(6, 0);

        Triangle t = new Triangle(v1, v2, v3);
        printTriangle(t);

        v2.setX(2);
        v2.setY(0);
        printTriangle(t);

        v2.setX(3);
        v2.setY(4);
        printTriangle(t);

        v2.setY(-Math.sqrt(27));
        printTriangle(t);
    }

    public static void printTriangle(Triangle t)
    {
        boolean valid = t.checkValidity();
        System.out.println("Triangle " + t.toString() + " is " + (valid ? "" : "not ") + "valid");

        if (valid)
        {
            System.out.println("-- Type: " + t.getType());
            System.out.println("-- Area: " + t.getArea());
            System.out.println("-- Perimeter: " + t.getPerimeter());
        }
        System.out.println();
    }
}
