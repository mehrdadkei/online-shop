package onlineShop.app.onlineShop.controler.api.people;

import onlineShop.app.onlineShop.entities.people.Customer;

import onlineShop.app.onlineShop.helper.ui.ResponseStatus;
import onlineShop.app.onlineShop.helper.ui.ServiceResponse;
import onlineShop.app.onlineShop.services.people.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired()
    private CustomerService service;


    @GetMapping("/{id}")
    public ServiceResponse<Customer> search(@PathVariable long id) {
        Customer result = service.getById(id);
        return new ServiceResponse<Customer>(ResponseStatus.success, result);
    }

    @PostMapping("/")
    public ServiceResponse<Customer> add(@RequestBody Customer data) {
        try {
            Customer add = service.add(data);
            return new ServiceResponse<Customer>(ResponseStatus.success, add);
        } catch (Exception e) {
            return new ServiceResponse<Customer>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Customer> update(@RequestBody Customer data) {
        try {
            Customer update = service.update(data);
            return new ServiceResponse<Customer>(ResponseStatus.success, update);
        } catch (Exception e) {
            return new ServiceResponse<Customer>(e);
        }
    }

    @DeleteMapping("{id}")
    public ServiceResponse<Boolean> delete(@PathVariable long id) {
        try {
            boolean delete = service.delete(id);
            return new ServiceResponse<Boolean>(ResponseStatus.success, delete);
        } catch (Exception e) {
            return new ServiceResponse<Boolean>(e);
        }
    }


}

