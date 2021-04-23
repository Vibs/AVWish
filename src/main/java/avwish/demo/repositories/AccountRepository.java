package avwish.demo.repositories;

import avwish.demo.models.account.AuthenticateResponse;
import avwish.demo.models.db.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AccountRepository extends JpaRepository<Account, Integer> {
    
    // @Query("SELECT user FROM User user WHERE user.email = ?1 AND user.password = ?2")
    
    // TODO
    @Query("SELECT account FROM Account account WHERE account.email = ?1") // AND account.passwordHash = ?2")
    Account authenticate(String email, String password);


}
