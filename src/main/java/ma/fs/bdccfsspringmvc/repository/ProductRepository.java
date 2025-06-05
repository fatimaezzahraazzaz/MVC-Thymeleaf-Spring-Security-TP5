package ma.fs.bdccfsspringmvc.repository;

import ma.fs.bdccfsspringmvc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
