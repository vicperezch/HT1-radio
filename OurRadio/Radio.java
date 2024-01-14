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
    private double currentStation;

    /**
     * Constructor de Radio
     */
    public Radio() {
        AMButtons = new int[12];
        FMButtons = new int[12];
        stateOnOff = false;
        stateAMFM = true;
    }

    

    public double getCurrentStation() {
        return currentStation;
    }



    public void setCurrentStation(double currentStation) {
        this.currentStation = currentStation;
    }



    @Override
    public void saveData(int buttonID, double station) {

    }

    @Override
    public boolean isAM() {return stateAMFM;}

    @Override
    public boolean isOn() {
        return stateOnOff;
    }

    @Override
    public double selectStation(int buttonID) {return buttonID;}

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

    /**
     * Cambia de estación en función de si es AM o FM
     * @return currentStation: Estación en la que se encuentra el radio
     */
    @Override
    public double nextStation() {
        if(this.isAM()){
            if(currentStation < 1610.0){
                currentStation +=10;
            } else {
                currentStation = 530.0;
            }

        } else {
            if(currentStation <107.9){
                currentStation +=0.2;
            } else {
                currentStation = 87.9;
            }
        }
        return currentStation;
    }
}
