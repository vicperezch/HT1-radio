/**
 * @author Nils Muralles & Víctor Pérez
 * @version 1.0.0
 * @since 12/01/24
 * Clase que implementa la GUI del programa
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    /**
     * Constructor de MainGUI
     */
    public MainGUI(){
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

        Radio radio = new Radio();       

        btnPower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!radio.isOn()) {
                    btnPower.setIcon(btnPower.getSelectedIcon());
                    radio.switchOnOff();
                } else {
                    btnPower.setIcon(btnPower.getDisabledIcon());
                    radio.switchOnOff();
                }

            }
        });
        btnAmFm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radio.isOn()) {
                    if (radio.isAM()) {
                        btnAmFm.setIcon(btnAmFm.getSelectedIcon());

                    } else {
                        btnAmFm.setIcon(btnAmFm.getDisabledIcon());
                    }

                    radio.switchAMFM();
                }
            }
        });
    }


}
