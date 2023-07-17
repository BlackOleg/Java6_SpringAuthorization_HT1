package olegivanov.repository;

import olegivanov.model.Authorities;
import olegivanov.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final static ConcurrentHashMap<Users, List<Authorities>> repositoryMap = new ConcurrentHashMap<>();


    public List<Authorities> getUserAuthorities(String user, String password) {
        Users checkUser = new Users(user, password);
        return repositoryMap.get(checkUser);
    }

}