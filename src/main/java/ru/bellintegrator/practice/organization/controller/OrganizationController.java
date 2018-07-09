package ru.bellintegrator.practice.organization;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    @RequestMapping(value = "/list", method = {POST})
    public String list() {
        return "organization list";
    }

    @RequestMapping(value = "/{id}", method = {GET})
    public String id(@PathVariable("id") Long id) {
        return "organization " + id;
    }

    @RequestMapping(value = "/update", method = {POST})
    public String update() {
        return "organization update";
    }

    @RequestMapping(value = "/save", method = {POST})
    public String save() {
        return "organization save";
    }

    @RequestMapping(value = "/dog", method = {GET})
    public String dog(@RequestParam(value = "id") Integer id) {
        return "hello, dog!" + id;
    }
}
