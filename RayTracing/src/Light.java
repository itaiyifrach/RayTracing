

public class Light {

    private Vector position;
    private Vector color;
    private float spec;
    private float shadow;
    private float radius;

    public Light(Vector position, Vector color, float spec, float shadow, float radius) {
        this.position = position;
        this.color = color;
        this.spec = spec;
        this.shadow = shadow;
        this.radius = radius;
    }
}

