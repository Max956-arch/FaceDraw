import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class FacePanel extends JPanel {

    private ArrayList<Face> faceList;

    public FacePanel(ArrayList<Face> faceList) {
        this.faceList = faceList;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Face f : faceList) {
            f.draw(g);
        }
    }
}