package com.atharvapuranik.zenquest.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class todoControllerJpa {


    private todoService todoService;

    private TodoRepository todoRepository;

    public todoControllerJpa(todoService todoService,TodoRepository todoRepository){
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }


    @RequestMapping("list-todos")
    public String listTodos(ModelMap model){
        String username = (String)model.get("name");
        List <ToDo> todos = todoRepository.findByUsername(username);
        model.addAttribute("todos",todos);
        return "listTodos";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap modelMap){
        String username = (String)modelMap.get("name");
        ToDo todo = new ToDo(0,username,"",LocalDate.now().plusDays(1),false);
        modelMap.put("todo",todo);
        return "newTodo";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String AddNewTodo(ModelMap modelMap, @ModelAttribute("todo") @Valid ToDo todo, BindingResult result){
        if (result.hasErrors()){
            return "newTodo";
        }

        String username = (String)modelMap.get("name");
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id){
            todoRepository.deleteById(id);
            return "redirect:list-todos";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int  id, ModelMap model) {
        ToDo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "updateTodo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(@Valid ToDo todo, BindingResult result, ModelMap modelMap){
        if(result.hasErrors()){
            return "updateTodo";
        }
        String username = (String)modelMap.get("name");
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

}
