package com.example.demo.controller;

import com.example.demo.model.TodoItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private List<TodoItem> todoItems;

    public TodoController() {
        this.todoItems = new ArrayList<>();
    }

    @GetMapping
    public ResponseEntity<Object> getTodoItems() {
        return ResponseEntity.ok().body(todoItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTodoItem(@PathVariable("id") int id) {
        TodoItem item = null;
        for (int i = 0; i < todoItems.size(); i++) {
            if(todoItems.get(i).id == id) {
                item = todoItems.get(i);
            }
        }
        if (item == null) {
            return ResponseEntity.badRequest().body("id bestaat niet");
        }
        else {
            return ResponseEntity.ok().body(item);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addTodoItem(@RequestBody TodoItem item) {
        todoItems.add(item);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTodoItem(@PathVariable("id") int id) {

        boolean foundItem = false;
        for (int i = 0; i < todoItems.size(); i++) {
            if(todoItems.get(i).id == id) {
                this.todoItems.remove(i);
                foundItem = true;
            }
        }

        if (!foundItem) {
            return ResponseEntity.badRequest().body("id bestaat niet");
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }
}