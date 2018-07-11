package ru.bellintegrator.practice.organization.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationIdView;
import ru.bellintegrator.practice.organization.request.OrganizationListRequest;
import ru.bellintegrator.practice.organization.request.OrganizationUpdateRequest;
import ru.bellintegrator.practice.organization.request.OrganizationSaveRequest;
import ru.bellintegrator.practice.organization.model.OrganizationRepository;
import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;
import java.util.ArrayList;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController

@RequestMapping(value = "/api/organization")
public class OrganizationController {

	@Autowired
    private OrganizationRepository organizationRepository;

    @RequestMapping(value = "/list", method = POST)
    public Iterable<Organization> list(@RequestBody OrganizationListRequest request) {
        ArrayList<OrganizationListView> organizations = new ArrayList<OrganizationListView>();
		organizations.add(new OrganizationListView(42L, "ПАО Газпром", true));
		organizations.add(new OrganizationListView(31L, "ПАО Сбербанк", false));
		organizations.add(new OrganizationListView(89L, "ПАО ВТБ", true));

		return organizationRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public OrganizationIdView id(@PathVariable("id") Long id) {
        return new OrganizationIdView(id, "Газпром", "ПАО Газпром", 1234321789L, 543235789L,
        	"Москва, пр.Ленина, д.1", "8(495)123-45-67" ,true);
    }

    @RequestMapping(value = "/update", method = POST)
    public String update(@RequestBody OrganizationUpdateRequest update) {
        return "success";
    }

    @RequestMapping(value = "/save", method = POST)
    public String save(@RequestBody OrganizationSaveRequest save) {
        return "success";
    }

/*   @RequestMapping(value = "/test", method = POST)
    public OrganizationView test(@RequestBody OrganizationView organization) {
        return organization;
    } */ 
}
