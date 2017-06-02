/**
 * Created by oshriamir on 5/31/17.
 */
/**
public class RayManufaturing {


    public static Ray constructRayThroughPixel(Camera camera, int i, int j, int imageWidth, int imageHeight, double pixelWidth, double pixelHeight) {
        Vector P = camera.getScreenCenterPoint();
        double moveX = (imageWidth / 2 - i) * pixelWidth;
        double moveY = (imageHeight / 2 - j) * pixelHeight;

        Vector vecX = camera.getRight().direction();
        vecX = vecX.scale(moveX);

        Vector vecY = camera.getUp().direction();
        vecY = vecY.scale(moveY);

        /////
        // calculating P new position from the center
        P = P.plus(vecX).plus(vecY);
        // calculating direction vector (P - p0)
        Vector p0 = camera.getPosition();
        Vector V = (P.minus(p0)).direction();
        return new Ray(p0, V);
        /////
    }

}
*/
