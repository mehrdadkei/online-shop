package onlineShop.app.onlineShop.controler.api.product;
import onlineShop.app.onlineShop.entities.product.Size;
import onlineShop.app.onlineShop.helper.ui.ResponseStatus;
import onlineShop.app.onlineShop.helper.ui.ServiceResponse;
import onlineShop.app.onlineShop.services.product.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Size")
public class SizeController {

    @Autowired()
    private SizeService service;



    @GetMapping("/{id}")
    public ServiceResponse<Size> search(@PathVariable long id) {
        Size result = service.getById(id);
        return new ServiceResponse<Size>(ResponseStatus.success, result);
    }

    @PostMapping("/")
    public ServiceResponse<Size> add(@RequestBody Size data) {
        try {
            Size add = service.add(data);
            return new ServiceResponse<Size>(ResponseStatus.success, add);
        } catch (Exception e) {
            return new ServiceResponse<Size>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Size> update(@RequestBody Size data) {
        try {
            Size update = service.update(data);
            return new ServiceResponse<Size>(ResponseStatus.success, update);
        } catch (Exception e) {
            return new ServiceResponse<Size>(e);
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

