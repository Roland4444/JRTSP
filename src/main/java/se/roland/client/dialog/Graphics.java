package se.roland.client.dialog;

import ch.roland.ModuleGUI;
import se.roland.client.abstractions.Draw;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.Math.*;

public class Graphics extends ModuleGUI {
    public JPanel GraphPanel;
    public se.roland.client.abstractions.Draw Draw;
    public Graphics(){
        frame = new JFrame("GraFZ");
        GraphPanel =  new JPanel();

        Draw =  new Draw(GraphPanel) {
            int counter = 1;
            @Override
            public void DrawIt() {
                if (counter == 200)
                    counter = 1;
                    byte[] toByteArray;
                    try {
                    ///    BufferedImage imgResult = ImageIO.read(new File(counter+".jpg"));
                        java.awt.Graphics g = Panel.getGraphics();
                        BufferedImage bi = createImageFromBytes(new byte[1], (Graphics2D) g);//createIMG((Graphics2D) g, counter);
                        g.drawImage(bi, 1, 1, Panel.getWidth() - 1, Panel.getHeight() - 1, 0, 0, bi.getWidth(), bi.getHeight(), null);
                   ////     g.drawRect(0, 0, Panel.getWidth() - 1, Panel.getHeight() - 1);

                    } catch (Exception e) {
                }
                    counter++;
            }

            };


        };

    public byte[] random() throws IOException {
        return Files.readAllBytes(new File("k.rgb").toPath());

    }

    private BufferedImage createImageFromBytes(byte[] Arr,Graphics2D g) throws IOException {
        BufferedImage image = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
        g = image.createGraphics();  // not sure on this line, but this seems more right
        g.setColor(Color.RED);
       // g.fillOval(shift*4, 0, 100, 100); // give the whole image a white background

        for (int i=0; i<254; i++){
            Color Color = new Color(80, 50, 130, 100);
            g.setColor(Color);
     //       g.fillRect((int) ((int) (640* sin(i+shift))*cos(shift)), (int) (480* cos(i)), (int) (2+shift* tan(i)*sin(i)), (int) (2*i* sin(shift)));
        }
        return image;
    };

    public BufferedImage createIMG(Graphics2D g, int shift){
        BufferedImage image = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
        g = image.createGraphics();  // not sure on this line, but this seems more right
        g.setColor(Color.RED);
        g.fillOval(shift*4, 0, 100, 100); // give the whole image a white background

        for (int i=0; i<254; i++){
            Color Color = new Color(80, 50, 130, 100);
            g.setColor(Color);
            g.fillRect((int) ((int) (640* sin(i+shift))*cos(shift)), (int) (480* cos(i)), (int) (2+shift* tan(i)*sin(i)), (int) (2*i* sin(shift)));
        }

        //g.fillRect(300, 200, 100, 100);
        return image;

    }

    @Override
    public void preperaGUI() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        frame.setSize(640, 480);
        frame.add(GraphPanel);
        frame.setVisible(true);
        Draw.start();
    }

    @Override
    public void initListeners() {

    }

    @Override
    public void initActions() {

    }
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        Graphics graphics =  new Graphics();
        graphics.preperaGUI();
    }



}
