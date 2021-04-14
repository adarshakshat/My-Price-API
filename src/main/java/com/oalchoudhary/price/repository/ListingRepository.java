package com.oalchoudhary.price.repository;
import com.oalchoudhary.price.model.Farmer;
import com.oalchoudhary.price.model.Listing;
import com.oalchoudhary.price.model.Product;
import com.oalchoudhary.price.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListingRepository {
    @Autowired
    private ProductRepository productRepository;
    public List<Listing> getlisting(){
        return ((List<Product>) productRepository
        .findAll()).stream().map(this::convertToListing).collect(Collectors.toList());
    }
    private Listing convertToListing(Product product) {
        Listing listing = new Listing();
        Farmer farmer = product.getFarmer();
        listing.setProduct_Name(product.getTitle());
        listing.setProduct_Price(product.getPrice());
        listing.setProduct_Quality(product.getQuality());
        listing.setProduct_Unit(product.getUnit());
        listing.setProduct_State(product.getStock());
        listing.setProduct_State(farmer.getState());
        listing.setProduct_District(farmer.getDistrict());
        listing.setProduct_Stock(product.getStock());
        listing.setFarmer_Name(farmer.getName());
        listing.setFarmer_Phone_Number(farmer.getPhone_number());
        listing.setFarmer_Whatsapp_Number(farmer.getWhatsapp_number());
        return listing;
     }
}
