package com.carritodecompras.carrito.controller;

import com.carritodecompras.carrito.entity.Producto;
import com.carritodecompras.carrito.service.ProductoService;
import com.carritodecompras.carrito.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carrito")
public class ShoppingCartController {

        @Autowired
        private ShoppingCartService carritoService;

        @Autowired
        private ProductoService productoService;

        @GetMapping
        public String verCarrito(Model model) {
            model.addAttribute("items", carritoService.getItems());
            model.addAttribute("total", carritoService.calcularTotal());
            return "ShoppingCart/carrito";
        }

        @GetMapping("/agregar/{id}")
        public String agregarAlCarrito(@PathVariable Long id) {
            Producto producto = productoService.obtenerPorId(id);
            if (producto != null) {
                carritoService.agregarProducto(producto, 1);
            }
            return "redirect:/";
        }

        @GetMapping("/eliminar/{id}")
        public String eliminarDelCarrito(@PathVariable Long id) {
            carritoService.eliminarProducto(id);
            return "redirect:/carrito";
        }

        @GetMapping("/vaciar")
        public String vaciarCarrito() {
            carritoService.vaciarCarrito();
            return "redirect:/carrito";
        }
    }
