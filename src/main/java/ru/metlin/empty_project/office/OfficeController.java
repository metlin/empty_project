package ru.metlin.empty_project.office;

import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/office")
public class OfficeController {

    @PostMapping(value = "/list/{orgId}")
    private List<Office> getOffiiceList(@RequestBody OfficeListRequest request, @PathVariable Long orgId) {
        Office office = new Office();
        office.setId(42L);
        office.setName("Garprom");
        office.setActive(true);
        office.setOrgId(orgId);

        return Arrays.asList(office, office, office);
    }

    @GetMapping(value = "/{id}")
    private Office getOffice(@PathVariable Long id) {
        Office office = new Office();
        office.setId(id);
        office.setName("Garprom");
        office.setAddress("RF, Moskow");
        office.setPhone("8(495)123-45-67");
        office.setActive(true);

        return office;
    }

    @PostMapping(value = "/save")
    private String createOffice(@RequestBody SaveOfficeRequest request) {
        return "success";
    }

    @PostMapping(value = "/update")
    private String updateOffice(@RequestBody UpdateOfficeRequest request) {
        return "success";
    }
}
