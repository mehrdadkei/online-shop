package onlineShop.app.onlineShop.services.people;

import onlineShop.app.onlineShop.entities.people.Customer;
import onlineShop.app.onlineShop.helper.exception.DataNotFoundException;
import onlineShop.app.onlineShop.repository.people.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;


    public Customer getById(long id) {
        Optional<Customer> date = repository.findById(id);
        if (date.isPresent()) return date.get();
        return null;
    }

    public Customer add(Customer data) {
        return repository.save(data);
    }

    public Customer update(Customer data) throws DataNotFoundException {
        Customer oldData = getById(data.getId());

        if (oldData == null) {
            throw new DataNotFoundException("data with " + data.getId() + " not found ");
        }


        oldData.setEmail(data.getEmail());
        oldData.setAddress(data.getAddress());
        oldData.setFirstname(data.getFirstname());
        oldData.setLastname(data.getLastname());
        oldData.setMobile(data.getMobile());
        oldData.setPostalCode(data.getPostalCode());
        oldData.setTel(data.getTel());
        return repository.save(oldData);
    }

    public boolean delete(long id) throws DataNotFoundException {
        Customer del = getById(id);
        if (del == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        repository.deleteById(id);
        return true;
    }



}
