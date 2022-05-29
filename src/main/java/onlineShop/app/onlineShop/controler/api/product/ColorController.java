package onlineShop.app.onlineShop.controler.api.product;
import onlineShop.app.onlineShop.entities.product.Color;
import onlineShop.app.onlineShop.helper.ui.ResponseStatus;
import onlineShop.app.onlineShop.helper.ui.ServiceResponse;
import onlineShop.app.onlineShop.services.product.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Color")
public class ColorController {

    @Autowired()
    private ColorService service;



    @GetMapping("/{id}")
    public ServiceResponse<Color> search(@PathVariable long id) {
        Color result = service.getById(id);
        return new ServiceResponse<Color>(ResponseStatus.success, result);
    }

    @PostMapping("/")
    public ServiceResponse<Color> add(@RequestBody Color data) {
        try {
            Color add = service.add(data);
            return new ServiceResponse<Color>(ResponseStatus.success, add);
        } catch (Exception e) {
            return new ServiceResponse<Color>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Color> update(@RequestBody Color data) {
        try {
            Color update = service.update(data);
            return new ServiceResponse<Color>(ResponseStatus.success, update);
        } catch (Exception e) {
            return new ServiceResponse<Color>(e);
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

