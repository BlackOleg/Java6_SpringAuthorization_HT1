package olegivanov;

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
//            new ImageFromDockerfile().withDockerfile(Paths.get("./Dockerfile")))
            .withExposedPorts(8080)
            .withEnv("SERVER_PORT", "8080");
 //           .withEnv("SERVER_ADDRESS", "localhost");

    private static final GenericContainer<?> prodApp = new GenericContainer<>("prodapp")
//            new ImageFromDockerfile().withDockerfile(Paths.get("./Dockerfile")))
            .withExposedPorts(8081)
            .withEnv("SERVER_PORT", "8081");
 //           .withEnv("SERVER_ADDRESS", "localhost")

    @BeforeAll

    public static void setUp() {
      // здесь ошибка,  если раскоментить
        devApp.start();
        prodApp.start();
    }

    @Test
    void contextLoads() {
//        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + devApp.getMappedPort(8080), String.class);
//        System.out.println(forEntity.getBody());
//        Integer devPort = devApp.getMappedPort(8080);
//        Integer devExpected = 8080;
//        Assertions.assertEquals(devExpected, devPort);
//        Integer prodPort = prodApp.getMappedPort(8081);
//        Integer prodExpected = 8081;
//        Assertions.assertEquals(prodExpected, prodPort);

    }

}
