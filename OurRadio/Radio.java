/**
 * @author Nils Muralles & Víctor Pérez
 * @version 1.0.0
 * @since 12/01/24
 * Clase radio que implementa las funcionalidades de la interfaz
 */

public class Radio implements IRadio {
    private boolean stateOnOff;
    private boolean stateAMFM;
    private double[] AMButtons;
    private double[] FMButtons;
    private double currentStation;

    /**
     * Constructor de Radio
     */
    public Radio() {
        AMButtons = new double[12];
        FMButtons = new double[12];
        stateOnOff = false;
        stateAMFM = true;
        this.currentStation = 530.0;
    }


    /**
     * @return Estación actual de la radio
     */
    public double getCurrentStation() {
        return currentStation;
    }


    /**
     * Modifica la estación actual de la radio
     * @param currentStation Nueva estación
     */
    public void setCurrentStation(double currentStation) {
        this.currentStation = currentStation;
    }


    /**
     * Guarda una estación en un botón
     * @param buttonID Número del botón
     * @param station Estación a guardar
     */
    @Override
    public void saveStation(int buttonID, double station) {
        if (this.isOn()) {
            if (this.isAM()) {
                this.AMButtons[buttonID - 1] = station;

            } else {
                this.FMButtons[buttonID - 1] = station;
            }
        }
    }

    /**
     * Retorna el modo de la radio
     * @return boolean true si es AM, false si es FM
     */
    @Override
    public boolean isAM() {
        return stateAMFM;
    }

    /**
     * Comprueba si la radio está encendida
     * @return boolean true si está encendida, false si está apagada
     */
    @Override
    public boolean isOn() {
        return stateOnOff;
    }

    /**
     * Selecciona una estación previamente guardada
     * @param buttonID ID del botón seleccionado por el usuario
     * @return Estación seleccionada
     */
    @Override
    public double selectStation(int buttonID) {
        if (this.isAM()) {
            return AMButtons[buttonID-1];
        } else {
            return FMButtons[buttonID-1];
        }
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

    /**
     * Cambia de estación en función de si es AM o FM
     * @return currentStation: Estación en la que se encuentra el radio
     */
    @Override
    public double nextStation() {
        if (this.isOn()) {
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
        }
        return currentStation;
    }
}
