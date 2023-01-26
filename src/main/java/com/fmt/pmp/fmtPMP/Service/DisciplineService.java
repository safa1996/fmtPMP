package com.fmt.pmp.fmtPMP.Service;

import java.util.List;

import com.fmt.pmp.fmtPMP.Model.Discipline;

public interface  DisciplineService {
    List<Discipline> getAllDisciplines();
    Discipline getDisciplineById(int DisciplineId);
    boolean createDiscipline(Discipline Discipline);
    void updateDiscipline(Discipline Discipline);
    void deleteDiscipline(int DisciplineId);
}
