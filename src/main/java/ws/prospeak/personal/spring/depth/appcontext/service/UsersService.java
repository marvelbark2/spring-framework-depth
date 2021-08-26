package ws.prospeak.personal.spring.depth.appcontext.service;

import org.springframework.stereotype.Service;
import ws.prospeak.personal.spring.depth.appcontext.aspect.softdelete.SoftDelete;
import ws.prospeak.personal.spring.depth.appcontext.domain.Users;

import java.util.Arrays;
import java.util.List;

@Service
@SoftDelete
public class UsersService {
    private static final  List<Users> USERS = Arrays.asList(
            new Users(1L, "Youness"),
            new Users(2L, "Salim")
    );

    public List<Users> all() {
        return USERS;
    }

    public Users findUser(long id) {
        return USERS.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public void deleteUser(long id) {
        for (Users u : USERS) {
            if(u.getId() == id)
                u.deleteIt();
        }
    }
}
