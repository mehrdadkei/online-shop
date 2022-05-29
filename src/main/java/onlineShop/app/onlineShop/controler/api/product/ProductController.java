package onlineShop.app.onlineShop.controler.api.product;


import onlineShop.app.onlineShop.entities.product.Product;
import onlineShop.app.onlineShop.entities.site.Blog;
import onlineShop.app.onlineShop.helper.ui.ResponseStatus;
import onlineShop.app.onlineShop.helper.ui.ServiceResponse;
import onlineShop.app.onlineShop.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Product")
public class ProductController {

    @Autowired()
    private ProductService service;

    @GetMapping("/category")
    public ServiceResponse<Product> find(@RequestBody long category) {
        List<Product> result = service.findByCategory(category);
        return new ServiceResponse<Product>(ResponseStatus.success, result);
    }

    @GetMapping("/search/")
    public ServiceResponse<Product> search(@RequestParam String message) {
        List<Product> result = service.search(message);
        return new ServiceResponse<Product>(ResponseStatus.success, result);
    }
    

    @GetMapping("/{id}")
    public ServiceResponse<Product> search(@PathVariable long id) {
        Product result = service.getById(id);
        return new ServiceResponse<Product>(ResponseStatus.success, result);
    }

    @PostMapping("/add")
    public ServiceResponse<Product> add(@RequestBody Product data) {
        try {
            Product add = service.add(data);
            return new ServiceResponse<Product>(ResponseStatus.success, add);
        } catch (Exception e) {
            return new ServiceResponse<Product>(e);
        }
    }

    @PutMapping("/update")
    public ServiceResponse<Product> update(@RequestBody Product data) {
        try {
            Product update = service.update(data);
            return new ServiceResponse<Product>(ResponseStatus.success, update);
        } catch (Exception e) {
            return new ServiceResponse<Product>(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ServiceResponse<Boolean> delete(@PathVariable long id) {
        try {
            boolean delete = service.delete(id);
            return new ServiceResponse<Boolean>(ResponseStatus.success, delete);
        } catch (Exception e) {
            return new ServiceResponse<Boolean>(e);
        }
    }


    @PutMapping("/increase/{id}")
    public ServiceResponse<Product> increase(@PathVariable long id) {
        try {
            Product increase = service.increaseVisitCount(id);
            return new ServiceResponse<Product>(ResponseStatus.success, increase);
        } catch (Exception e) {
            return new ServiceResponse<Product>(e);
        }
    }



}

