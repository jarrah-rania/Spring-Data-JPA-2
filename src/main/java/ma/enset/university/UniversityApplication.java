package ma.enset.university;

import ma.enset.university.entities.Product;
import ma.enset.university.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      //  productRepository.save(new Product(null, "Computer", 4300, 3));
      //  productRepository.save(new Product(null, "Printer", 1200, 7));
      //  productRepository.save(new Product(null, "Smart Phone", 15000, 43));

        System.out.println("=== Produits dans la base ===");
        List<Product> products = productRepository.findAll();
        products.forEach(p -> {
            System.out.println(p.toString());
        });
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("******************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("******************");
        List<Product> productList=productRepository.findByNameContains("C");
        productList.forEach((p->
        {
            System.out.println(p);
        }));
       /* System.out.println("----------------------------");
        List<Product> productList2=productRepository.search("%C%");
        productList2.forEach((p->
        {
            System.out.println(p);
        }));*/

     /*System.out.println("----------------------------");
        List<Product> productList3=productRepository.findByPriceGreaterThan(3000);
        productList3.forEach((p->
        {
            System.out.println(p);
        }));*/

        System.out.println("----------------------------");
        List<Product> productList3=productRepository.searchByPrice(3000);
        productList3.forEach((p->
        {
            System.out.println(p);
        }));



    }
}
