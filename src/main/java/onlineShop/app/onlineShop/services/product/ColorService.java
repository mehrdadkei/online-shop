package onlineShop.app.onlineShop.services.product;

import onlineShop.app.onlineShop.entities.product.Color;
import onlineShop.app.onlineShop.helper.exception.DataNotFoundException;
import onlineShop.app.onlineShop.repository.product.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {

    @Autowired
    private ColorRepository repository;


    public Color getById(long id) {
        Optional<Color> date = repository.findById(id);
        if (date.isPresent()) return date.get();
        return null;
    }

    public Color add(Color data) {
        return repository.save(data);
    }

    public Color update(Color data) throws DataNotFoundException {
        Color oldData = getById(data.getId());

        if (oldData == null) {
            throw new DataNotFoundException("data with " + data.getId() + " not found ");
        }

        oldData.setTitle(data.getTitle());
        oldData.setValue(data.getValue());
        return repository.save(oldData);
    }

    public boolean delete(long id) throws DataNotFoundException {
        Color del = getById(id);
        if (del == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        repository.deleteById(id);
        return true;
    }

}
