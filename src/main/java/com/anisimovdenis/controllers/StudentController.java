package com.anisimovdenis.controllers;

import com.anisimovdenis.entities.Student;
import com.anisimovdenis.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable Long id) {
        Optional<Student> optionalStudent = studentService.getStudentById(id);
        if (optionalStudent.isEmpty()) {
            return "redirect:/students";
        }
        model.addAttribute("student", optionalStudent.get());
        return "student_edit";
    }

    @PostMapping("/edit")
    public String saveEditedStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "student_edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteOneProductById(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }
}
