

public class Material {
    private Vector diffuseRGBValue;
    private Vector specularRGBValue;
    private Vector reflectionRGBValue;
    private float phongValue;
    private float transparencyValue;

    public Material(Vector diff, Vector spec, Vector refl, float phong, float trans) {
        this.diffuseRGBValue = diff;
        this.specularRGBValue = spec;
        this.reflectionRGBValue = refl;
        this.phongValue = phong;
        this.transparencyValue = trans;
    }

    public Vector getDiff() {
        return this.diffuseRGBValue;
    }

    public Vector getSpec() {
        return this.specularRGBValue;
    }

    public Vector getRefl() {
        return this.reflectionRGBValue;
    }

    public float getPhong() {
        return this.phongValue;
    }

    public float getTrans() {
        return this.transparencyValue;
    }
}
