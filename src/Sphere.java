

public class Sphere implements Surface {
    private Vector center;
    private float radius;
    private int mat_idx;

    public Sphere(Vector center, float radius, int mat_idx) {
        this.center = center;
        this.radius = radius;
        this.mat_idx = mat_idx;
    }

    public Vector findIntersection(Ray ray, RayTracer scene) {
        return null;
    }
}
