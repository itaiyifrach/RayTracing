import java.util.ArrayList;

public class Light {
    private Vector lightPositionPoint;
    private Vector lightColorValue;
    private float lightSpecularValue;
    private float lightShadowValue;
    private float lightRadiusValue;


    public Light(Vector position, Vector color, float spec, float shadow, float radius) {
        this.lightPositionPoint = position;
        this.lightColorValue = color;
        this.lightSpecularValue = spec;
        this.lightShadowValue = shadow;
        this.lightRadiusValue = radius;
    }

    public Light[] getAreaLight(Vector hitPoint, int sh_rays) {
        // get direction of light (the Normal of the area grid)
        Vector N = (hitPoint.minus(lightPositionPoint)).direction();
        // get the offset on the Plane
        double offset = lightPositionPoint.dot(N);
        // constructing the plane
        Plane lightPlane = new Plane(this.lightPositionPoint, offset, -1);


        // TODO: compute the light grid
        Vector rightDirection = (lightPlane.getPointOnPlane().minus(lightPositionPoint)).direction();
        Vector upDirection = rightDirection.cross(N);

        Light lights[] = new Light[sh_rays*sh_rays];
        double lightWidth = lightRadiusValue / sh_rays;
        double lightHeight = lightWidth;

        int count=0;
        double moveRight, moveUp;
        Vector vecX, vecY, pos;
        //build point lights
        for (int i = 0; i < lightRadiusValue; i++) {
            for (int j = 0; j < lightRadiusValue; j++) {
                moveRight = (lightRadiusValue / 2 - i) * lightWidth;
                moveUp = (lightRadiusValue / 2 - j) * lightHeight;
                vecX = rightDirection.scale(moveRight);
                vecY = upDirection.scale(moveUp);

                // TODO: random position
                pos = lightPositionPoint.plus(vecX).plus(vecY);

                lights[count] = new Light(pos, lightColorValue, lightSpecularValue, lightShadowValue, lightRadiusValue);
                count++;
            }
        }

        return lights;
    }

    public double computeSoftShadow(Light[] lights, Intersection hit, RayTracer scene) {
        double count = 0;

        for (Light light: lights) {
            Ray lightRay = new Ray(light.lightPositionPoint, (hit.getHitPoint().minus(light.getLightPositionPoint()).direction()));  // the ray from light to hit point
            count += getShadowHit(lightRay, hit.getHitPoint(), scene);
        }
        return (count / lights.length);
    }

    private double getShadowHit(Ray ray, Vector hitPoint, RayTracer scene) {
        Vector tempHit;
        Vector p0 = ray.getStartPoint();
        double tempDist, tempTransValue;
        int mat_idx;
        ArrayList<Double> hitTranspValues = new ArrayList<>();

        // distance to checked surface
        double maxDist = hitPoint.distanceTo(p0);

        // searching if there is an intersection before checked surface. is so, then add it to the Surfaces List
        for (Surface surface : scene.getSurfaces()) {
            tempHit = surface.findIntersection(ray);
            if (tempHit != null) {
                tempDist = tempHit.distanceTo(p0);
                if (tempDist < maxDist) {               // if there is hit before the checked surface
                    mat_idx = surface.getMaterialIndex();
                    Material hitMat = scene.getMaterials().get(mat_idx - 1);
                    tempTransValue = hitMat.getTrans();
                    if (tempTransValue == 0) {       // if any of the surfaces isn't transparent, then exit
                        return (1 - this.lightShadowValue);
                    } else {                              // the surface is transparent
                        hitTranspValues.add(tempTransValue);
                    }
                }
            }
        }
        // if no surfaces found, then it is direct hit from the light
        if (hitTranspValues.size() == 0) {
            return 1;
        }
        // otherwise, mult all transparency values
        else {
            double mults = 0;
            for (Double transValue : hitTranspValues) {
                if (mults == 0) {
                    mults = transValue;
                } else {
                    mults *= transValue;
                }
            }
            double sum = mults + (1 - this.lightShadowValue);
            // the sum might be greater than 1. in that case, we return 1
            return Math.min(sum, 1);
        }
    }

    public Vector getLightPositionPoint() {
        return lightPositionPoint;
    }

    public Vector getLightColorValue() {
        return lightColorValue;
    }

    public float getLightSpecularValue() {
        return lightSpecularValue;
    }

    public float getLightShadowValue() {
        return lightShadowValue;
    }

    public float getLightRadiusValue() {
        return lightRadiusValue;
    }


}

