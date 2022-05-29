package onlineShop.app.onlineShop.services.site;

import onlineShop.app.onlineShop.entities.site.Content;
import onlineShop.app.onlineShop.helper.exception.DataNotFoundException;
import onlineShop.app.onlineShop.repository.site.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    private ContentRepository repository;

    public Content  findFirstByKey(String key) {
        return repository.findFirstByKey(key );

    }

    public Content getById(long id) {
        Optional<Content> date = repository.findById(id);
        if (date.isPresent()) return date.get();
        return null;
    }

    public Content add(Content data) {
        return repository.save(data);
    }

    public Content update(Content data) throws DataNotFoundException {
        Content oldData = getById(data.getId());

        if (oldData == null) {
            throw new DataNotFoundException("data with " + data.getId() + " not found ");
        }

        oldData.setValue(data.getValue());
        return repository.save(oldData);
    }

    public boolean delete(long id) throws DataNotFoundException {
        Content del = getById(id);
        if (del == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        repository.deleteById(id);
        return true;
    }
}
