package com.todolist.test.todolist.services;

import com.todolist.test.todolist.dao.CheckListDao;
import com.todolist.test.todolist.dto.CheckListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckListService {

    @Autowired
    private CheckListDao checkListDao;

    public void createChecklist(CheckListDto checklist) {
        checkListDao.save(checklist);
    }

    public List<CheckListDto> getChecklistsByUserId(Long userId) {
        return checkListDao.findAllByUserId(userId);
    }

    public void deleteChecklist(Long id) {
        checkListDao.deleteById(id);
    }
}
