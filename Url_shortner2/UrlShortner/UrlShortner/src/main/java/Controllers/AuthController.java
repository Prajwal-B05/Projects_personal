package Controllers;

import com.url.UrlShortner.DTO.RegisterRequest;
import com.url.UrlShortner.Models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {


    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest registerRequest)
    {
        return "success";
    }
}
