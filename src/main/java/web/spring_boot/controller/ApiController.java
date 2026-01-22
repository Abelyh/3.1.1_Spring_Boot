package web.spring_boot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api/health")
    public String health() {
        return "{\"status\": \"OK\", \"version\": \"Spring Boot 4.0.2\"}";
    }

    @GetMapping("/api/time")
    public String time() {
        return "{\"time\": \"" + java.time.LocalDateTime.now() + "\"}";
    }
}
