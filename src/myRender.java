import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by oshriamir on 5/31/17.
 */
public class myRender {

    /*
    private Camera mCamera;
    private Scene mScene;
    private int imageWidth;
    private int imageHeight;
    private int screenWidth;


    public myRender(int _imageWidth, int _imageHeight) {
        this.imageWidth = _imageWidth;
        this.imageHeight = _imageHeight;
    }

    public Camera getmCamera() {
        return mCamera;
    }
    public void setmCamera(Camera mCamera) {
        this.mCamera = mCamera;
    }

    public Scene getmScene() {
        return mScene;
    }
    public void setmScene(Scene mScene) {
        this.mScene = mScene;
    }

    public int getScreenWidth() {
        return screenWidth;
    }
    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }



    private void defineAllSizes(){

        double imageRatio = imageHeight / imageWidth;
        double pixelWidth = getmCamera().getWidth() / imageWidth;
        double pixelHeight = imageRatio * pixelWidth;
    }

    public void parseScene(String sceneFileName) throws IOException, RayTracer.RayTracerException {

        FileReader fr = new FileReader(sceneFileName);
        BufferedReader r = new BufferedReader(fr);
        String line = null;
        int lineNum = 0;
        System.out.println("Started parsing scene file " + sceneFileName);




        while ((line = r.readLine()) != null)
        {
            line = line.trim();
            ++lineNum;

            if (line.isEmpty() || (line.charAt(0) == '#'))
            {  // This line in the scene file is a comment
                continue;
            }
            else
            {
                String code = line.substring(0, 3).toLowerCase();
                // Split according to white space characters:
                String[] params = line.substring(3).trim().toLowerCase().split("\\s+");

                if (code.equals("cam"))
                {
                    this.mCamera = new Camera(new Vector(Double.parseDouble(params[0]), Double.parseDouble(params[1]), Double.parseDouble(params[2])),
                            new Vector(Double.parseDouble(params[3]), Double.parseDouble(params[4]), Double.parseDouble(params[5])),
                            new Vector(Double.parseDouble(params[6]), Double.parseDouble(params[7]), Double.parseDouble(params[8])),
                            Float.parseFloat(params[9]), Float.parseFloat(params[10]));

                    System.out.println(String.format("Parsed camera parameters (line %d)", lineNum));
                }
                else if (code.equals("set"))
                {

                    Vector bgColor = new Vector(Double.parseDouble(params[0]), Double.parseDouble(params[1]), Double.parseDouble(params[2]));
                    int shadowRaysNumber = Integer.parseInt(params[3]);
                    int maxRecursionLevel = Integer.parseInt(params[4]);

                    int superSamplingLevel;
                    if (params.length >= 6) {
                        superSamplingLevel = Integer.parseInt(params[5]);
                    }else{
                        superSamplingLevel = 2;
                    }

                    this.mScene = new Scene(bgColor, shadowRaysNumber, maxRecursionLevel, superSamplingLevel);

                    System.out.println(String.format("Parsed general settings (line %d)", lineNum));
                }
                else if (code.equals("mtl"))
                {
                    Material mtr = new Material(new Vector(Double.parseDouble(params[0]), Double.parseDouble(params[1]), Double.parseDouble(params[2])),
                            new Vector(Double.parseDouble(params[3]), Double.parseDouble(params[4]), Double.parseDouble(params[5])),
                            new Vector(Double.parseDouble(params[6]), Double.parseDouble(params[7]), Double.parseDouble(params[8])),
                            Float.parseFloat(params[9]), Float.parseFloat(params[10]));
                    this.mScene.getMaterials().add(mtr);

                    System.out.println(String.format("Parsed material (line %d)", lineNum));
                }
                else if (code.equals("sph"))
                {
                    Sphere sph = new Sphere(new Vector(Double.parseDouble(params[0]), Double.parseDouble(params[1]), Double.parseDouble(params[2])),
                            Float.parseFloat(params[3]), Integer.parseInt(params[4]));
                    this.mScene.getSurfaces().add(sph);

                    System.out.println(String.format("Parsed sphere (line %d)", lineNum));
                }
                else if (code.equals("pln"))
                {
                    Plane pln = new Plane(new Vector(Double.parseDouble(params[0]), Double.parseDouble(params[1]), Double.parseDouble(params[2])),
                            Integer.parseInt(params[3]), Integer.parseInt(params[4]));
                    this.mScene.getSurfaces().add(pln);

                    System.out.println(String.format("Parsed plane (line %d)", lineNum));
                }
                else if (code.equals("trg"))
                {
                    Triangle trg = new Triangle(new Vector(Double.parseDouble(params[0]), Double.parseDouble(params[1]), Double.parseDouble(params[2])),
                            new Vector(Double.parseDouble(params[3]), Double.parseDouble(params[4]), Double.parseDouble(params[5])),
                            new Vector(Double.parseDouble(params[6]), Double.parseDouble(params[7]), Double.parseDouble(params[8])),
                            Integer.parseInt(params[9]));
                    this.mScene.getSurfaces().add(trg);

                    System.out.println(String.format("Parsed cylinder (line %d)", lineNum));
                }
                else if (code.equals("lgt"))
                {
                    Light lgt = new Light(new Vector(Double.parseDouble(params[0]), Double.parseDouble(params[1]), Double.parseDouble(params[2])),
                            new Vector(Double.parseDouble(params[3]), Double.parseDouble(params[4]), Double.parseDouble(params[5])),
                            Float.parseFloat(params[6]), Float.parseFloat(params[7]), Float.parseFloat(params[8]));
                    this.mScene.getLights().add(lgt);

                    System.out.println(String.format("Parsed light (line %d)", lineNum));
                }
                else
                {
                    System.out.println(String.format("ERROR: Did not recognize object: %s (line %d)", code, lineNum));
                }
            }
        }

        // It is recommended that you check here that the scene is valid,
        // for example camera settings and all necessary materials were defined.

        // TODO: what should we check here??
        boolean isValid = true;
        //checking if #materials == #surfaces
//        if (this.materials.size() != this.surfaces.size()) {
//            isValid = false;
//        }

        if (isValid) {
            System.out.println("Finished parsing scene file " + sceneFileName);
        }
        else {
            System.out.println("Error in parsing scene file " + sceneFileName);
        }

    }

    public void doRayTracing(String outputFileName){

        //initialize RayTracer instance...
        RayTracer mRayTracer = new RayTracer(screenWidth, imageWidth,imageHeight);
        // Render scene:
        mRayTracer.renderScene(outputFileName);

    }
    */


}
