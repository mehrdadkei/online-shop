package onlineShop.app.onlineShop.services.order;

import onlineShop.app.onlineShop.entities.orders.OrderItem;
import onlineShop.app.onlineShop.helper.exception.DataNotFoundException;
import onlineShop.app.onlineShop.repository.orders.OrderItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;


    public OrderItem getById(long id) {
        Optional<OrderItem> date = repository.findById(id);
        if (date.isPresent()) return date.get();
        return null;
    }

    public OrderItem add(OrderItem data) {
        return repository.save(data);
    }

    public OrderItem update(OrderItem data) throws DataNotFoundException {
        OrderItem oldData = getById(data.getId());

        if (oldData == null) {
            throw new DataNotFoundException("data with " + data.getId() + " not found ");
        }



        oldData.setCount(data.getCount());
        oldData.setPrice(data.getPrice());
        return repository.save(oldData);
    }

    public boolean delete(long id) throws DataNotFoundException {
        OrderItem del = getById(id);
        if (del == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        repository.deleteById(id);
        return true;
    }



}
