package onlineShop.app.onlineShop.services.product;

import onlineShop.app.onlineShop.entities.product.Size;
import onlineShop.app.onlineShop.helper.exception.DataNotFoundException;
import onlineShop.app.onlineShop.repository.product.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SizeService {

    @Autowired
    private SizeRepository repository;


    public Size getById(long id) {
        Optional<Size> date = repository.findById(id);
        if (date.isPresent()) return date.get();
        return null;
    }

    public Size add(Size data) {
        return repository.save(data);
    }

    public Size update(Size data) throws DataNotFoundException {
        Size oldData = getById(data.getId());

        if (oldData == null) {
            throw new DataNotFoundException("data with " + data.getId() + " not found ");
        }

       oldData.setTitle(data.getTitle());
       oldData.setDescription(data.getDescription());
        return repository.save(oldData);
    }

    public boolean delete(long id) throws DataNotFoundException {
        Size del = getById(id);
        if (del == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        repository.deleteById(id);
        return true;
    }

}
