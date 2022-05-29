package onlineShop.app.onlineShop.services.site;

import onlineShop.app.onlineShop.entities.site.Blog;
import onlineShop.app.onlineShop.helper.exception.DataNotFoundException;
import onlineShop.app.onlineShop.repository.site.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository repository;

    public List<Blog> search(String message ) {
        return repository.findAllByTitleContainsOrDescriptionContains(message);

    }

    public Blog getById(long id) {
        Optional<Blog> date = repository.findById(id);
        if (date.isPresent()) return date.get();
        return null;
    }

    public Blog add(Blog data) throws Exception {
        if (data.getTitle() == null || data.getTitle().equals("") ){
            throw new Exception("please fill title field");
        }
        return repository.save(data);
    }

    public Blog update(Blog data) throws DataNotFoundException {
        Blog oldData = getById(data.getId());

        if (oldData == null) {
            throw new DataNotFoundException("data with " + data.getId() + " not found ");
        }

        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        oldData.setStatus(data.getStatus());
        oldData.setSubtitle(data.getSubtitle());
        return repository.save(oldData);
    }

    public boolean delete(long id) throws DataNotFoundException {
        Blog del = getById(id);
        if (del == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        repository.deleteById(id);
        return true;
    }

    public Blog increaseVisitCount(long id) throws DataNotFoundException {
        Blog oldData = getById(id);

        if (oldData == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        oldData.setVisitCount(oldData.getVisitCount()+1);
        return repository.save(oldData);
    }
}
