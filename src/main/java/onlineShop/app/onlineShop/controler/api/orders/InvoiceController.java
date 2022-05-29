package onlineShop.app.onlineShop.controler.api.orders;

import onlineShop.app.onlineShop.entities.orders.Invoice;
import onlineShop.app.onlineShop.helper.ui.ResponseStatus;
import onlineShop.app.onlineShop.helper.ui.ServiceResponse;
import onlineShop.app.onlineShop.services.order.InvoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Invoice")
public class InvoiceController {

    @Autowired()
    private InvoiceService service;

    @GetMapping("")
    public ServiceResponse<Invoice> find(@RequestParam long cid) {
        List<Invoice> result = service.findByCustomer(cid);
        return new ServiceResponse<Invoice>(ResponseStatus.success, result);
    }

    @GetMapping("/{id}")
    public ServiceResponse<Invoice> search(@PathVariable long id) {
        Invoice result = service.getById(id);
        return new ServiceResponse<Invoice>(ResponseStatus.success, result);
    }

    @PostMapping("/")
    public ServiceResponse<Invoice> add(@RequestBody Invoice data) {
        try {
            Invoice add = service.add(data);
            return new ServiceResponse<Invoice>(ResponseStatus.success, add);
        } catch (Exception e) {
            return new ServiceResponse<Invoice>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Invoice> update(@RequestBody Invoice data) {
        try {
            Invoice update = service.update(data);
            return new ServiceResponse<Invoice>(ResponseStatus.success, update);
        } catch (Exception e) {
            return new ServiceResponse<Invoice>(e);
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

