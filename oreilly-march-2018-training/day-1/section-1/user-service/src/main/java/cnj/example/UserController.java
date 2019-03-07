package cnj.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/v1")
public class UserController {

    private final UserRepository userRepository;
    
    private final String projectName;

    public UserController(UserRepository userRepository,@Value("${configuration.projectName}") String pn) {
        this.userRepository = userRepository;
        this.projectName = pn;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    
    @GetMapping("/project-name")
    public String getProjectName() {
        return this.projectName;
    }
}
