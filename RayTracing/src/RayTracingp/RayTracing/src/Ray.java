/**
 * Created by Admin on 29/05/2017.
 */
public class Ray {

    Vector start;
    Vector dir;

    public Ray(Vector start, Vector dir) {
        this.start = start;
        this.dir = dir;
    }

    public static Ray constructRayThroughPixel(Camera camera, int i, int j) {
        return null;
    }

    public Vector getStart() {
        return start;
    }

    public Vector getDir() {
        return dir;
    }
}
