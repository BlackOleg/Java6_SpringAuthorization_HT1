package olegivanov.controller;

import olegivanov.model.Authorities;
import olegivanov.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;
    @Value("${server.port}")
    private int prt;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello from port: " + prt;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}
