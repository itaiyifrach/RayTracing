

public class Sphere implements Surface {
    private Vector center;      // position of the sphere center (x, y, z)
    private float radius;       // radius
    private int mat_idx;        // material index

    public Sphere(Vector center, float radius, int mat_idx) {
        this.center = center;
        this.radius = radius;
        this.mat_idx = mat_idx;
    }

    public Vector findIntersection(Ray ray, RayTracer scene) {
        // using geometric method (not algebraic)
        double[] data = new double[3];
        Vector L = new Vector(center);

        // L = O - p0
        L.minus(scene.getCamera().getPosition());

        return null;
    }
}
