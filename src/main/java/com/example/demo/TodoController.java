package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {
    private List<TodoItem> todoItems;

    public TodoController() {
        this.todoItems = new ArrayList<>();
    }

    @GetMapping
    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    @PostMapping
    public void addTodoItem(@RequestBody TodoItem item) {
        todoItems.add(item);
    }

    @DeleteMapping("{id}")
    public void deleteTodoItem(@PathVariable("id") int id) {
        for (int i = 0; i < todoItems.size(); i++) {
            if(todoItems.get(i).id == id) {
                this.todoItems.remove(i);
            }
        }
    }
}