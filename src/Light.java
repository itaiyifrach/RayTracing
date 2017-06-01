

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

