package com.ehr.tests;

import com.ehr.ehrsystembackend.PatientController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientControllerTest {

    @Test
    public void testGetPatients() {
        PatientController controller = new PatientController();
        assertEquals(2, controller.getPatients().size());
    }

    @Test
    public void testGetPatientById() {
        PatientController controller = new PatientController();
        assertEquals("Patient #1", controller.getPatientById(1));
    }

    @Test
    public void testCreatePatient() {
        PatientController controller = new PatientController();
        assertEquals("Created patient: Alice", controller.createPatient("Alice"));
    }
}
