package charles.sc.provider.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by issuser on 2017/1/13.
 */
@Service
@ResponseBody
@RequestMapping("/privilege")
public class PrivilegeService {
    private Log log = LogFactory.getLog(PrivilegeService.class);

    @RequestMapping(value = "/pb", method = RequestMethod.GET)
    public List<User> query() {
        log.info("query all");
        return Arrays.asList(new User(1L, "account1", "password1"),
                new User(2L, "account2", "password2"),
                new User(3L, "account3", "password3"));
    }

    @RequestMapping(value = "/pv/{id}", method = RequestMethod.GET)
    public User query(@PathVariable Long id) {
        log.info("query by id");
        return new User(id, "account" + id, "password" + id);
    }

    @RequestMapping(value = "/pb/search", method = RequestMethod.POST)
    public List<User> query(@RequestBody User user) {
        log.info("query by example");
        return Arrays.asList(user);
    }

    @RequestMapping(value = "/pt", method = RequestMethod.POST)
    public User insert(@RequestBody User user) {
        log.info("insert");
        return user;
    }

    @RequestMapping(value = "/pt/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable Long id) {
        log.info("delete by id");
        return new User(id, "account" + id, "password" + id);
    }

    @RequestMapping(value = "/pt", method = RequestMethod.PUT)
    public User update(@RequestBody User user) {
        log.info("update");
        return user;
    }
}
