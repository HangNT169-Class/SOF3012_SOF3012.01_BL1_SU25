package com.example.sof3012.servlet;

import com.example.sof3012.entity.Category1;
import com.example.sof3012.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CategoryServlet", value = {
        // liet ke tat ca cac duong dan
        // Duong dan la duy nhat
        // Bat dau cua duong dan
        "/category/hien-thi", // GET
        "/category/detail", // GET
        "/category/delete",// GET
        "/category/view-update", // GET
        "/category/update", // POST
        "/category/view-add", // GET
        "/category/add", // POST
        "/category/search", // GET
})
public class CategoryServlet extends HttpServlet {
    /**
     * GET: Con lai la get - Hien thi/ Lay ra...
     * POST: Xu ly form (dang nhap, add, update..)
     */
    private CategoryService cateService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 6 uri => viet trong do get
        // B1: Lay ra uri tren duong dan
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            // hien thi du lieu len table
            this.hienThiDuLieu(request, response);
        } else if (uri.contains("detail")) {
            this.detailDuLieu(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
        } else {
            this.search(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 2 uri viet trong do post
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.update(request, response);
        } else if (uri.contains("add")) {
            this.add(request, response);
        } else {
            // 404
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // B1: Lay gia tri tren duong
        String id = request.getParameter("id2");
        // B2: Goi cate
//        Category1 cate = cateService.getOne(Long.valueOf(id));
        // B3: Goi ham xoa
        cateService.delete(Long.valueOf(id));
        // B4: Quay tro lai trang ban dau
        response.sendRedirect("/category/hien-thi");
//        request.setAttribute("lists", cateService.getAll());
//        request.getRequestDispatcher("/buoi1/categorys.jsp").forward(request, response);

    }

    private void detailDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("a");
        Category1 cate = cateService.getOne(Long.valueOf(id));
        request.setAttribute("b",cate);
        request.getRequestDispatcher("/buoi1/detail-cate.jsp").forward(request, response);
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lists", cateService.getAll());
        request.getRequestDispatcher("/buoi1/categorys.jsp").forward(request, response);
    }

}
