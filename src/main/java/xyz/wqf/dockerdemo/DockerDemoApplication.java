package xyz.wqf.dockerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
public class DockerDemoApplication {
    private final static Logger log = LoggerFactory.getLogger(DockerDemoApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(DockerDemoApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("\n--+---+---+---+---+---+---+---+---+---+---+--\n" +
                "Application is running! Access URLs:\n" +
                "\tLocal:\thttp://localhost:{}\n" +
                "\tExternal:\thttp://{}:{}\n" +
                "--+---+---+---+---+---+---+---+---+---+---+--",
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }

    @GetMapping("/hello")
    public String hello(){
        return "world";
    }
}
