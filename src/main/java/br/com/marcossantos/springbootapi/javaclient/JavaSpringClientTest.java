package br.com.marcossantos.springbootapi.javaclient;

import java.util.Arrays;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.marcossantos.springbootapi.model.PageableResponse;
import br.com.marcossantos.springbootapi.model.Student;

public class JavaSpringClientTest {
  public static void main(String[] args) {
    RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:808/vi/protected/students")
        .basicAuthentication("mawe", "pass").build();
    RestTemplate restTemplateAdmin = new RestTemplateBuilder().rootUri("http://localhost:808/vi/admin/students")
        .basicAuthentication("admin", "pass").build();
    System.setProperty("proxyHost", "yourproxy.server.com");
    System.setProperty("proxyPort", "8080");
    System.out.println(restTemplate.getMessageConverters());

    Student student = restTemplate.getForObject("/{id}", Student.class, 1);
    System.out.println(student);

    Student[] students = restTemplate.getForObject("/", Student[].class);
    System.out.println(Arrays.toString(students));

    ResponseEntity<PageableResponse<Student>> exchange = restTemplate.exchange("/?sort=id,desc", HttpMethod.GET, null,
        new ParameterizedTypeReference<PageableResponse<Student>>() {
        });
    System.out.println(exchange);

    Student studentPost = new Student();
    studentPost.setName("John Wick");
    studentPost.setEmail("john@pencil.com");

    ResponseEntity<Student> exchangePost = restTemplateAdmin.exchange("/", HttpMethod.POST,
        new HttpEntity<Student>(studentPost, createJSONHeaders()), Student.class);
    Student studentPostForObject = restTemplateAdmin.postForObject("/", studentPost, Student.class);
    System.out.println(exchangePost);
    System.out.println(studentPostForObject);
  }

  private static HttpHeaders createJSONHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return headers;
  }
}