

public class Sphere implements Surface {
    private Vector center;      // position of the sphere center (x, y, z)
    private float radius;       // radius
    private int mat_idx;        // material index

    public Sphere(Vector center, float radius, int mat_idx) {
        this.center = center;
        this.radius = radius;
        this.mat_idx = mat_idx;
    }

    public double[] findIntersection(Ray ray, RayTracer scene) {
        // using geometric method (not algebraic)
        // L = O - p0
        Vector L = center.minus(scene.getCamera().getPosition());

        // t_ca = L * V
        double t_ca = L.dot(ray.getDir());
        if (t_ca < 0) {     // no intersection
            return null;
        }

        double d_2 = L.dot(L) - (t_ca * t_ca);
        double r_2 = radius * radius;
        if (d_2 > r_2) {    // no intersection
            return null;
        }

        // two intersection points:
        // t_hc = sqrt(r^2 - d^2)
        double t_hc = Math.sqrt(r_2 - d_2);

        double[] t = new double[2];
        t[0] = t_ca - t_hc;
        t[1] = t_ca + t_hc;
        return t;
    }

    public Vector getNormalVector(Vector vec)  {
        // N = P - O
        Vector N = vec.minus(center);
        // N = (P - O) / ||P - O||
        N = N.direction();

        return N;
    }
}
