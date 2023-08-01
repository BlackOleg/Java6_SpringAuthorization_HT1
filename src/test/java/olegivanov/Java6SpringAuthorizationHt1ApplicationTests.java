package olegivanov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Java6SpringAuthorizationHt1ApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;
    @Container
    private static final GenericContainer devApp = new GenericContainer<>("devapp")
            .withExposedPorts(8080);
    @Container
    private static final GenericContainer prodApp = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        //todo
        devApp.start(); // контейнеры не стартуют. Проблема здесь!
        prodApp.start();
    }

    @Test
    void contextLoads() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + devApp.getMappedPort(8080), String.class);
        System.out.println(forEntity.getBody());
        Integer devPort = devApp.getMappedPort(8080);
        Integer devExpected = 8080;
        Assertions.assertEquals(devExpected, devPort);
        Integer prodPort = prodApp.getMappedPort(8081);
        Integer prodExpected = 8081;
        Assertions.assertEquals(prodExpected, prodPort);

    }

}
