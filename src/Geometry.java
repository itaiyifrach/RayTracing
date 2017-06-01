

public abstract class Geometry {
    private Material material;
    private int materialIndex;

    public Geometry(Material material) {
        this.material = material;
    }
    public Geometry(int _materialIndex) {
        this.materialIndex = _materialIndex;
    }
    public Geometry(){}

    public Material getMaterial() {
        return material;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }

    public int materialIndex() {
        return materialIndex;
    }
    public void setMaterialIndex(int materialIndex) {
        this.materialIndex = materialIndex;
    }
}
