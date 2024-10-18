package co.mercadolibre.SocialMeli.utils;

import co.mercadolibre.SocialMeli.dto.ProductDTO;
import co.mercadolibre.SocialMeli.entity.Product;
import co.mercadolibre.SocialMeli.entity.User;
import co.mercadolibre.SocialMeli.exception.NotFoundException;
import co.mercadolibre.SocialMeli.repository.IProductRepository;
import co.mercadolibre.SocialMeli.repository.IUsersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GlobalMethods {
    @Autowired
    IUsersRepository iUsersRepository;
    @Autowired
    IProductRepository iProductRepository;

    public User getUserById(int userId){
        return iUsersRepository.findAllUsers().stream().filter(entry -> entry.getUserId() == userId).findFirst().orElse(null);
    }

    public boolean isNotSeller(User seller){
        return seller.getPosts().isEmpty();
    }

    public boolean verifyProduct(Product product) {
        List<Product> productFound = iProductRepository.findAllProducts().stream()
                .filter(p -> p.equals(product)).toList();
        return !(productFound.isEmpty());
    }

    public int getNewPostId(User user){
        return user.getPosts().size() + 1;
    }


}
