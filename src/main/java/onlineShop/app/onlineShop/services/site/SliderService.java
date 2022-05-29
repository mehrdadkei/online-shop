package onlineShop.app.onlineShop.services.site;

import onlineShop.app.onlineShop.entities.site.Slider;
import onlineShop.app.onlineShop.helper.exception.DataNotFoundException;
import onlineShop.app.onlineShop.repository.site.SliderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SliderService {

    @Autowired
    private SliderRepository repository;

    public List<Slider> findAllOrdersByOrderItem() {
        return  repository.findAllByEnableIsTrue(Sort.by("arrangement"));

    }

    public Slider getById(long id) {
        Optional<Slider> date = repository.findById(id);
        if (date.isPresent()) return date.get();
        return null;
    }

    public Slider add(Slider data) {
        return repository.save(data);
    }

    public Slider update(Slider data) throws DataNotFoundException {
        Slider oldData = getById(data.getId());

        if (oldData == null) {
            throw new DataNotFoundException("data with " + data.getId() + " not found ");
        }

        oldData.setEnable(data.isEnable());
        oldData.setTitle(data.getTitle());
        oldData.setArrangement(data.getArrangement());
        oldData.setDescription(data.getDescription());
        oldData.setImage(data.getImage());
        oldData.setLink(data.getLink());
        return repository.save(oldData);
    }

    public boolean delete(long id) throws DataNotFoundException {
        Slider del = getById(id);
        if (del == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        repository.deleteById(id);
        return true;
    }
}
