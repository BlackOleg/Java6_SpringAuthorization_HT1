package olegivanov;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.startupcheck.OneShotStartupCheckStrategy;
import org.testcontainers.images.builder.ImageFromDockerfile;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import java.nio.file.Paths;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Java6SpringAuthorizationHt1ApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;

    private static final GenericContainer<?> devApp = new GenericContainer<>("devapp")
            .withExposedPorts(8080)
            .withEnv("SERVER_PORT", "8080");
// new ImageFromDockerfile().withDockerfile(Paths.get("./Dockerfile"))


    private static final GenericContainer<?> prodApp = new GenericContainer<>("prodapp")
            .withExposedPorts(8081)
            .withEnv("SERVER_PORT", "8081");
//             .withEnv("SERVER_ADDRESS", "localhost")

    @BeforeAll
    public static void setUp() {
        devApp.start();
        prodApp.start();

    }

    @AfterAll
    public static void closeUp() {
        devApp.close();
        prodApp.close();
    }

    @Test
    void contextLoadsDev() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + devApp.getMappedPort(8080), String.class);
        System.out.println(forEntity.getBody());
        String actualBody = forEntity.getBody();
        Assertions.assertEquals("Hello from port: 8080", actualBody);
    }

    @Test
    void contextLoadsProd() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + prodApp.getMappedPort(8081), String.class);
        System.out.println(forEntity.getBody());
        String actualBody = forEntity.getBody();
        Assertions.assertEquals("Hello from port: 8081", actualBody);
    }

}
