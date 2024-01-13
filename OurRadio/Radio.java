/**
 * @author Nils Muralles & Víctor Pérez
 * @version 1.0.0
 * @since 12/01/24
 * Clase radio que implementa las funcionalidades de la interfaz
 */

public class Radio implements IRadio {
    private boolean stateOnOff;
    private boolean stateAMFM;
    private int[] AMButtons;
    private int[] FMButtons;

    /**
     * Constructor de Radio
     */
    public Radio() {
        AMButtons = new int[12];
        FMButtons = new int[12];
        stateOnOff = false;
        stateAMFM = true;
    }

    @Override
    public void saveData(int buttonID, double station) {

    }

    @Override
    public boolean isAM() {
        return stateAMFM;

    }

    @Override
    public boolean isOn() {
        return stateOnOff;
    }

    @Override
    public double selectStation(int buttonID) {
        return buttonID;
     
    }

    /**
     * Enciende o apaga la radio
     */
    @Override
    public void switchOnOff() {
        if (!isOn()) {
            stateOnOff = true;
        } else {
            stateOnOff = false;
        }
    }

    /**
     * Cambia el modo de la radio entre AM y FM
     */
    @Override
    public void switchAMFM() {
        if (this.isOn()) {
            if (this.isAM()) {
                stateAMFM = false;

            } else {
                stateAMFM = true;
            }
        }
    }

    @Override
    public double nextStation() {
        return 0;
    }
}
