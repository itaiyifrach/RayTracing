


public class Intersection {

    private Surface hitSurface;
    private Vector hitPoint;
    private Vector rayDirectionVector;

    public Intersection(Surface hitSurface, Vector hitPoint, Vector directionVector)
    {
        this.hitPoint = new Vector(hitPoint);
        this.hitSurface = hitSurface;
        this.rayDirectionVector = directionVector;
    }

    public Ray getReflectionRay(Ray ray) {
        Vector dir = ray.getDirectionVector();

        // getting normal vector
        Vector N = hitSurface.getNormalVector(hitPoint);
        N = N.scale(-1);

        // reflection direction
        double dp = dir.dot(N);
        if(dp < 0) {
            dp = 0;
        }

        // calculating reflection direction vector
        double[] result = {0.0, 0.0, 0.0};
        for (int i = 0; i < 3; i++) {
            double normalAxis = N.cartesian(i);
            double directionAxis = dir.cartesian(i);
            result[i] = directionAxis - 2*normalAxis*dp;
        }
        Vector refDirection = (new Vector(result)).direction();

        return new Ray(ray.getStartPoint(), refDirection);
    }

    public Surface getSurface() {
        return hitSurface;
    }


    public Vector getRayDirectionVector() {
        return rayDirectionVector;
    }

    public Vector getHitPoint() {
        return hitPoint;
    }
}
