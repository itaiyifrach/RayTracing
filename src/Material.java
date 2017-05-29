

public class Material {
    private Vector diff;
    private Vector spec;
    private Vector refl;
    private float phong;
    private float trans;

    public Material(Vector diff, Vector spec, Vector refl, float phong, float trans) {
        this.diff = diff;
        this.spec = spec;
        this.refl = refl;
        this.phong = phong;
        this.trans = trans;
    }
}
