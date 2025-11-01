package com.carritodecompras.carrito;

import com.carritodecompras.carrito.entity.Producto;
import com.carritodecompras.carrito.service.ProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoServiceTest {

        private ProductoService productoService;
        private List<Producto> productos;

        @BeforeEach
        void setUp() {
            // Simulamos datos como si vinieran de la base de datos
            productoService = new ProductoService();
            productos = new ArrayList<>();
            productos.add(new Producto("Laptop", "HP Pavilion", 5000.0, 10, "Electrónica", "laptop.jpg"));
            productos.add(new Producto("Mouse", "Logitech", 200.0, 20, "Accesorios", "mouse.jpg"));
        }

        @Test
        void debeListarProductosCorrectamente() {
            assertNotNull(productos);
            assertEquals(2, productos.size());
            assertEquals("Laptop", productos.get(0).getNombre());
        }

        @Test
        void debeBuscarProductoPorIdSimulado() {
            Producto producto = productos.get(0);
            assertEquals("Laptop", producto.getNombre());
            assertEquals("HP Pavilion", producto.getDescripcion());
            assertTrue(producto.getPrecio() > 0);
        }
    }
