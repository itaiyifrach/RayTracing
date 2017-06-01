

public class Camera {

    private Vector positionPoint;
    private Vector lookAtPointVector;
    private Vector up;
    private Vector towardsDirection;
    private Vector rightDirection;
    private Vector upDirectionVector;
    private float screenDistance;
    private float screenWidth;

    public Camera(Vector position, Vector lookAtPoint, Vector up, float dist, float width) {
        this.positionPoint = position;
        this.lookAtPointVector = lookAtPoint;
        this.up = up;
        this.screenDistance = dist;
        this.screenWidth = width;

        // calculating towards, right, and up directions of camera and fixed upDirection if we need;
        this.towardsDirection = VectorArithmetic.minus(lookAtPointVector, positionPoint).direction();
        this.rightDirection = VectorArithmetic.cross(towardsDirection, up).direction();
        this.upDirectionVector = VectorArithmetic.cross(rightDirection, towardsDirection);
    }

    /**
     * // center point is (p0 + d*towards)
     * @return Vector _Z_ represents the center point of camera screen, where _Z_ := _positionPoint_ + (screenDistance*_towardsDirection_);
     */
    public Vector getScreenCenterPoint() {
        Vector centerPointVector = VectorArithmetic.plus(positionPoint, VectorArithmetic.scalarMultiplication(towardsDirection,screenDistance));

        return centerPointVector;
    }

    public Vector getPosition() {
        return positionPoint;
    }

    public Vector getLookAtPointVector() {
        return lookAtPointVector;
    }

    public Vector getUp() {
        return up;
    }

    public Vector getTowardsDirection() {
        return towardsDirection;
    }

    public Vector getRightDirection() {
        return rightDirection;
    }

    public Vector getUpDirection() {
        return upDirectionVector;
    }

    public float getScreenDist() {
        return screenDistance;
    }

    public float getScreenWidth() {
        return screenWidth;
    }
}
