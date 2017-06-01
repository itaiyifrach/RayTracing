

public class Ray {
    Vector startPoint;
    Vector directionVector;

    public Ray(Vector start, Vector direction) {
        this.startPoint = new Vector(start);
        this.directionVector = new Vector(direction);
    }

    public static Ray constructRayThroughPixel(Camera camera, int i, int j, int imageWidth, int imageHeight, double pixelWidth, double pixelHeight) {
        Vector P = camera.getScreenCenterPoint();
        double moveX = (imageWidth / 2 - i) * pixelWidth;
        double moveY = (imageHeight / 2 - j) * pixelHeight;

        Vector _X_ = camera.getRightDirection();
        _X_ = VectorArithmetic.scalarMultiplication(_X_, moveX);


        Vector _Y_ = camera.getUpDirection();
        _Y_ = VectorArithmetic.scalarMultiplication(_Y_, moveY);

        // calculating P new position from the center
        P = VectorArithmetic.plus(P,VectorArithmetic.plus(_X_, _Y_));

        // calculating direction vector (P - p0)
        Vector p0 = camera.getPosition();
        Vector V = VectorArithmetic.Normalize(VectorArithmetic.minus(P, p0));

        return new Ray(p0, V);
    }

    /**
     *  calculating (P = p0 + t*V)
     */
    public Vector getPoint(double t) {
        return VectorArithmetic.plus(startPoint, VectorArithmetic.scalarMultiplication(directionVector, t));
    }

    public Vector getStartPoint() {
        return startPoint;
    }

    public Vector getDirectionVector() {
        return directionVector;
    }

    public void printRay() {
        System.out.println(startPoint.toString() + "+ t" + directionVector.toString());
    }
}
