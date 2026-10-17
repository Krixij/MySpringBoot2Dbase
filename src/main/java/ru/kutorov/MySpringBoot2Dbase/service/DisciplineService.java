package ru.kutorov.MySpringBoot2Dbase.service;

import org.springframework.stereotype.Service;
import ru.kutorov.MySpringBoot2Dbase.entity.Discipline;

import java.util.List;

@Service
public interface DisciplineService {
    List<Discipline> getAllDisciplines();
    Discipline saveDiscipline(Discipline discipline);
    Discipline getDiscipline(int id);
    boolean deleteDiscipline(int id);
}
