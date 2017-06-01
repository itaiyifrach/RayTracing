

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

        Vector vec1 = VectorArithmetic.minus(triangleVertices[1], triangleVertices[0]);
        Vector vec2 = VectorArithmetic.minus(triangleVertices[2], triangleVertices[0]);

        this.tTriangleNormal = VectorArithmetic.Normalize(VectorArithmetic.cross(vec1,vec2));
    }

    public Vector findIntersection(Ray ray) {
        // calculating the triangle plane


        double offset =  VectorArithmetic.dot(triangleVertices[0], this.tTriangleNormal);
        Plane trgPlane = new Plane(this.tTriangleNormal, offset, mat_idx);

        // finding intersection point with triangle plane
        Vector P = trgPlane.findIntersection(ray);
        if (P == null) {
            return null;
        }

        // checking intersection point with triangle
        // first edge
        Vector edgePoint_1 = VectorArithmetic.minus(triangleVertices[1], triangleVertices[0]);
        Vector r_1 = VectorArithmetic.minus(P, triangleVertices[0]);
        Vector normalVector = VectorArithmetic.cross(edgePoint_1,r_1);
        if(VectorArithmetic.dot(this.tTriangleNormal, normalVector) < 0){
            return null;
        }


        // second edge
        Vector edgePoint_2 = VectorArithmetic.minus(triangleVertices[2], triangleVertices[1]);
        Vector r_2 = VectorArithmetic.minus(P, triangleVertices[1]);
        normalVector = VectorArithmetic.cross(edgePoint_2,r_2);
        if(VectorArithmetic.dot(this.tTriangleNormal, normalVector) < 0){
            return null;
        }

        // third edge
        Vector edgePoint_3 = VectorArithmetic.minus(triangleVertices[0], triangleVertices[2]);
        Vector r_3 = VectorArithmetic.minus(P, triangleVertices[2]);
        normalVector = VectorArithmetic.cross(edgePoint_3,r_3);
        if(VectorArithmetic.dot(this.tTriangleNormal, normalVector) < 0){
            return null;
        }

        // point intersects the triangle
        return P;
    }

    public Vector getNormalVector(Vector vec)  {
        return this.tTriangleNormal;
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
