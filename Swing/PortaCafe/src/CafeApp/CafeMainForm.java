package CafeApp;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class CafeMainForm extends JFrame {

    private int mouseX, mouseY;
    private JPanel panel1;
    private JLabel welcomeLabel;
    private JPanel panel2;
    private JPanel panel3;


    public CafeMainForm(){
        setSize(1280, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout();
        setContentPane(panel1);
        setBackgroundImage();
        mouseDragging();

    }
    private void setLayout(){
        GridBagConstraints gbc = new GridBagConstraints();
        panel2.setSize(300,300);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel1.add(welcomeLabel, gbc);
        gbc.gridy = 1;
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel1, BorderLayout.CENTER);
        getContentPane().add(panel2, BorderLayout.WEST);
    }
    private void setBackgroundImage(){
        panel2.setOpaque(false);
        panel2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    Image backgroundImage = ImageIO.read(new File("Imgs/kafes.png"));
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error loading image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
    }
    private void mouseDragging(){

        panel1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getXOnScreen() - getLocation().x;
                mouseY = e.getYOnScreen() - getLocation().y;
            }
        });
        panel1.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen() - mouseX;
                int y = e.getYOnScreen() - mouseY;
                setLocation(x, y);
            }
        });
    }
}
