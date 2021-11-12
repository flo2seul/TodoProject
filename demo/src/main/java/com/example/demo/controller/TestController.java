package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test") //resource
public class TestController {
    @GetMapping
    public String testController(){
        return "Hello World";
    }
    @GetMapping("/testGetMapping")
    public String testControllerWithPath(){
        return "Hello World! testGetMapping";
    }
    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) String id) {
        return "Hello World ID " + id;
    }
    @GetMapping("/testRequestParam")
    public String testControllRequestParam(@RequestParam(required = false) int id) {
        return "Hello world! ID " + id;
    }
    // /test 경로는 이미 존재하므로 /test/testRequestBody로 지정했다.
    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        return "Hello World! ID " + testRequestBodyDTO.getId() + " Message : " + testRequestBodyDTO.getMessage();
    }
//    @GetMapping("/testResponseBody")
//    public ResponseDTO<String> testControllerResponseBody() {
//        List<String> list = new ArrayList<>();
//        list.add("Hello World! I'm ResponseDTO");
//        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
//        return response;
    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseEntity. And you got 400!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        //http status를 400으로 설정
        return ResponseEntity.ok().body(response);
    }

}