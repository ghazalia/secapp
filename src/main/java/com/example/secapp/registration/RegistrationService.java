package com.example.secapp.registration;

import com.example.secapp.user.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AuthorityRepo authorityRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger log = LoggerFactory.getLogger(RegistrationService.class);

    public void saveNew(AccountDto accountDto) throws Exception
    {
        if (userRepo.findByUsername(accountDto.getUsername()).isPresent()) {
            throw  new Exception("Email is already in use");
        }

        final String encryptedPassword = passwordEncoder.encode(accountDto.getPassword());

        log.info("generated: ", encryptedPassword);

        Account acc = new Account();
        acc.setUsername(accountDto.getUsername());
        acc.setPassword(encryptedPassword);
        acc.setEnabled(true);
        userRepo.save(acc);

        Authority authority = new Authority();
        authority.setName(Authorization.READ.getAuth());
        authority.setAccount(acc);
        authorityRepo.save(authority);
    }
}
