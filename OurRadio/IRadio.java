/**
 * @author Nils Muralles
 * @version 1.0.0
 * @since 10/01/24
 * Interfaz con los métodos para el funcionamiento del radio
 */

 public interface IRadio {
    void saveData(int buttonID, double station);
    boolean isAM();
    boolean isOn();
    double selectStation(int buttonID);
    void switchOnOff();
    void switchAMFM();
    double nextStation();
}