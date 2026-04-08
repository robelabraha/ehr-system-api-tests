package com.ehr.tests;

import com.ehr.ehrsystembackend.PatientController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PatientController Test Suite")
public class PatientControllerTest {

    private PatientController controller;

    @BeforeEach
    public void setUp() {
        controller = new PatientController();
    }

    @Test
    @DisplayName("Should retrieve all patients successfully")
    public void testGetPatients_ReturnsPatientList() {
        assertNotNull(controller.getPatients());
        assertEquals(2, controller.getPatients().size(), "Should return exactly 2 patients");
    }

    @Test
    @DisplayName("Should retrieve patient by valid ID")
    public void testGetPatientById_WithValidId_ReturnsCorrectPatient() {
        String result = controller.getPatientById(1);
        assertEquals("Patient #1", result);
        assertNotNull(result, "Patient should not be null");
    }

    @Test
    @DisplayName("Should return null for invalid patient ID")
    public void testGetPatientById_WithInvalidId_ReturnsNull() {
        String result = controller.getPatientById(999);
        assertNull(result, "Invalid patient ID should return null");
    }

    @Test
    @DisplayName("Should create patient with valid name")
    public void testCreatePatient_WithValidName_ReturnsSuccessMessage() {
        String result = controller.createPatient("Alice");
        assertEquals("Created patient: Alice", result);
        assertNotNull(result, "Creation result should not be null");
    }

    @Test
    @DisplayName("Should handle null patient name gracefully")
    public void testCreatePatient_WithNullName_HandlesGracefully() {
        assertThrows(IllegalArgumentException.class, () -> controller.createPatient(null),
                "Should throw IllegalArgumentException for null name");
    }

    @Test
    @DisplayName("Should handle empty patient name gracefully")
    public void testCreatePatient_WithEmptyName_HandlesGracefully() {
        assertThrows(IllegalArgumentException.class, () -> controller.createPatient(""),
                "Should throw IllegalArgumentException for empty name");
    }

    @Test
    @DisplayName("Should not create duplicate patients")
    public void testCreatePatient_WithDuplicateName_PreventsDuplicate() {
        String result1 = controller.createPatient("Bob");
        String result2 = controller.createPatient("Bob");
        assertNotNull(result1);
        assertNull(result2, "Should not create duplicate patient");
    }
}