package onlineShop.app.onlineShop.controler.api.site;

import onlineShop.app.onlineShop.entities.site.Nav;
import onlineShop.app.onlineShop.helper.ui.ResponseStatus;
import onlineShop.app.onlineShop.helper.ui.ServiceResponse;
import onlineShop.app.onlineShop.services.site.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nav")
public class NavController {

    @Autowired()
    private NavService service;

    @GetMapping("")
    public ServiceResponse<Nav> search() {
        List<Nav> result = service.findAllOrdersByOrderItem();
        return new ServiceResponse<Nav>(ResponseStatus.success, result);
    }

    @GetMapping("")
    public ServiceResponse<Nav> getAll(@RequestParam Integer pageSize ,@RequestParam Integer pageNumber) {
      try{
        List<Nav> result = service.getAll(pageSize,pageNumber);
        long totalCount=service.totalCount();
        return new ServiceResponse<Nav>(ResponseStatus.success, result,totalCount);
    } catch (Exception e) {
        return new ServiceResponse<Nav>(e);
    }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Nav> search(@PathVariable long id) {
        Nav result = service.getById(id);
        return new ServiceResponse<Nav>(ResponseStatus.success, result);
    }

    @PostMapping("/")
    public ServiceResponse<Nav> add(@RequestBody Nav data) {
        try {
            Nav add = service.add(data);
            return new ServiceResponse<Nav>(ResponseStatus.success, add);
        } catch (Exception e) {
            return new ServiceResponse<Nav>(e);
        }
    }

    @PostMapping("/changeOrder/{id}/{direction}")
    public ServiceResponse<Nav> changeOrder(@PathVariable long id, @PathVariable Integer direction ) {
        try {
            Nav add = service.changingOrder(id,direction);
            return new ServiceResponse<Nav>(ResponseStatus.success, add);
        } catch (Exception e) {
            return new ServiceResponse<Nav>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<Nav> update(@RequestBody Nav data) {
        try {
            Nav update = service.update(data);
            return new ServiceResponse<Nav>(ResponseStatus.success, update);
        } catch (Exception e) {
            return new ServiceResponse<Nav>(e);
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

