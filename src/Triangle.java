

public class Triangle implements Surface {
    Vector pos1;
    Vector pos2;
    Vector pos3;
    int mat_idx;

    public Triangle(Vector pos1, Vector pos2,  Vector pos3, int mat_idx) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
        this.mat_idx = mat_idx;
    }

    public Ray findIntersection(Ray ray, RayTracer scene) {
        return null;
    }
}
