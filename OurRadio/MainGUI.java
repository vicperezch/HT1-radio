/**
 * @author Nils Muralles & Víctor Pérez
 * @version 1.0.0
 * @since 12/01/24
 * Clase que implementa la GUI del programa
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI {

    private static JFrame myFrame;
    private int frameWidth;
    private int frameHeight;
    private JPanel pnlMain;
    private JButton btnPower;
    private JPanel pnlBody;
    private JPanel pnlHeader;
    private JButton btnNextStation;
    private JButton btnAmFm;
    private JButton btn6;
    private JButton btn5;
    private JButton btn4;
    private JButton btn3;
    private JButton btn2;
    private JButton btn1;
    private JButton btn11;
    private JButton btn10;
    private JButton btn9;
    private JButton btn8;
    private JButton btn7;
    private JLabel lblStation;
    private JButton btn12;
    private Timer timer;
    Radio radio = new Radio();

    /**
     * Constructor de MainGUI
     */
    public MainGUI() {
        frameWidth = 900;
        frameHeight = 500;
        myFrame = new JFrame("Radio");
        myFrame.setTitle("Radio");
        myFrame.setContentPane(pnlMain);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setSize(frameWidth, frameHeight);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        myFrame.setLocationRelativeTo(null);
        myFrame.setResizable(false);
        myFrame.setVisible(true);

        btnPower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!radio.isOn()) {
                    btnPower.setIcon(btnPower.getSelectedIcon());
                    lblStation.setText(Double.toString(530.0));
                } else {
                    btnPower.setIcon(btnPower.getDisabledIcon());
                    lblStation.setText("");
                }

                radio.switchOnOff();
            }
        });
        btnAmFm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radio.isOn()) {
                    if (radio.isAM()) {
                        btnAmFm.setIcon(btnAmFm.getSelectedIcon());
                        radio.setCurrentStation(87.9);
                        lblStation.setText(Double.toString(radio.getCurrentStation()));

                    } else {
                        btnAmFm.setIcon(btnAmFm.getDisabledIcon());
                        radio.setCurrentStation(530.0);
                        lblStation.setText(Double.toString(radio.getCurrentStation()));
                    }

                    radio.switchAMFM();
                }
            }
        });
        btnNextStation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radio.isOn()) {
                    lblStation.setText(String.format("%.1f", radio.nextStation()));
                }
            }
        });

        btn1.addMouseListener(new Listener());
        btn2.addMouseListener(new Listener());
        btn3.addMouseListener(new Listener());
        btn4.addMouseListener(new Listener());
        btn5.addMouseListener(new Listener());
        btn6.addMouseListener(new Listener());
        btn7.addMouseListener(new Listener());
        btn8.addMouseListener(new Listener());
        btn9.addMouseListener(new Listener());
        btn10.addMouseListener(new Listener());
        btn11.addMouseListener(new Listener());
        btn12.addMouseListener(new Listener());
    }

    /**
     * Clase que se encarga de los eventos al presionar un botón numerado
     */
    private class Listener extends MouseAdapter {

        // Crea un timer para guardar la estación al mantener presionado un botón
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);

            if (radio.isOn()) {
                timer = new Timer(2000, event -> {
                    radio.saveData(Integer.parseInt(((JButton) e.getSource()).getText()), radio.getCurrentStation());
                    JOptionPane.showMessageDialog(myFrame, "Se ha guardado la estación");
                });

                timer.setRepeats(false);
                timer.start();
            }
        }

        // Para el timer si se deja de presionar el botón
        @Override
        public void mouseReleased(MouseEvent e) {

            if (radio.isOn()) {
                timer.stop();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            if (radio.isOn()) {
                if (radio.selectStation(Integer.parseInt(((JButton) e.getSource()).getText())) != 0.0) {
                    lblStation.setText(String.format("%.1f", (radio.selectStation(Integer.parseInt(((JButton) e.getSource()).getText())))));
                }
            }
        }
    }}
