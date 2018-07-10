package ru.bellintegrator.practice.organization.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.organization.controller.OrganizationListRequest;

import java.util.List;
import java.util.ArrayList;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/organization")
public class OrganizationController {

    @RequestMapping(value = "/list", method = POST)
    public ArrayList<OrganizationView> list(@RequestBody OrganizationListRequest request) {
        ArrayList<OrganizationView> organizations = new ArrayList<OrganizationView>();
		organizations.add(new OrganizationView(42, "ПАО Газпром", true));
		organizations.add(new OrganizationView(31, "ПАО Сбербанк", false));
		organizations.add(new OrganizationView(89, "ПАО ВТБ", true));

		return organizations;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public OrganizationView id(@PathVariable("id") Integer id) {
        return new OrganizationView(id, "Burger", true);
    }

    @RequestMapping(value = "/update", method = POST)
    public String update() {
        return "organization update";
    }

    @RequestMapping(value = "/save", method = POST)
    public String save() {
        return "organization save";
    }

    @RequestMapping(value = "/dog", method = GET)
    public String dog(@RequestParam(value = "id") Integer id,  Model model) {
        model.addAttribute("id", id);

        return "dog";
    }
}
