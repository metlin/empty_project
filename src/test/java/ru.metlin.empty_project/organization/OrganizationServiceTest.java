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

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

//  @RunWith(SpringJUnit4ClassRunner.class)

public class OrganizationServiceTest {
    
    @Test
    public void validationByNameTest() throws Exception {
        OrganizationServiceImpl organization = new OrganizationServiceImpl();

        String testName = "Ivan";
        assertTrue("This will true", organization.validationByName(testName));
    }
}
