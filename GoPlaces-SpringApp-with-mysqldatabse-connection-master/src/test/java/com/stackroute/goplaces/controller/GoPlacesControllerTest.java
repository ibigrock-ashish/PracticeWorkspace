package com.stackroute.goplaces.controller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.goplaces.Main;
import com.stackroute.goplaces.domain.Places;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoPlacesControllerTest {
    String user1;
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    Places places;
    @Before
    public void setUp() throws Exception {
         places = new Places();
         places.setId(01);
         places.setAddress("koaramanagala");
         places.setImageurl("im.jpg");
         places.setName("Av1 rest");
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testSaveUser() throws Exception {
        HttpEntity<Places> entity = new HttpEntity<Places>(places, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/create"),
                HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Places saved Successfully",actual);
    }
    @Test
    public void testList() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/create"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);
    }
    @Test
    public void testGetUser() throws Exception {
    }
    @Test
    public void testUpdateUser() throws Exception {
    }
    @Test
    public void testDeleteUser() throws Exception {
    }
}