package com.example.sof3012.service;

import com.example.sof3012.entity.Category1;
import com.example.sof3012.repository.CategoryRepository;

import java.util.List;

public class CategoryService {
    //    servlet => service => repository
    private CategoryRepository repository = new CategoryRepository();

    public List<Category1> getAll() {
        return repository.getAll();
    }

    public Category1 getOne(Long id) {
        return repository.getOne(id);
    }

    public void add(Category1 cate) {
        repository.add(cate);
    }

    public void update(Category1 cate) {
        repository.update(cate);
    }

    public void delete(Long id) {
        repository.delete(getOne(id));
    }

}
