package ru.kutorov.MySpringBoot2Dbase.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kutorov.MySpringBoot2Dbase.dao.DisciplineDAO;
import ru.kutorov.MySpringBoot2Dbase.entity.Discipline;

import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService{
    @Autowired
    private DisciplineDAO disciplineDAO;

    @Override
    @Transactional
    public List<Discipline> getAllDisciplines() {
        return disciplineDAO.getAllDisciplines();
    }

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline) {
        return disciplineDAO.saveDiscipline(discipline);
    }

    @Override
    @Transactional
    public Discipline getDiscipline(int id) {
        return disciplineDAO.getDiscipline(id);
    }

    @Override
    @Transactional
    public boolean deleteDiscipline(int id) {
        Discipline discipline = disciplineDAO.getDiscipline(id);
        if (discipline == null) {
            return false;
        }
        disciplineDAO.deleteDiscipline(id);
        return true;
    }
}
