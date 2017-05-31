

public class Camera {
    private Vector position;
    private Vector look;
    private Vector up;
    private Vector right;
    private float dist;
    private float width;

    public Camera(Vector position, Vector look, Vector up, float dist, float width) {
        this.position = position;
        this.look = look;
        this.up = up;
        this.dist = dist;
        this.width = width;

        Vector towards = look.minus(position);
        this.right = towards.cross(up);
    }

    public Vector getScreenCenterPoint() {
        // calculating direction (look at point - p0)
        Vector towards = look.minus(position).direction();
        // center point is (p0 + d*towards)
        Vector center = position.plus(towards.scale(dist));

        return center;
    }

    public Vector getPosition() {
        return position;
    }

    public Vector getLook() {
        return look;
    }

    public Vector getUp() {
        return up;
    }

    public Vector getRight() {
        return right;
    }

    public float getDistance() {
        return dist;
    }

    public float getWidth() {
        return width;
    }
}
