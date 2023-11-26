package com.ecommerce.customer.controller;

import com.ecommerce.library.dto.CategoryDto;
import com.ecommerce.library.dto.ProductDto;
import com.ecommerce.library.model.Category;
import com.ecommerce.library.service.CategoryService;
import com.ecommerce.library.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    private final CategoryService categoryService;

    @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("page", "Sản phẩm");
        model.addAttribute("title", "Danh sách sản phẩm");
        List<Category> categories = categoryService.findAllByActivatedTrue();
        List<ProductDto> products = productService.products();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "index";
    }


    @GetMapping("/product-detail/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        ProductDto product = productService.getById(id);
        List<ProductDto> productDtoList = productService.findAllByCategory(product.getCategory().getName());
        model.addAttribute("products", productDtoList);
        model.addAttribute("title", "Chi tiết sản phẩm");
        model.addAttribute("page", "Chi tiết sản phẩm");
        model.addAttribute("productDetail", product);
        return "product-detail";
    }

}
