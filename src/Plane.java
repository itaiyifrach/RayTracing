

public class Plane implements Surface {
    Vector position;
    int offset;
    int mat_idx;

    public Plane(Vector position, int offset, int mat_idx) {
        this.position = position;
        this.offset = offset;
        this.mat_idx = mat_idx;
    }

    public Ray findIntersection(Ray ray, RayTracer scene) {
        return null;
    }
}
