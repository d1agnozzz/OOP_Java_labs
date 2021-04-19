import java.awt.*;
import java.awt.image.BufferedImage;


class JImageDisplay extends javax.swing.JComponent {
    private BufferedImage bufferedImage;
    public JImageDisplay(int width, int height){
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        super.setPreferredSize(new java.awt.Dimension(width, height));
    }

    /* Output image to screen */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
    }



    /* Clear image (set all pixels black) */
    public void clearImage(){
        for (int x = 0; x <  bufferedImage.getWidth(); x++){
            for (int y = 0; y < bufferedImage.getHeight(); y++){
                bufferedImage.setRGB(x, y, Color.BLACK.getRGB());
            }
        }
    }

    /* Change certain pixel to a certain color */
    public void drawPixel(int x, int y, int rgbColor){
        bufferedImage.setRGB(x, y, rgbColor);
    }
}