package com.carritodecompras.carrito.controller;

import com.carritodecompras.carrito.entity.Producto;
import com.carritodecompras.carrito.service.ProductoService;
import com.carritodecompras.carrito.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {


    @Autowired
    private ProductoService productoService;

    @Autowired
    private ShoppingCartService cartService;

    @GetMapping("/")
    public String index(Model model) {
        List<Producto> productos = productoService.listarProductos();
        model.addAttribute("productos", productos);
        return "home";
    }
}