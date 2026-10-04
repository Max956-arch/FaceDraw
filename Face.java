import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

// Represents a face with a mouth and eyes, including its position, size, and appearance
public class Face {
    private int x;
    private int y;
    private int width;
    private int height;
    private String mouthType;
    private String eyeColor;

    // Draws in the face on the given Graphics object, including the head, eyes, and mouth
    public void draw(Graphics g) {

        // Draws the head of the face and sets the color to black
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);

        // Calculates the size and position of the eyes
        int eyeWidth = width / 6;
        int eyeHeight = height / 6;
        int leftEyeX = x + width / 4;
        int rightEyeX = x + (width * 2 / 3) - eyeWidth;
        int eyeY = y + height / 3;

        // Determines the color of the eyes based on the eyeColor field
        Color fillcolor = switch (eyeColor) {
            case "green" -> Color.GREEN;
            case "blue" -> Color.BLUE;
            case "yellow" -> Color.YELLOW;
            case "red" -> Color.RED;
            default -> Color.BLACK;
        };

        // Fills the eyes with the determined color
        g.setColor(fillcolor);
        g.fillOval(leftEyeX, eyeY, eyeWidth, eyeHeight);
        g.fillOval(rightEyeX, eyeY, eyeWidth, eyeHeight);

        // Draws the outlines of the eyes in black
        g.setColor(Color.BLACK);
        g.drawOval(leftEyeX, eyeY, eyeWidth, eyeHeight);
        g.drawOval(rightEyeX, eyeY, eyeWidth, eyeHeight);

        // Calculates the size and position of the mouth
        int mouthX = x + width / 4;
        int mouthY = y + (height * 2 / 3);
        int mouthWidth = width / 2;
        int mouthHeight = height / 6;
        
        // Draws the mouth based on the mouthType field
            switch (mouthType) {
            case "smile":
                g.drawArc(mouthX, mouthY, mouthWidth, mouthHeight, 0, 180);
                break;
            case "frown":
                g.drawArc(mouthX, mouthY, mouthWidth, mouthHeight, 180, 180);
                break;
            default:
                g.drawLine(mouthX, mouthY + mouthHeight / 2, mouthX + mouthWidth, mouthY + mouthHeight / 2);
        }

        System.out.println(this.toString());
    }

    // Constructors for the Face class
    // Creates a Face object with random width, height, position, mouth, and eye color
    public Face() {
        Random rand = new Random();
        this.width = rand.nextInt(80) + 60;
        this.height = rand.nextInt(80) + 60;
        this.x = rand.nextInt(400);
        this.y = rand.nextInt(300);
        setRandomMouth();
        setEyeColorBasedOnMouth();
    }

    // Creates a Face object with specified width and height, random position, mouth, and eye color
    public Face(int width, int height) {
        Random rand = new Random();
        this.width = width;
        this.height = height;
        this.x = rand.nextInt(400);
        this.y = rand.nextInt(300);
        setRandomMouth();
        setEyeColorBasedOnMouth();
    }

    // Creates a Face object with specified position, width, height, and mouth type, and random eye color
    public Face(int x, int y, int width, int height, String mouthType) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.mouthType = mouthType;
        setEyeColorBasedOnMouth();
    }

    // This sets the mouth type randomly among "smile", "frown", and "neutral"
    private void setRandomMouth() {
        Random rand = new Random();
        int m = rand.nextInt(3);
        if (m == 0) mouthType = "smile";
        else if (m == 1) mouthType = "frown";
        else mouthType = "neutral";
    }

    // Sets the eye color based on the mouth type, with "smile" having green or blue eyes, "neutral" having yellow eyes, and "frown" having red eyes
    private void setEyeColorBasedOnMouth() {
        Random rand = new Random();
        switch (mouthType) {
            case "smile":
                eyeColor = rand.nextBoolean() ? "green" : "blue";
                break;
            case "neutral":
                eyeColor = "yellow";
                break;
            case "frown":
                eyeColor = "red";
                break;
        }
    }

    
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public String getMouthType() { return mouthType; }
    public String getEyeColor() { return eyeColor; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public void setMouthType(String mouthType) { this.mouthType = mouthType; }

    // Returns a string representation of the Face object, including its position, size, mouth type, and eye color
    @Override
    public String toString() {
        return "Face[x=" + x + ", y=" + y + ", width=" + width +
               ", height=" + height + ", mouth=" + mouthType +
               ", eyeColor=" + eyeColor + "]";
    }
}