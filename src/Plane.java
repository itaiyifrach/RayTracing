

public class Plane implements Surface {
    private Vector position;
    private int offset;
    private int mat_idx;

    public Plane(Vector position, int offset, int mat_idx) {
        this.position = position;
        this.offset = offset;
        this.mat_idx = mat_idx;
    }

    public double[] findIntersection(Ray ray, RayTracer scene) {
        return null;
    }
}
