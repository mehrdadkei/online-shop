package onlineShop.app.onlineShop.controler.api.orders;

import onlineShop.app.onlineShop.entities.orders.OrderItem;
import onlineShop.app.onlineShop.helper.ui.ResponseStatus;
import onlineShop.app.onlineShop.helper.ui.ServiceResponse;
import onlineShop.app.onlineShop.services.order.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/OrderItem")
public class OrderItemController {

    @Autowired()
    private OrderItemService service;


    @GetMapping("/{id}")
    public ServiceResponse<OrderItem> search(@PathVariable long id) {
        OrderItem result = service.getById(id);
        return new ServiceResponse<OrderItem>(ResponseStatus.success, result);
    }

    @PostMapping("/")
    public ServiceResponse<OrderItem> add(@RequestBody OrderItem data) {
        try {
            OrderItem add = service.add(data);
            return new ServiceResponse<OrderItem>(ResponseStatus.success, add);
        } catch (Exception e) {
            return new ServiceResponse<OrderItem>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<OrderItem> update(@RequestBody OrderItem data) {
        try {
            OrderItem update = service.update(data);
            return new ServiceResponse<OrderItem>(ResponseStatus.success, update);
        } catch (Exception e) {
            return new ServiceResponse<OrderItem>(e);
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

