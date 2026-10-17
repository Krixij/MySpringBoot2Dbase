package ru.kutorov.MySpringBoot2Dbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kutorov.MySpringBoot2Dbase.entity.Discipline;
import ru.kutorov.MySpringBoot2Dbase.service.DisciplineService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/disciplines")
    public ResponseEntity<List<Discipline>> allDisciplines() {
        List<Discipline> allDisciplines = disciplineService.getAllDisciplines();
        return ResponseEntity.ok(allDisciplines);
    }

    @GetMapping("/disciplines/{id}")
    public ResponseEntity<Discipline> getDiscipline(@PathVariable("id") int id) {
        Discipline discipline = disciplineService.getDiscipline(id);
        if (discipline == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(discipline);
        }
    }

    @PostMapping("/disciplines")
    public ResponseEntity<Discipline> saveDiscipline(@RequestBody Discipline discipline) {
        Discipline savedDiscipline = disciplineService.saveDiscipline(discipline);
        return ResponseEntity.status(201).body(savedDiscipline);
    }

    @PutMapping("/disciplines")
    public ResponseEntity<Discipline> updateDiscipline(@RequestBody Discipline discipline) {
        Discipline existingDiscipline = disciplineService.getDiscipline(discipline.getId());
        if (existingDiscipline != null) {
            return ResponseEntity.ok(disciplineService.saveDiscipline(discipline));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/disciplines/{id}")
    public ResponseEntity<String> deleteDiscipline(@PathVariable("id") int id) {
        boolean isDeleted = disciplineService.deleteDiscipline(id);
        if (isDeleted) {
            return ResponseEntity.ok("Дисциплина успешно удалена с id: " + id);
        } else {
            return ResponseEntity.status(404).body("Дисциплина с id: " + id + " не найдена");
        }
    }
}
