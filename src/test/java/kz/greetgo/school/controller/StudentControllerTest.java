package kz.greetgo.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class StudentControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHomePage() throws Exception {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/", String.class);
        HttpStatus expected = HttpStatus.OK;
        HttpStatus actual = entity.getStatusCode();
        Assert.assertEquals(actual, expected);
    }

}