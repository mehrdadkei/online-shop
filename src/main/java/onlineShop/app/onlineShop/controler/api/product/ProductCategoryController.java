package onlineShop.app.onlineShop.controler.api.product;


import onlineShop.app.onlineShop.entities.product.ProductCategory;
import onlineShop.app.onlineShop.helper.ui.ResponseStatus;
import onlineShop.app.onlineShop.helper.ui.ServiceResponse;

import onlineShop.app.onlineShop.services.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ProductCategory")
public class ProductCategoryController {

    @Autowired()
    private ProductCategoryService service;

    @GetMapping("")
    public ServiceResponse<ProductCategory> find() {
        List<ProductCategory> result = service.findByEnable();
        return new ServiceResponse<ProductCategory>(ResponseStatus.success, result);
    }

    @GetMapping("/{id}")
    public ServiceResponse<ProductCategory> search(@PathVariable long id) {
        ProductCategory result = service.getById(id);
        return new ServiceResponse<ProductCategory>(ResponseStatus.success, result);
    }

    @PostMapping("/")
    public ServiceResponse<ProductCategory> add(@RequestBody ProductCategory data) {
        try {
            ProductCategory add = service.add(data);
            return new ServiceResponse<ProductCategory>(ResponseStatus.success, add);
        } catch (Exception e) {
            return new ServiceResponse<ProductCategory>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<ProductCategory> update(@RequestBody ProductCategory data) {
        try {
            ProductCategory update = service.update(data);
            return new ServiceResponse<ProductCategory>(ResponseStatus.success, update);
        } catch (Exception e) {
            return new ServiceResponse<ProductCategory>(e);
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

