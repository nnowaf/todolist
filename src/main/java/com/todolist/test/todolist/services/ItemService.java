package com.todolist.test.todolist.services;

import com.todolist.test.todolist.dao.ItemDao;
import com.todolist.test.todolist.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemDao itemDao;

    public void createItem(ItemDto item) {
        itemDao.save(item);
    }

    public List<ItemDto> getItemsByChecklistId(Long checklistId) {
        return itemDao.findAllByChecklistId(checklistId);
    }

    public void deleteItem(Long id) {
        itemDao.deleteById(id);
    }
}
