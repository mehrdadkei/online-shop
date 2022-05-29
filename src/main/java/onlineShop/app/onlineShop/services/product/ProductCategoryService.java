package onlineShop.app.onlineShop.services.product;

import onlineShop.app.onlineShop.entities.product.ProductCategory;
import onlineShop.app.onlineShop.helper.exception.DataNotFoundException;
import onlineShop.app.onlineShop.repository.product.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    public List<ProductCategory> findByEnable() {
        return repository.findAllByEnableIsTrue(Sort.by("id "));

    }

    public ProductCategory getById(long id) {
        Optional<ProductCategory> date = repository.findById(id);
        if (date.isPresent()) return date.get();
        return null;
    }

    public ProductCategory add(ProductCategory data) {
        return repository.save(data);
    }

    public ProductCategory update(ProductCategory data) throws DataNotFoundException {
        ProductCategory oldData = getById(data.getId());

        if (oldData == null) {
            throw new DataNotFoundException("data with " + data.getId() + " not found ");
        }

        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        oldData.setEnable(data.isEnable());
        oldData.setImage(data.getImage());
        oldData.setProduct(data.getProduct());
        return repository.save(oldData);
    }

    public boolean delete(long id) throws DataNotFoundException {
        ProductCategory del = getById(id);
        if (del == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        repository.deleteById(id);
        return true;
    }

}
