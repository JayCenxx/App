package com.example.restconsume.RestTemplate;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class consumer {
    public static final String getAll = "http://localhost/api/employees";
    public static final String getById = "http://localhost/api/employees/{id}";
    public static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        delete();
    }

    public static void getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<List<Employee>> exchange = restTemplate.exchange(getAll, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
        });

        List<Employee> body = exchange.getBody();
        System.out.println(body);

    }


    public static void getById() {
    int id=2;
        //read url=getById,  employee class, and the id key-value
        Employee employee = restTemplate.getForObject(getAll +"/" + id  ,Employee.class );
        System.out.println(employee.getFirstName());
    }
    public static void saveARow(){
        Employee employee = new Employee("May", "Cen", 30);
        ResponseEntity<Employee> employeeEntity = restTemplate.postForEntity("http://localhost/api/employees", employee, Employee.class);

        System.out.println(employeeEntity);
    }

    public static void updateARow() {
        Map<String, Integer> map = new HashMap<>();
        Employee employee = new Employee(1,"Oct", "Cen", 40);
        restTemplate.put("http://localhost/api/employees", employee);

    }

    public static void delete() {
        int id=15;
        restTemplate.delete("http://localhost/api/employees/"+ id);

    }

    public static void test(){


    }


}
