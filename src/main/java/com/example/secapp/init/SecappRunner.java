package com.example.secapp.init;

import com.example.secapp.product.Product;
import com.example.secapp.product.ProductRepository;
import com.example.secapp.user.*;
import com.github.javafaker.Faker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static com.example.secapp.user.Authorization.READ;
import static com.example.secapp.user.Authorization.WRITE;

/**
 * SecappRunner
 * initailiza database
 */

 @Component
public class SecappRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(SecappRunner.class);

    @Autowired
    private ProductRepository prodRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AuthorityRepo authorityRepo;


    @Override
    public void run(String... args) throws Exception {
        double min = 10d;
        double max = 100d;

        prodRepo.deleteAll();
        userRepo.deleteAll();

        for (int i = 0; i < 20; i++) {
            Product p = new Product();
            Faker f = new Faker();
            double price = 0d;

            p.setName(f.commerce().productName());
            price = min + (f.random().nextDouble() * (max - min));
            price = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP).doubleValue();
            p.setPrice(price);
            
            prodRepo.save(p);
        }

        Account acc = new Account();
        Authority authority = new Authority();
        Authority authority2 = new Authority();
        List<Authority> authorities = new ArrayList<>();

        acc.setUsername("john");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        acc.setPassword(encoder.encode("password"));
        acc.setEnabled(true);
        userRepo.save(acc);

//READ, WRITE, EXECUTE
///hash map

        authority.setName(READ.getAuth());
        authority.setAccount(acc);
        authorityRepo.save(authority);

        authority2.setName(WRITE.getAuth());
        authority2.setAccount(acc);
        authorityRepo.save(authority2);

    }

}
