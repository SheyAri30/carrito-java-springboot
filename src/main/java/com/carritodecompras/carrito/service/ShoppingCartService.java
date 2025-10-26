package com.carritodecompras.carrito.service;

import com.carritodecompras.carrito.entity.CarritoItem;
import com.carritodecompras.carrito.entity.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {

        private List<CarritoItem> items = new ArrayList<>();

        public List<CarritoItem> getItems() {
            return items;
        }

        public void agregarProducto(Producto producto, int cantidad) {
            for (CarritoItem item : items) {
                if (item.getProducto().getId().equals(producto.getId())) {
                    item.setCantidad(item.getCantidad() + cantidad);
                    return;
                }
            }
            items.add(new CarritoItem(producto, cantidad));
        }

        public void eliminarProducto(Long id) {
            items.removeIf(item -> item.getProducto().getId().equals(id));
        }

        public double calcularTotal() {
            return items.stream().mapToDouble(CarritoItem::getSubtotal).sum();
        }

        public void vaciarCarrito() {
            items.clear();
        }
    }

