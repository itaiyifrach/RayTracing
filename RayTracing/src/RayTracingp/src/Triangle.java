

public class Triangle extends Geometry implements Surface {
    private Vector[] triangleVertices;
    private Vector tTriangleNormal;
    private int mat_idx;

    public Triangle(Vector pos1, Vector pos2, Vector pos3, int matIndex) {
        super(matIndex);
        this.triangleVertices = new Vector[3];
        this.triangleVertices[0] = new Vector(pos1);
        this.triangleVertices[1] = new Vector(pos2);
        this.triangleVertices[2] = new Vector(pos3);

        Vector vec1 = triangleVertices[1].minus(triangleVertices[0]);
        Vector vec2 = triangleVertices[2].minus(triangleVertices[0]);

        this.tTriangleNormal = (vec1.cross(vec2)).direction();
    }

    public Vector findIntersection(Ray ray) {
        // calculating the triangle plane
        double offset =  triangleVertices[0].dot(this.tTriangleNormal);
        Plane trgPlane = new Plane(this.tTriangleNormal, offset, mat_idx);

        // finding intersection point with triangle plane
        Vector p = trgPlane.findIntersection(ray);
        if (p == null) {
            return null;
        }

        // checking intersection point with triangle
        // first edge
        Vector edge1 = triangleVertices[1].minus(triangleVertices[0]);
        Vector r1 = p.minus(triangleVertices[0]);
        Vector normal = edge1.cross(r1);
        if (this.tTriangleNormal.dot(normal) < 0) {
            return null;
        }
        // second edge
        Vector edge2 = triangleVertices[2].minus(triangleVertices[1]);
        Vector r2 = p.minus(triangleVertices[1]);
        normal = edge2.cross(r2);
        if (this.tTriangleNormal.dot(normal) < 0) {
            return null;
        }
        // third edge
        Vector edge3 = triangleVertices[0].minus(triangleVertices[2]);
        Vector r3 = p.minus(triangleVertices[2]);
        normal = edge3.cross(r3);
        if (this.tTriangleNormal.dot(normal) < 0) {
            return null;
        }

        // point intersects the triangle
        return p;
    }

    public Vector getNormalVector(Vector vec)  {
        return this.tTriangleNormal;
    }

    @Override
    public int getMaterialIndex() {
        return this.materialIndex();
    }
}
