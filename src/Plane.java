
/**
 * this class extends  the abstract class - Geometry, represents Plane object.
 * Plane object represented by 2-tuple : <Vector center_point, float radius>.
 */
public class Plane extends Geometry implements Surface {
    private Vector tPlaneNormal;
    private double tPlaneOffset;
    private Vector tPointOnPlane;


    public Plane(Vector planeNormal, double planeOffset, int matIndex) {
        super(matIndex);
        this.tPlaneNormal = new Vector(planeNormal);
        this.tPlaneOffset = planeOffset;

        this.fixedThePlaneNormal(tPlaneNormal);
    }

    /**
     * this method checks X, Y, X coordinates
     * @param planeNormal
     */
    private void fixedThePlaneNormal(Vector planeNormal){

        double x = planeNormal.cartesian(0);
        double y = planeNormal.cartesian(1);
        double z = planeNormal.cartesian(2);

        if (x != 0) {
            this.tPointOnPlane = new Vector(this.tPlaneOffset / x, 0, 0);
        }
        else if (y != 0) {
            this.tPointOnPlane = new Vector(0, this.tPlaneOffset / y, 0);
        }
        else if (z != 0) {
            this.tPointOnPlane = new Vector(0, 0, this.tPlaneOffset / z);
        }
    }


    public Vector findIntersection(Ray ray) {
        // Ray = p0 + tV
        Vector p0 = new Vector(ray.getStartPoint());
        Vector V = new Vector(ray.getDirectionVector());

        if (VectorArithmetic.dot(V, tPlaneNormal) == 0) {
            // its mean that Ray_|_planeNormal ans s.t. ray will never hit the plane !!!
            return null;
        }

        Vector temp = VectorArithmetic.minus(p0, tPointOnPlane);
        double temp1 = VectorArithmetic.dot(temp, tPlaneNormal);
        // V*N
        double temp2 =  VectorArithmetic.dot(V, tPlaneNormal);

        double t = temp1 / temp2;
        if (t < 0) {
            return null;
        }
        else {
            return ray.getPoint(t);
        }
    }

    @Override
    public int getMaterialIndex() {
        return this.materialIndex();
    }

    public Vector getNormalVector(Vector vec)  {
        return tPlaneNormal;
    }

    @Override
    public Material getMaterial() {
        return this.material;
    }

}
