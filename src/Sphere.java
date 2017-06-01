/**
 * this class extends  the abstract class - Geometry, represents Sphere object.
 * Sphere object represented by 2-tuple : <Vector center_point, float radius>.
 */
public class Sphere extends Geometry implements Surface {

    private Vector centerSpherePoint;      // position of the sphere center (x, y, z)
    private float sphereRadius;       // radius

    public Sphere(Vector center, float radius, int mat_idx) {
        super(mat_idx);
        this.centerSpherePoint = center;
        this.sphereRadius = radius;
    }

    /**
     * Ray obj represents as 2-tuple (P_0 := startPoint, V := direction Vector),
     * where each point P on the ray is a function of t at R - each point P = P_0 +tV;
     *
     * Ray: P = P0 + tV
     * Sphere: |P - O|2 - r 2 = 0
     * L = O - P0
     * tca = L • V
     * if (tca < 0) return 0
     * d2 = L • L - tca2
     *  if (d2 > r2) return 0
     *  thc = sqrt(r2 - d2)
     *  t = tca - thc and tca+ thc

     * @param ray P = P0 + tV
     * @return
     */
    public Vector findIntersection(Ray ray) {
        // using geometric method (not algebraic)
        // L = O - p0

        Vector L = VectorArithmetic.minus(ray.getStartPoint(), centerSpherePoint);

        // t_ca = L * V
        double t_ca = VectorArithmetic.dot(L, ray.getDirectionVector());
        if (t_ca < 0) {     // no intersection
            //System.out.println("no inter 1");
            return null;
        }

        double d_2 = VectorArithmetic.dot(L,L) - (t_ca * t_ca);
        double r_2 = sphereRadius * sphereRadius;
        if (d_2 > r_2) {    // no intersection
            //System.out.println("no inter 2");
            return null;
        }

        // two intersection points:
        // t_hc = sqrt(r^2 - d^2)
        double t_hc = Math.sqrt(r_2 - d_2);

        // two intersection points...
        double t0 = t_ca - t_hc;
        double t1 = t_ca + t_hc;

        // checking which point is closer to p0 (camera position)
        Vector p1 = ray.getPoint(t0);
        Vector p2 = ray.getPoint(t1);
        if (VectorArithmetic.distanceTo(p1, ray.getStartPoint()) <=  VectorArithmetic.distanceTo(p2, ray.getStartPoint())) {
            return p1;
        }
        else {
            return p2;
        }
    }

    public Vector getNormalVector(Vector vec)  {
        // N = P - O
        Vector N = VectorArithmetic.minus(vec, centerSpherePoint);
        // N = (P - O) / ||P - O||
        N = VectorArithmetic.Normalize(N);
        return N;
    }

    @Override
    public int getMaterialIndex() {
        return this.materialIndex();
    }

    @Override
    public Material getMaterial() {
        return this.material;
    }

}
