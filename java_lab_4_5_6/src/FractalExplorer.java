import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class FractalExplorer {
    private int width;
    private int height;
    public JImageDisplay display;
    private FractalGenerator fractalGenerator;
    private Rectangle2D.Double range;
    public String colorMap;


    private JComboBox<FractalGenerator> comboBox = new JComboBox<>();
    private JButton btnSave = new JButton("Save frame");
    private JButton btnReset = new JButton("Reset");

    public FractalExplorer(int width, int height) {
        this.width = width;
        this.height = height;
        range = new Rectangle2D.Double();
        fractalGenerator = new Mandelbrot();
        fractalGenerator.getInitialRange(range);
        colorMap = "rainbowAcid";
    }

    public void createAndShowGUI() {

        JFrame frame = new JFrame("Fractal Explorer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // create Label
        JLabel label = new JLabel("Fractal: ");

        // create ComboBox

        // add items (Fractals)
        comboBox.addItem(new Mandelbrot());
        comboBox.addItem(new Tricorn());
        comboBox.addItem(new BurningShip());
        comboBox.addActionListener(new EventListener());

        // create panel for Label and ComboBox
        JPanel panel = new JPanel();
        panel.add(comboBox);
        panel.add(label);

        frame.add(panel, BorderLayout.NORTH);

        display = new JImageDisplay(width, height);
        display.addMouseListener(new MouseButtonClicked());
        frame.add(display, BorderLayout.CENTER);


        btnSave.addActionListener(new EventListener());


        btnReset.addActionListener(new EventListener());


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btnSave);
        buttonsPanel.add(btnReset);

        frame.add(buttonsPanel, BorderLayout.SOUTH);


        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);


    }

    class EventListener implements ActionListener {
        /* Reset range ans redraw */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnReset) {
                fractalGenerator.getInitialRange(range);
                drawFractal();
            } else if (e.getSource() == comboBox) {
                fractalGenerator = (FractalGenerator) comboBox.getSelectedItem();
                fractalGenerator.getInitialRange(range);
                drawFractal();
            } else if (e.getSource() == btnSave) {
                JFileChooser fdialog = new JFileChooser();

                FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                fdialog.setFileFilter(filter);
                fdialog.setAcceptAllFileFilterUsed(false);


                if (fdialog.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        ImageIO.write(display.bufferedImage, "png", fdialog.getSelectedFile());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                        JOptionPane.showMessageDialog(fdialog, ioException.getMessage(), "Can't save file ;(", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    private void drawFractal() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                /* Translate screenX to xCoord from fractal space */
                double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, width, x);
                double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, height, y);

                /* Calculate number of iterations */
                int numIters = fractalGenerator.numIterations(xCoord, yCoord);

                /* Coloring image */

                switch (colorMap) {
                    case "B&W": // Black set on white plane
                        if (numIters == -1)
                            display.drawPixel(x, y, Color.BLACK.getRGB());
                        else
                            display.drawPixel(x, y, Color.WHITE.getRGB());
                        break;
                    case "W&B": // B&W inverted
                        if (numIters == -1)
                            display.drawPixel(x, y, Color.WHITE.getRGB());
                        else
                            display.drawPixel(x, y, Color.BLACK.getRGB());
                        break;
                    case "rainbowAcid": // Original Lab Color
                        if (numIters == -1)
                            display.drawPixel(x, y, Color.BLACK.getRGB());
                        else {
                            float hue = 0.7f + (float) numIters / 360f;
                            int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                            display.drawPixel(x, y, rgbColor);
                        }

                }


                // { // Original Lab Color
//                    float hue = 0.7f + (float) numIters / 200f;
//                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
//                    display.drawPixel(x, y, rgbColor);
//                }
//                else { // Black and white, only set
//                    display.drawPixel(x, y, Color.WHITE.getRGB());
//                }

            }
        }
        display.repaint();
    }


//    class SaveButton implements ActionListener {
//        public void actionPerformed(ActionEvent e){
//            JFileChooser fdialog = new JFileChooser();
//            if (fdialog.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
//                FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
//                fdialog.setFileFilter(filter);
//                fdialog.setAcceptAllFileFilterUsed(false);
//                try {
//                    ImageIO.write(display.bufferedImage, "png", fdialog.getSelectedFile());
//                } catch (IOException ioException) {
//                    //ioException.printStackTrace();
//                    JOptionPane.showMessageDialog(fdialog, "Something went wrong", "Can't save file ;(", JOptionPane.ERROR_MESSAGE);
//                }
//                catch(IllegalArgumentException argumentException){
//                    JOptionPane.showMessageDialog(fdialog, "Please save as .png file", "Extension error", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        }
//    }

    class MouseButtonClicked implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            /* Translate screen coordinates */
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, width, e.getX());
            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, height, e.getY());
            /* Move and scale fractal */
            fractalGenerator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            /* Redraw */
            drawFractal();
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }

    public static void main(String[] args) {
        /* Initialize FractalExplorer with window size */
        FractalExplorer fractalExplorer = new FractalExplorer(800, 800);
        fractalExplorer.createAndShowGUI();
        fractalExplorer.drawFractal();
    }

}
