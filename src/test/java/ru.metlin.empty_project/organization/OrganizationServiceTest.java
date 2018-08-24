package ru.metlin.empty_project.organization;


import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.metlin.empty_project.organization.request.SaveOrganizationRequest;
import ru.metlin.empty_project.organization.service.OrganizationService;
import ru.metlin.empty_project.organization.service.OrganizationServiceImpl;

import javax.transaction.Transactional;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;


//  @RunWith(SpringJUnit4ClassRunner.class)

public class OrganizationServiceTest {

    private OrganizationServiceImpl organization = new OrganizationServiceImpl();

    @Test
    public void validationByNameTestPositive() throws Exception {
        assertTrue(organization.validationByName("Gazprom"));
    }

    @Test(expected = Exception.class)
    public void validationByNameTestNegativeOne() throws Exception {
        assertFalse(organization.validationByName("Gazprom41"));
    }

    @Test(expected = Exception.class)
    public void validationByNameTestNegativeTwo() throws Exception {
        assertFalse(organization.validationByName("Gaz prom"));
    }

    @Test(expected = Exception.class)
    public void validationByNameTestNegativeThree() throws Exception {
        assertFalse(organization.validationByName("G@zprom"));
    }

    @Test
    public void validationByInnAndKppTestPositive() throws Exception {

        Long testInn = 1234567898L;
        Long testKpp = 123456787L;

        assertTrue(organization.validationByInnAndKpp(testInn, testKpp));
    }

    @Test(expected = Exception.class)
    public void validationByInnAndKppTestNeganiveOne() throws Exception {
        assertFalse(organization.validationByInnAndKpp(134565432L, 45675543L));
    }

    @Test(expected = Exception.class)
    public void validationByInnAndKppTestNeganiveTwo() throws Exception {
        assertFalse(organization.validationByInnAndKpp(13456543234L, 4567554332L));
    }

    @Test(expected = Exception.class)
    public void validationByInnAndKppTestNeganiveThree() throws Exception {
        assertFalse(organization.validationByInnAndKpp(1345654326L, 45675543L));
    }
}
