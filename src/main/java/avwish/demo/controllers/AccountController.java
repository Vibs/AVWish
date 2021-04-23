package avwish.demo.controllers;

import avwish.demo.models.account.Authenticate;
import avwish.demo.models.account.AuthenticateResponse;
import avwish.demo.models.db.Account;
import avwish.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api")
public class AccountController {
    
    @Autowired
    AccountRepository accoountRepository;
    
    // Todo ret lige at den ikke returner en String men en AuthToken-ting
    // Todo ret også i repo
    @CrossOrigin
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticateResponse> login(@RequestBody Authenticate auth){
        
        Optional<Account> optionalAccount = Optional.ofNullable(accoountRepository.authenticate(auth.getEmail(),
                auth.getPassword()));
    
        return optionalAccount.map(account -> new ResponseEntity<>(
                new AuthenticateResponse("" + account.getId(), 1),
                HttpStatus.OK
        )).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED));
    
    }
    
    // TODO gør så den sender en AccountResponse tilbage
    @GetMapping("/account")
    public ResponseEntity<Account> sendAccount(@RequestHeader HttpHeaders header){
        
        // TODO lav en generel ting hvor jeg henter tokenet ud
        String token = header.getFirst(HttpHeaders.AUTHORIZATION);
        
        
        int id = Integer.parseInt(token.substring(token.length()-1));
        System.out.println(id);
        
        
        Optional<Account> optAccount = accoountRepository.findById(id);
    
        return optAccount.map(account -> new ResponseEntity<>(account,
                HttpStatus.OK
        )).orElseGet(() -> new ResponseEntity<>(null,
                HttpStatus.NOT_FOUND
        ));
    }
    
    
    
    
    
}
