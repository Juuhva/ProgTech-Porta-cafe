package CafeApp;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class CafeWelcomeForm extends JFrame {
    private JPanel panel1, panel2;
    private JLabel titleLabel;
    private JButton enterButton;
    private int mouseX, mouseY;


    public CafeWelcomeForm() {
        setSize(600, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setBackgroundImage();
        setButtonStyle();
        setPanelOrder();
        setLayout();
        formOpener();
        mouseDragging();
        setContentPane(panel1);
        setVisible(true);
    }

    private void formOpener(){
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CafeMainForm().setVisible(true);
                dispose();
            }
        });
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
    private void setBackgroundImage(){
        panel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    Image backgroundImage = ImageIO.read(new File("Imgs/kafe.png"));
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error loading image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
    }
    private void setLayout(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 50, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel1.add(titleLabel, gbc);
        gbc.gridy = 1;
        panel1.add(enterButton, gbc);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel1, BorderLayout.CENTER);
        getContentPane().add(panel2, BorderLayout.SOUTH);
    }
    private void setPanelOrder(){
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel1.setLayout(new GridBagLayout());
        panel1.setComponentZOrder(enterButton, 0);
        panel1.setComponentZOrder(titleLabel, 1);
    }
    private void setButtonStyle(){
        Font font = enterButton.getFont();
        enterButton.setUI(new BasicButtonUI());
        enterButton.setBackground(Color.WHITE);
        enterButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        enterButton.setFocusPainted(false);
        enterButton.setContentAreaFilled(false);
        enterButton.setFont(font.deriveFont(font.BOLD,24));
    }

}

