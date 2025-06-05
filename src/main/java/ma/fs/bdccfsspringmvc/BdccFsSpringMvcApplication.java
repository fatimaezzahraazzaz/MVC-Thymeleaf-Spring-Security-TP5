package ma.fs.bdccfsspringmvc;

import ma.fs.bdccfsspringmvc.entities.Product;
import ma.fs.bdccfsspringmvc.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class BdccFsSpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdccFsSpringMvcApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(5400)
                    .quantity(12)
                    .build());

            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1200)
                    .quantity(8)
                    .build());

            productRepository.save(Product.builder()
                    .name("Smartphone")
                    .price(3200)
                    .quantity(15)
                    .build());

            productRepository.findAll().forEach(System.out::println);
        };
    }
}
