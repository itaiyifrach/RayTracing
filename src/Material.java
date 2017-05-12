

public class Material {
    Vector diff;
    Vector spec;
    Vector refl;
    float phong;
    float trans;

    public Material(Vector diff, Vector spec, Vector refl, float phong, float trans) {
        this.diff = diff;
        this.spec = spec;
        this.refl = refl;
        this.phong = phong;
        this.trans = trans;
    }
}
