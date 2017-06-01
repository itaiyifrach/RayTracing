/**
 * Created by oshriamir on 5/31/17.
 */
public class Client {

    public static void main(String[] args) {

        int imageWidth;
        int imageHeight;
        try {

            if (args.length < 2)
                throw new RayTracer.RayTracerException("Not enough arguments provided. Please specify an input scene file and an output image file for rendering.");

            String sceneFileName = args[0];
            String outputFileName = args[1];

            if (args.length > 3) {
                imageWidth = Integer.parseInt(args[2]);
                imageHeight = Integer.parseInt(args[3]);
            }else{
                // Default values:
                imageWidth = 500;
                imageHeight = 500;
            }

            //initialize myRender instance...
            myRender mRender = new myRender(imageWidth,imageHeight);
            // Parse scene file:
            mRender.parseScene(sceneFileName);

            //initialize RayTracer instance...

            // Render scene:
            mRender.doRayTracing(outputFileName);

//		} catch (IOException e) {
//			System.out.println(e.getMessage());
        } catch (RayTracer.RayTracerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
