

public class Triangle implements Surface {
    private Vector[] vertices;
    private int mat_idx;

    public Triangle(Vector pos1, Vector pos2, Vector pos3, int mat_idx) {
        this.vertices = new Vector[3];
        this.vertices[0] = pos1;
        this.vertices[1] = pos2;
        this.vertices[2] = pos3;
        this.mat_idx = mat_idx;
    }

    public double[] findIntersection(Ray ray, RayTracer scene) {
        boolean isIntersect = true;

        // calculating the triangle plane
        Vector vec1 = vertices[1].minus(vertices[0]);
        Vector vec2 = vertices[2].minus(vertices[0]);
        Vector planeN = vec1.cross(vec2).direction();
        double offset = - (vertices[0].dot(planeN));

        Plane trgPlane = new Plane(planeN, offset, -1);
        double[] t = trgPlane.findIntersection(ray, scene);
        if (t == null) {
            return null;
        }

        // checking intersection with triangle
        Vector p0 = scene.getCamera().getPosition();
        Vector p = ray.getStart().plus(ray.getDir().scale(t[0]));
        for (int i = 0; i < 3; i++) {
            // V1 = T1 - p0
            Vector v1 = vertices[i%3].minus(p0);
            // V2 = T2 - p0
            Vector v2 = vertices[(i+1)%3].minus(p0);
            // N1 = V1 x V2
            Vector N = v1.cross(v2);
            // Normalize N1
            N = N.direction();

            if (p.minus(p0).dot(N) < 0) {
                isIntersect = false;
            }
        }

        if (isIntersect) {
            return t;
        }
        else {
            return null;
        }
    }

    public Vector getNormalVector(Vector vec)  {
        Vector vec1 = vertices[1].minus(vertices[0]);
        Vector vec2 = vertices[2].minus(vertices[0]);
        Vector planeN = vec1.cross(vec2).direction();

        return planeN;
    }
}
