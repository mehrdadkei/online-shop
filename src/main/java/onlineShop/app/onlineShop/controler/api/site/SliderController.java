package onlineShop.app.onlineShop.controler.api.site;

import onlineShop.app.onlineShop.entities.site.Slider;
import onlineShop.app.onlineShop.helper.ui.ResponseStatus;
import onlineShop.app.onlineShop.helper.ui.ServiceResponse;
import onlineShop.app.onlineShop.services.site.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slider")
public class SliderController {

    @Autowired()
    private SliderService service;

    @GetMapping("")
    public ServiceResponse<Slider> search() {
        List<Slider> result = service.findAllOrdersByOrderItem();
        return new ServiceResponse<Slider>(ResponseStatus.success, result);
    }

    @GetMapping("/{id}")
    public ServiceResponse<Slider> search(@PathVariable long id) {
        Slider result = service.getById(id);
        return new ServiceResponse<Slider>(ResponseStatus.success, result);
    }

    @PostMapping("/")
    public ServiceResponse<Slider> add(@RequestBody Slider data) {
        try {
            Slider add = service.add(data);
            return new ServiceResponse<Slider>(ResponseStatus.success, add);
        } catch (Exception e) {
            return new ServiceResponse<Slider>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Slider> update(@RequestBody Slider data) {
        try {
            Slider update = service.update(data);
            return new ServiceResponse<Slider>(ResponseStatus.success, update);
        } catch (Exception e) {
            return new ServiceResponse<Slider>(e);
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

