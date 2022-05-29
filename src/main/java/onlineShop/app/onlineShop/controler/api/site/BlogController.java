package onlineShop.app.onlineShop.controler.api.site;

import onlineShop.app.onlineShop.entities.site.Blog;
import onlineShop.app.onlineShop.helper.ui.ResponseStatus;
import onlineShop.app.onlineShop.helper.ui.ServiceResponse;
import onlineShop.app.onlineShop.services.site.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired()
    private BlogService service;

    @GetMapping("")
    public ServiceResponse<Blog> search(@RequestParam String keyword) {
        List<Blog> result = service.search(keyword);
        return new ServiceResponse<Blog>(ResponseStatus.success, result);
    }

    @GetMapping("/{id}")
    public ServiceResponse<Blog> search(@PathVariable long id) {
        Blog result = service.getById(id);
        return new ServiceResponse<Blog>(ResponseStatus.success, result);
    }

    @PostMapping("/")
    public ServiceResponse<Blog> add(@RequestBody Blog data) {
        try {
            Blog add = service.add(data);
            return new ServiceResponse<Blog>(ResponseStatus.success, add);
        } catch (Exception e) {
            return new ServiceResponse<Blog>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Blog> update(@RequestBody Blog data) {
        try {
            Blog update = service.update(data);
            return new ServiceResponse<Blog>(ResponseStatus.success, update);
        } catch (Exception e) {
            return new ServiceResponse<Blog>(e);
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

    @PutMapping("/increase/{id}")
    public ServiceResponse<Blog> increase(@PathVariable long id) {
        try {
            Blog increase = service.increaseVisitCount(id);
            return new ServiceResponse<Blog>(ResponseStatus.success, increase);
        } catch (Exception e) {
            return new ServiceResponse<Blog>(e);
        }
    }


}

