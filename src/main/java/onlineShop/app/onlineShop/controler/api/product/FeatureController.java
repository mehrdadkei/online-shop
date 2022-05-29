package onlineShop.app.onlineShop.controler.api.product;
import onlineShop.app.onlineShop.entities.product.Feature;
import onlineShop.app.onlineShop.helper.ui.ResponseStatus;
import onlineShop.app.onlineShop.helper.ui.ServiceResponse;
import onlineShop.app.onlineShop.services.product.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Feature")
public class FeatureController {

    @Autowired()
    private FeatureService service;



    @GetMapping("/{id}")
    public ServiceResponse<Feature> search(@PathVariable long id) {
        Feature result = service.getById(id);
        return new ServiceResponse<Feature>(ResponseStatus.success, result);
    }

    @PostMapping("/")
    public ServiceResponse<Feature> add(@RequestBody Feature data) {
        try {
            Feature add = service.add(data);
            return new ServiceResponse<Feature>(ResponseStatus.success, add);
        } catch (Exception e) {
            return new ServiceResponse<Feature>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Feature> update(@RequestBody Feature data) {
        try {
            Feature update = service.update(data);
            return new ServiceResponse<Feature>(ResponseStatus.success, update);
        } catch (Exception e) {
            return new ServiceResponse<Feature>(e);
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

