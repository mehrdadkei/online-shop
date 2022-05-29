package onlineShop.app.onlineShop.services.product;

import onlineShop.app.onlineShop.entities.product.Feature;
import onlineShop.app.onlineShop.helper.exception.DataNotFoundException;
import onlineShop.app.onlineShop.repository.product.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository repository;


    public Feature getById(long id) {
        Optional<Feature> date = repository.findById(id);
        if (date.isPresent()) return date.get();
        return null;
    }

    public Feature add(Feature data) {
        return repository.save(data);
    }

    public Feature update(Feature data) throws DataNotFoundException {
        Feature oldData = getById(data.getId());

        if (oldData == null) {
            throw new DataNotFoundException("data with " + data.getId() + " not found ");
        }

        oldData.setValue(data.getValue());
        oldData.setKey(data.getKey());
        return repository.save(oldData);
    }

    public boolean delete(long id) throws DataNotFoundException {
        Feature del = getById(id);
        if (del == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        repository.deleteById(id);
        return true;
    }

}
