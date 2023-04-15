package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel {
    private BufferedImage logo;
    private Color dark = new Color(4, 37, 78);
    private Color light = new Color(56, 135, 254); 

    public Canvas() {
        try {
            logo = ImageIO.read(new File("gui/resources/Logo.png"));
        } catch (IOException e) {
            System.err.println("Unable to load Logo image from " + "gui/resources/Logo.png : " + e.getMessage());
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(200,200);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D crayon = (Graphics2D) graphics.create();

        int width = getWidth();
        int height = getHeight();

        int widthCenter = width / 2;
        int heightCenter = height / 2;

        for (int i = 0; i < 12 ; i++)
        {
            if(i % 2 == 0) crayon.setColor(dark);
            else crayon.setColor(light);

            crayon.drawLine(widthCenter + (20 * i), heightCenter - (20 * i), widthCenter + (20 * i), heightCenter + 20 + (20 * i));
            crayon.drawLine(widthCenter + (20 * i), heightCenter + 20 + (20 * i), widthCenter - 20 - (20 * i), heightCenter + 20 + (20 * i));
            crayon.drawLine(widthCenter - 20 - (20 * i), heightCenter + 20 + (20 * i), widthCenter - 20 - (20 * i), heightCenter - 20 - (20 * i));
            crayon.drawLine(widthCenter - 20 - (20 * i), heightCenter - 20 - (20 * i), widthCenter + 20 + (20 * i), heightCenter - 20 - (20 * i));
        }
        
        crayon.drawImage(logo, (getWidth() - logo.getWidth())/2, (getHeight() - logo.getHeight())/2, this);
        crayon.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 48));
        crayon.drawString("E", getWidth()/2 - 72, getHeight());
        crayon.setColor(dark);
        crayon.drawString("L", getWidth()/2 - 36, getHeight());
        crayon.setColor(light);
        crayon.drawString("S", getWidth()/2, getHeight());
        crayon.setColor(dark);
        crayon.drawString("A", getWidth()/2 + 36, getHeight());
    }
}
