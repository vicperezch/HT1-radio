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
import java.sql.Struct;

public class MainGUI {

    private static JFrame myFrame;
    private int frameWidth;
    private int frameHeight;
    private JPanel pnlMain;
    private JButton btnPower;

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
        myFrame.setLocation(dim.width/2 - myFrame.getSize().width/2, dim.height/2-myFrame.getSize().height/2);
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
    }


}
