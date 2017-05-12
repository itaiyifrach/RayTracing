

public class Light {
    Vector position;
    Vector color;
    float spec;
    float shadow;
    float radius;

    public Light(Vector position, Vector color, float spec, float shadow, float radius) {
        this.position = position;
        this.color = color;
        this.spec = spec;
        this.shadow = shadow;
        this.radius = radius;
    }
}

