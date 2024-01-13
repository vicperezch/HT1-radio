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

    @Override
    public void switchOnOff() {
        if (!isOn()) {
            stateOnOff = true;
        } else {
            stateOnOff = false;
        }
        System.out.println(stateOnOff);
    }

    @Override
    public void switchAMFM() {

    }

    @Override
    public double nextStation() {
        return 0;
    
    }

    
}
