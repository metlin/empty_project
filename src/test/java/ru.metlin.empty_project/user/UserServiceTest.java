package ru.metlin.empty_project.user;

import org.junit.Test;
import ru.metlin.empty_project.user.service.UserServiceImpl;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class UserServiceTest {

    private UserServiceImpl user = new UserServiceImpl();

    @Test
    public void validationByNameTestPositive () throws Exception {
        assertTrue(user.validationByFirstName("Ivan"));
    }

    @Test(expected = Exception.class)
    public void validationByNameTestNegativeOne() throws Exception {
        assertFalse(user.validationByFirstName("Ivan4"));
    }

    @Test(expected = Exception.class)
    public void validationByNameTestNegativeTwo() throws Exception {
        assertFalse(user.validationByFirstName("Iva n"));
    }

    @Test(expected = Exception.class)
    public void validationByNameTestNegativeThree() throws Exception {
        assertFalse(user.validationByFirstName("Iva&n"));
    }

    @Test
    public void validationByPositionPositive() throws Exception {
        assertTrue(user.validationByPosition("Manager"));
    }

    @Test(expected = Exception.class)
    public void validationByPositionNeganiveOne() throws Exception {
        assertTrue(user.validationByPosition("Manager23"));
    }

    @Test(expected = Exception.class)
    public void validationByPositionNeganiveTwo() throws Exception {
        assertTrue(user.validationByPosition("M@nager"));
    }

    @Test(expected = Exception.class)
    public void validationByPositionNeganiveThree() throws Exception {
        assertTrue(user.validationByPosition(null));
    }
}
