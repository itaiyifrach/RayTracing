


public class Intersection {

    private Surface hitSurface;
    private Vector hitPoint;

    public Intersection(Surface hitSurface, Vector hitPoint)
    {
        this.hitPoint = new Vector(hitPoint);
        this.hitSurface = hitSurface;
    }

    public Ray getReflectionRay(Ray ray) {
        Vector dir = ray.getDirection();

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

        return new Ray(ray.getStart(), refDirection);
    }

    public Surface getSurface() {
        return hitSurface;
    }

    public Vector getPoint() {
        return hitPoint;
    }
}
