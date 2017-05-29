

public class Sphere implements Surface {
    Vector center;
    float radius;
    int mat_idx;

    public Sphere(Vector center, float radius, int mat_idx) {
        this.center = center;
        this.radius = radius;
        this.mat_idx = mat_idx;
    }

    public Ray findIntersection(Ray ray, RayTracer scene) {
        return null;
    }
}
