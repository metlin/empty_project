package ru.metlin.empty_project.organization;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.metlin.empty_project.organization.dao.OrganizationDao;
import ru.metlin.empty_project.organization.dao.OrganizationDaoImpl;
import ru.metlin.empty_project.organization.model.Organization;
import ru.metlin.empty_project.organization.request.OrganizationListRequest;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrganizationDaoTest {

    @Autowired
    private OrganizationDao orgDao;

    @Test
    public void getByIdTestPositive() throws Exception {

        Organization organization = orgDao.getById(1L);
        assertNotNull(organization);
    }

    @Ignore
    @Test(expected = Exception.class)
    public void getByIdTestNegative() {
        assertNull(orgDao.getById(2L));
    }

    @Ignore
    @Test
    public void getAllTestPositive() throws Exception {
        OrganizationListRequest orgRequest = new OrganizationListRequest();
        orgRequest.setName("string");

        List<Organization> orgList = orgDao.all(orgRequest);
    }
}
