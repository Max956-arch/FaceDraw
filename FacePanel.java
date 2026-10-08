import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class FacePanel extends JPanel {

    // This panel holds a list of Face objects and draws them using the paintComponent method
    private ArrayList<Face> faceList;

    public FacePanel(ArrayList<Face> faceListIn) {
        this.faceList = faceListIn;
    }

    // Override the paintComponent method to draw all faces in the faceList
    // Face f loops through each face in the faceList and calls its draw method

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Face f : faceList) {
            f.draw(g);
        }
    }
}