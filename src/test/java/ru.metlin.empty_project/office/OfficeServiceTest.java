package ru.metlin.empty_project.office;

import org.junit.Test;
import ru.metlin.empty_project.office.service.OfficeServiceImpl;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class OfficeServiceTest {

    private OfficeServiceImpl office = new OfficeServiceImpl();

    @Test
    public void validationByNameTestPositive () throws Exception {
        assertTrue(office.validationByName("Central"));
    }

    @Test(expected = Exception.class)
    public void validationByNameTestNegativeOne() throws Exception {
        assertFalse(office.validationByName("Central43"));
    }

    @Test(expected = Exception.class)
    public void validationByNameTestNegativeTwo() throws Exception {
        assertFalse(office.validationByName("Cen tral"));
    }

    @Test(expected = Exception.class)
    public void validationByNameTestNegativeThree() throws Exception {
        assertFalse(office.validationByName("Centr@l"));
    }

    @Test
    public void validationByPhoneTestPositiveOne() throws Exception {

        String phoneTest = "8(831)423-45-67";

        assertTrue(office.validationByPhone(phoneTest));
    }

    @Test
    public void validationByPhoneTestPositiveTwo() throws Exception {

        String phoneTest = "+7(904)123-45-12";

        assertTrue(office.validationByPhone(phoneTest));
    }

    @Test(expected = Exception.class)
    public void validationByPhoneTestNegativeOne() throws Exception {
        assertFalse(office.validationByPhone("8(831)423-45-fg"));
    }

    @Test(expected = Exception.class)
    public void validationByPhoneTestNegativeTwo() throws Exception {
        assertFalse(office.validationByPhone("+8(831)423-45"));
    }

    @Test(expected = Exception.class)
    public void validationByPhoneTestNegativeThree() throws Exception {
        assertFalse(office.validationByPhone("no number"));
    }
}
