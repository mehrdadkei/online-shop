package onlineShop.app.onlineShop.services.order;

import onlineShop.app.onlineShop.entities.orders.Invoice;
import onlineShop.app.onlineShop.helper.exception.DataNotFoundException;
import onlineShop.app.onlineShop.repository.orders.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    public List<Invoice> findByCustomer(long customer) {
        return repository.findAllByCustomer(customer);}


    public Invoice getById(long id) {
        Optional<Invoice> date = repository.findById(id);
        if (date.isPresent()) return date.get();
        return null;
    }

    public Invoice add(Invoice data) {
        return repository.save(data);
    }

    public Invoice update(Invoice data) throws DataNotFoundException {
        Invoice oldData = getById(data.getId());

        if (oldData == null) {
            throw new DataNotFoundException("data with " + data.getId() + " not found ");
        }

        oldData.setInvoicePayed(data.getInvoicePayed());
        return repository.save(oldData);
    }

    public boolean delete(long id) throws DataNotFoundException {
        Invoice del = getById(id);
        if (del == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        repository.deleteById(id);
        return true;
    }



}
