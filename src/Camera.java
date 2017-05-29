

public class Camera {
    private Vector position;
    private Vector lap;
    private Vector uv;
    private float dist;
    private float width;

    public Camera(Vector position, Vector lap, Vector uv, float dist, float width) {
        this.position = position;
        this.lap = lap;
        this.uv = uv;
        this.dist = dist;
        this.width = width;
    }

}
