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
    public void AMStation1620OutOfBounds(){
        Radio newRadio = new Radio();
        newRadio.setCurrentStation(1610.0);
        assertEquals(530.0, newRadio.nextStation());
    }
}