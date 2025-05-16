package com.example.sof3012.repository;

import com.example.sof3012.entity.Category1;
import com.example.sof3012.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepository {
    // CRUD
    // Java 3: Select * from category => Connection
    // Java 4: Truy van tren thuc the: tren class: from Category1 => Sesstion
    private Session s;

    public CategoryRepository() {
        // Khoi tao session
        s = HibernateUtil.getFACTORY().openSession();
    }

    // Get all: Select * from table
    public List<Category1> getAll() {
        return s.createQuery("FROM Category1 ").list();
    }

    public Category1 getOne(Long id) {
        return s.find(Category1.class, id);
    }

    public void add(Category1 cate){
        try{
            // Bat dau 1 transation: duy tri tinh toan ven cho chuc nang
            s.getTransaction().begin();
            // Them phan tu
            s.persist(cate);
            // commit du lieu
            s.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }

    public void update(Category1 cate){
        try{
            // Bat dau 1 transation: duy tri tinh toan ven cho chuc nang
            s.getTransaction().begin();
            // Them phan tu
            s.merge(cate);
            // commit du lieu
            s.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }

    public void delete(Category1 cate){
        try{
            // Bat dau 1 transation: duy tri tinh toan ven cho chuc nang
            s.getTransaction().begin();
            // Them phan tu
            s.delete(cate);
            // commit du lieu
            s.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }
    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getAll());
    }

}
