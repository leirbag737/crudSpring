package com.gabriel.crudspring.controller;

import com.gabriel.crudspring.dto.CourseDTO;
import com.gabriel.crudspring.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public @ResponseBody List<CourseDTO> list(){
        return courseService.list();
    }

    @GetMapping("/{id}")
    public CourseDTO findById(@PathVariable @NotNull @Positive Long id){
        return courseService.findById(id); // se o optional não vir nulo ele retorna o course, caso nulo retorna 404
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CourseDTO create(@RequestBody @Valid CourseDTO course){
        return courseService.create(course);
    }


    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid @NotNull CourseDTO course){
        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @NotNull @Positive Long id){
        courseService.delete(id);
    }

}
