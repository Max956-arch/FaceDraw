import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

public class FaceDraw {

    //Creates a JFrame that is titled "FaceDraw" and sets its size and close operation
    public static void main(String[] args) {
        JFrame frame = new JFrame("FaceDraw");
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Creates a list of random faces to be displayed in the panel
        Random rand = new Random();
        int numFaces = rand.nextInt(8) + 3;

        // Creates an ArrayList to hold the list of faces
        ArrayList<Face> faceList = new ArrayList<>();
        for (int i = 0; i < numFaces; i++) {
            faceList.add(new Face());
        }

        // Creates a FacePanel to display the list of faces
        FacePanel facePanel = new FacePanel(faceList);
        frame.add(facePanel);

        // Adds the FacePanel to the JFrame and makes the frame visible
        frame.setVisible(true);
    }
}
