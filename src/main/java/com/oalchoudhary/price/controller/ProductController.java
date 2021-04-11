package com.oalchoudhary.price.controller;
import com.oalchoudhary.price.model.Listing;
import com.oalchoudhary.price.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import com.oalchoudhary.price.exception.ResourceNotFoundException;
import com.oalchoudhary.price.model.Product;
import com.oalchoudhary.price.repository.ProductRepository;
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    FarmerRepository farmerRepository;
    //returns all the products, this is automatically done by spring
    @Autowired
    private ListingRepository listingRepository;
    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    /*This is to create a product, spring provides us a function save*/
    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/listing")
    @ResponseBody
    public List<Listing> getlisting(){
        List <Listing> listings = new ArrayList<>();
        listings = listingRepository.getlisting();
        return listings;
    }

    /* Newly copied from URL
    https://www.javaguides.net/2019/08/spring-boot-jpa-hibernate-one-to-many-example-tutorial.html
     */
    @PostMapping("farmers/{farmerId}/products/{productId}")
    public Product CreateProduct(@PathVariable(value = "farmerId")Long farmerId,
                                 @Valid @RequestBody Product product) throws ResourceNotFoundException{
        return farmerRepository.findById(farmerId).map(farmer -> {
            product.setFarmer(farmer);
            return productRepository.save(product);
        }).orElseThrow(()->new ResourceNotFoundException("product","id",product));
    }

    /* This part is to search products by id, Exception hanlding is also done*/
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable(value = "id") Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable(value = "id") Long productId,
                           @Valid @RequestBody Product productDetails) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

        product.setTitle(productDetails.getTitle());
        product.setPrice(productDetails.getPrice());

        Product updatedProduct = productRepository.save(product);
        return updatedProduct;
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }

}
