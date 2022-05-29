package onlineShop.app.onlineShop.services.product;

import onlineShop.app.onlineShop.entities.product.Product;

import onlineShop.app.onlineShop.helper.exception.DataNotFoundException;
import onlineShop.app.onlineShop.repository.product.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findByCategory(long category ) {
        return repository.findAllByCategory(category);

    }

    public List<Product> search(String message){
        return repository.findAllByEnableIsTrueAndTitleContainsOrDescriptionContains(message);
    }

    public Product getById(long id) {
        Optional<Product> date = repository.findById(id);
        if (date.isPresent()) return date.get();
        return null;
    }

    public Product add(Product data) {
        return repository.save(data);
    }

    public Product update(Product data) throws DataNotFoundException {
        Product oldData = getById(data.getId());

        if (oldData == null) {
            throw new DataNotFoundException("data with " + data.getId() + " not found ");
        }

        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        oldData.setEnable(data.isEnable());
        oldData.setExists(data.isExists());
        oldData.setCategory(data.getCategory());
        oldData.setImage(data.getImage());
        oldData.setPrice(data.getPrice());
        oldData.setColors(data.getColors());
        oldData.setFeature(data.getFeature());
        oldData.setSizes(data.getSizes());
        return repository.save(oldData);
    }

    public boolean delete(long id) throws DataNotFoundException {
        Product del = getById(id);
        if (del == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        repository.deleteById(id);
        return true;
    }

    public Product increaseVisitCount(long id) throws DataNotFoundException {
        Product oldData = getById(id);

        if (oldData == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        oldData.setVisitCount(oldData.getVisitCount()+1);
        return repository.save(oldData);
    }


}
