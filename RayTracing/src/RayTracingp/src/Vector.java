/******************************************************************************
 *  Compilation:  javac Vector.java
 *  Execution:    java Vector
 *
 *  Implementation of a vector of real numbers.
 *
 *  This class is implemented to be immutable: once the client program
 *  initialize a Vector, it cannot change any of its fields
 *  (N or data[i]) either directly or indirectly. Immutability is a
 *  very desirable feature of a data type.
 *
 *
 *  % java Vector
 *  x        =  (1.0, 2.0, 3.0, 4.0)
 *  y        =  (5.0, 2.0, 4.0, 1.0)
 *  x + y    =  (6.0, 4.0, 7.0, 5.0)
 *  10x      =  (10.0, 20.0, 30.0, 40.0)
 *  |x|      =  5.477225575051661
 *  <x, y>   =  25.0
 *  |x - y|  =  5.0990195135927845
 *
 *  Note that java.util.Vector is an unrelated Java library class.
 *
 ******************************************************************************/

public class Vector {

    private final int n;         // length of the vector
    private double[] data;       // array of vector's components

    // create the zero vector of length n
    public Vector(int n) {
        this.n = n;
        this.data = new double[n];
    }

    // create a vector from an array
//    public Vector(double[] data) {
//        n = data.length;
//
//        // defensive copy so that client can't alter our copy of data[]
//        this.data = new double[n];
//        for (int i = 0; i < n; i++)
//            this.data[i] = data[i];
//    }

    // create a vector from either an array or a vararg list
    // this constructor uses Java's vararg syntax to support
    // a constructor that takes a variable number of arguments, such as
    // Vector x = new Vector(1.0, 2.0, 3.0, 4.0);
    // Vector y = new Vector(5.0, 2.0, 4.0, 1.0);

    public Vector(double... data) {
        n = data.length;

        // defensive copy so that client can't alter our copy of data[]
        this.data = new double[n];
        for (int i = 0; i < n; i++)
            this.data[i] = data[i];
    }

    // copy constructor
    public Vector(Vector vec) {
        this.n = vec.n;

        // defensive copy so that client can't alter our copy of data[]
        this.data = new double[n];
        for (int i = 0; i < n; i++)
            this.data[i] = vec.data[i];
    }

    // return the length of the vector
    public int length() {
        return n;
    }

    // return the inner product of this Vector a and b
    public double dot(Vector vec) {
        if (this.length() != vec.length())
            throw new IllegalArgumentException("dimensions disagree");
        double sum = 0.0;
        for (int i = 0; i < n; i++)
            sum = sum + (this.data[i] * vec.data[i]);
        return sum;
    }

    public static Vector fixedUpDirection(Vector towards){
        double[] vectorData = towards.data;
        int coordinate = -1;
        for(int i=0; i<3; i++){
            if(vectorData[i] == 0){
                coordinate = i;
                break;
            }
        }
        Vector upDirection = null;
        switch (coordinate){
            case -1:
                upDirection = new Vector(1,1, -(towards.data[0]+ towards.data[1])/towards.data[2]);
                break;
            case 0:
                upDirection = new Vector(1,0, 0);
                break;
            case 1:
                upDirection = new Vector(0,1, 0);
                break;
            case 2:
                upDirection = new Vector(0,0, 1);
                break;
        }
        return upDirection;

    }

    // return the cross product of this Vector a and b
    public Vector cross(Vector vec) {
        if (this.length() != vec.length())
            throw new IllegalArgumentException("dimensions disagree");
        double[] vecData = new double[n];

        vecData[0] = this.data[1] * vec.data[2] - vec.data[1] * this.data[2];
        vecData[1] = this.data[2] * vec.data[0] - vec.data[2] * this.data[0];
        vecData[2] = this.data[0] * vec.data[1] - vec.data[0] * this.data[1];

        return new Vector(vecData);
    }

    // return the Euclidean norm of this Vector
    public double norm() {
        return Math.sqrt(this.dot(this));
    }

    // return the Euclidean distance between this and that
    public double distanceTo(Vector vec) {
        if (this.length() != vec.length())
            throw new IllegalArgumentException("dimensions disagree");
        return this.minus(vec).norm();
    }

    // return this + that
    public Vector plus(Vector that) {
        if (this.length() != that.length())
            throw new IllegalArgumentException("dimensions disagree");
        Vector c = new Vector(n);
        for (int i = 0; i < n; i++)
            c.data[i] = this.data[i] + that.data[i];
        return c;
    }

    // return this - that
    public Vector minus(Vector vec) {
        if (this.length() != vec.length())
            throw new IllegalArgumentException("dimensions disagree");
        Vector c = new Vector(n);
        for (int i = 0; i < n; i++)
            c.data[i] = this.data[i] - vec.data[i];
        return c;
    }

    // return the corresponding coordinate
    public double cartesian(int i) {
        return data[i];
    }

    // create and return a new object whose value is (this * factor)
    public Vector scale(double factor) {
        Vector c = new Vector(n);
        for (int i = 0; i < n; i++)
            c.data[i] = factor * data[i];
        return c;
    }

    // return the corresponding unit vector
    public Vector direction() {
        if (this.norm() == 0.0)
            throw new ArithmeticException("zero-vector has no direction");
        return this.scale(1.0 / this.norm());
    }

    // return a string representation of the vector
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append('(');
        for (int i = 0; i < n; i++) {
            s.append(data[i]);
            if (i < n-1) s.append(", ");
        }
        s.append(')');
        return s.toString();
    }


    // test client
//    public static void main(String[] args) {
//        double[] xdata = { 1.0, 2.0, 3.0, 4.0 };
//        double[] ydata = { 5.0, 2.0, 4.0, 1.0 };
//
//        Vector x = new Vector(xdata);
//        Vector y = new Vector(ydata);
//
//        System.out.println("x        =  " + x);
//        System.out.println("y        =  " + y);
//        System.out.println("x + y    =  " + x.plus(y));
//        System.out.println("10x      =  " + x.scale(10.0));
//        System.out.println("|x|      =  " + x.norm());
//        System.out.println("<x, y>   =  " + x.dot(y));
//        System.out.println("|x - y|  =  " + x.minus(y).norm());
//        System.out.println("x dir  =  " + x.direction());
//        System.out.println("x = "+x.toString());
//    }
}