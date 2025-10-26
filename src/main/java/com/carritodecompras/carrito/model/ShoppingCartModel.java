package com.carritodecompras.carrito.model;

import com.carritodecompras.carrito.entity.Producto;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartModel {


        private List<Producto> productos = new ArrayList<>();
        private double total;

        public List<Producto> getProductos() { return productos; }
        public double getTotal() { return total; }

        public void agregarProducto(Producto producto) {
            productos.add(producto);
            recalcularTotal();
        }

        public void eliminarProducto(Long id) {
            productos.removeIf(p -> p.getId().equals(id));
            recalcularTotal();
        }

        public void vaciarCarrito() {
            productos.clear();
            total = 0;
        }

        private void recalcularTotal() {
            total = productos.stream().mapToDouble(Producto::getPrecio).sum();
        }
    }

