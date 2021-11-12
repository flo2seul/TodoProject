package com.example.demo.controller;

import com.example.demo.dto.TodoDTO;
import com.example.demo.model.TodoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {
    //todo 메서드 작성하기
    @GetMapping("/TodoEntity")
    public ResponseEntity testTodo() {
//        List<String> list = new ArrayList<>();
//        list.add("todo test");
        TodoDTO response = new TodoDTO("test","test",true);
        return ResponseEntity.ok().body(response);

    }
}
