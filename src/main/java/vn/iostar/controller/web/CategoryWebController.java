package vn.iostar.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/category")
public class CategoryWebController {

    @GetMapping("/ajax")
    public String categoryAjaxPage() {
        // Trả về file ajax.jsp nằm trong views
        return "admin/category/ajax"; 
    }
}