/**
 * @author Nils Muralles & Víctor Pérez
 * @version 1.0.0
 * @since 12/01/24
 * Clase RadioTest que contiene tres pruebas unitarias para el programa
 */


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    /**
     * Test 1: Colocar una estación AM mayor a 1610.0 debería regresar a la 530.0
     */
    @Test
    public void testAMStation1620OutOfBounds(){
        Radio newRadio = new Radio();
        newRadio.switchOnOff();

        newRadio.setCurrentStation(1610.0);
        assertEquals(530.0, newRadio.nextStation());
    }

    /**
     * Test 2: Tratar de seleccionar el botón 13 devolverá una excepción tipo IndexOutOfBounds para arrays de longitud 12
     */
    @Test
    public void testSelect13thStationIsOutOfBounds() {
        Radio newRadio = new Radio();
        newRadio.switchOnOff();

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> newRadio.selectStation(13));
        assertEquals("Index 12 out of bounds for length 12", exception.getMessage());
    }

    /**
     * Test 3: Guarda una estación en el botón 1 y presionarlo para regresar a ella
     */
    @Test
    public void testSavingAndSelectingAStation() {
        Radio newRadio = new Radio();

        // Guarda la estación 540.0 en el botón 1 y cambia a la siguiente
        newRadio.switchOnOff();
        newRadio.nextStation();
        newRadio.saveStation(1, newRadio.getCurrentStation());

        newRadio.nextStation();

        assertEquals(540.0, newRadio.selectStation(1));
    }
}