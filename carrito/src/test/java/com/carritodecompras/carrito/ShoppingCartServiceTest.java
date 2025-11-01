package com.carritodecompras.carrito;

import com.carritodecompras.carrito.entity.Producto;
import com.carritodecompras.carrito.service.ShoppingCartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartServiceTest {

        private ShoppingCartService carrito;
        private Producto producto1;
        private Producto producto2;

        @BeforeEach
        void setUp() {
            carrito = new ShoppingCartService();

            producto1 = new Producto("Laptop", "HP", 5000.0, 10, "Electrónica", "laptop.jpg");
            producto2 = new Producto("Mouse", "Logitech", 200.0, 20, "Accesorios", "mouse.jpg");


            producto1.setId(1);
            producto2.setId(2);
        }

        @Test
        void agregarProductoDebeAumentarCantidad() {
            carrito.agregarProducto(producto1, 1);
            carrito.agregarProducto(producto2, 2);

            assertEquals(2, carrito.getItems().size(), "Debe haber 2 productos en el carrito");
        }

        @Test
        void eliminarProductoDebeReducirCantidad() {
            carrito.agregarProducto(producto1, 1);
            carrito.agregarProducto(producto2, 1);

            carrito.eliminarProducto(1);

            assertEquals(1, carrito.getItems().size(), "Debe quedar solo 1 producto después de eliminar");
            assertEquals(2, carrito.getItems().get(0).getProducto().getId(), "Debe quedar el producto con ID 2");
        }

        @Test
        void vaciarCarritoDebeDejarloVacio() {
            carrito.agregarProducto(producto1, 1);
            carrito.agregarProducto(producto2, 1);

            carrito.vaciarCarrito();

            assertTrue(carrito.getItems().isEmpty(), "El carrito debe quedar vacío");
        }

        @Test
        void calcularTotalDebeSerCorrecto() {
            carrito.agregarProducto(producto1, 1); // 5000
            carrito.agregarProducto(producto2, 2); // 200 * 2 = 400

            double totalEsperado = 5400.0;
            assertEquals(totalEsperado, carrito.calcularTotal(), 0.01, "El total calculado debe ser correcto");
        }
    }

