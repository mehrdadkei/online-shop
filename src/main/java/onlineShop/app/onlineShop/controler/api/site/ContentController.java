package onlineShop.app.onlineShop.controler.api.site;

import onlineShop.app.onlineShop.entities.site.Content;
import onlineShop.app.onlineShop.helper.ui.ResponseStatus;
import onlineShop.app.onlineShop.helper.ui.ServiceResponse;
import onlineShop.app.onlineShop.services.site.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Content")
public class ContentController {

    @Autowired()
    private ContentService service;

    @GetMapping("")
    public ServiceResponse<Content> search(@RequestParam String keyword) {
        Content result = service.findFirstByKey(keyword);
        return new ServiceResponse<Content>(ResponseStatus.success, result);
    }

    @GetMapping("/{id}")
    public ServiceResponse<Content> search(@PathVariable long id) {
        Content result = service.getById(id);
        return new ServiceResponse<Content>(ResponseStatus.success, result);
    }

    @PostMapping("/")
    public ServiceResponse<Content> add(@RequestBody Content data) {
        try {
            Content add = service.add(data);
            return new ServiceResponse<Content>(ResponseStatus.success, add);
        } catch (Exception e) {
            return new ServiceResponse<Content>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Content> update(@RequestBody Content data) {
        try {
            Content update = service.update(data);
            return new ServiceResponse<Content>(ResponseStatus.success, update);
        } catch (Exception e) {
            return new ServiceResponse<Content>(e);
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

