package com.sub.learner.jpamultipleds;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.sub.learner.jpamultipleds.dao.product.ProductRepository;
import com.sub.learner.jpamultipleds.dao.user.UserRepository;
import com.sub.learner.jpamultipleds.model.product.Product;
import com.sub.learner.jpamultipleds.model.user.User;

@SpringBootTest
@EnableTransactionManagement
public class JpaMultipleDbTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional("userTransactionManager")
    public void whenCreatingUser_thenCreated() {

        User user = new User();
        user.setName("John");
        user.setEmail("john@test.com");
        user.setAge(20);
        user = userRepository.save(user);

        assertTrue(userRepository.findById(user.getId()).isPresent());
    }

    // @Test
    // @Transactional("userTransactionManager")
    // public void whenCreatingUserWithSameEmail_thenRollback() {

    //     User user1 = new User();
    //     user1.setName("John");
    //     user1.setEmail("john@test.com");
    //     user1.setAge(20);
    //     user1 = userRepository.save(user1);

    //     System.out.println("1:" + user1.getId());

    //     User user2 = new User();
    //     user2.setName("Tom");
    //     user2.setEmail("john@test.com");
    //     user2.setAge(22);
    //     try {
    //         user2 = userRepository.save(user2);
    //         System.out.println("2:" + user2.getId());
    //     } catch (DataIntegrityViolationException ex) {
    //     }

    //     assertTrue(userRepository.findById(user2.getId()).isEmpty());
    // }

    @Test
    @Transactional("productTransactionManager")
    public void whenCreatingProduct_thenCreated() {

        Product product = new Product();
        product.setName("Book");
        product.setId(2);
        product.setPrice(20);
        product = productRepository.save(product);

        assertNotNull(product);
    }

}
