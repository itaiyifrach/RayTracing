

public class Plane implements Surface {
    private Vector position;
    private double offset;
    private int mat_idx;

    public Plane(Vector position, double offset, int mat_idx) {
        this.position = position;
        this.offset = offset;
        this.mat_idx = mat_idx;
    }

    public Vector findIntersection(Ray ray, RayTracer scene) {
        // p0*N + c
        double temp1 = ray.getStart().dot(position) + offset;
        // V*N
        double temp2 = ray.getDirection().dot(position);

        double t = - (temp1 / temp2);
        return ray.getPoint(t);
    }

    public Vector getNormalVector(Vector vec)  {
        return position;
    }

    public int getMaterialIndex() {
        return mat_idx;
    }
}
