package com.carritodecompras.carrito.controller;

import com.carritodecompras.carrito.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        return "index";
    }
}