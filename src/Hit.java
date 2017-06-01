/**
 * Created by oshriamir on 5/31/17.
 */
public class Hit {
    /*
    private Vector hitPoint;
    private Surface geometryShape;
    private int materialIndex;
    private I_J_Pairs pixelRepresentation;

    public Hit(Vector hitPoint, Surface geometryShape, int materialIndex, I_J_Pairs pixelRepresentation) {
        this.hitPoint = hitPoint;
        this.geometryShape = geometryShape;
        this.materialIndex = materialIndex;
        this.pixelRepresentation = pixelRepresentation;
    }

    public Hit(Vector hitPoint, int materialIndex) {
        this.hitPoint = hitPoint;
        this.geometryShape = geometryShape;
        this.materialIndex = materialIndex;
        this.pixelRepresentation = pixelRepresentation;
    }

    protected static Hit findInterSections(Ray ray, Scene scene){

        Vector p0 = new Vector(ray.getStartPoint());
        Vector hitPoint = null;
        int mat_idx = -1;
        Hit hit;

        double tempDist, minDist = Double.POSITIVE_INFINITY;

        // searching for minimum intersection point, and saving the surface material index
        for (Surface surface : scene.getSurfaces()) {
            hitPoint = surface.findIntersection(ray);
            if (hitPoint != null) {
                tempDist = hitPoint.distanceTo(p0);
                if (tempDist < minDist || mat_idx == -1) {
                    minDist = tempDist;
                    mat_idx = surface.getMaterialIndex();
                }
            }
        }
        return( (hitPoint == null) ? null : new Hit(hitPoint, mat_idx) );       // TODO: use new Hit(hitPoint,Geometry shape who hit it! ,mat_idx) OR remove this constructor from Hit class if no needed.


    }
    private class I_J_Pairs{
        int I_index;
        int J_index;

        public I_J_Pairs(int i, int j){
            this.I_index = i;
            this.J_index = j;
        }
    }
    */

}
