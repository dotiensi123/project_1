package vn.co.your.dotiensi.Springboottutorial.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.co.your.dotiensi.Springboottutorial.springboot.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
