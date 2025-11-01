const productos = [
  { id: 1, nombre: "Laptop HP Pavilion", precio: 12299, stock: 15, imagen: "laptop-hp.jpg" },
  { id: 2, nombre: "Mouse Logitech MX Master 3", precio: 1559, stock: 30, imagen: "mouse-logitech.jpg" },
  { id: 3, nombre: "Teclado Mecánico Redragon", precio: 899, stock: 25, imagen: "teclado-redragon.jpg" },
  { id: 4, nombre: "Monitor Samsung 24''", precio: 2999, stock: 10, imagen: "monitor-samsung.jpg" }
];

let carrito = [];

const contenedor = document.getElementById('productos-container');

productos.forEach(prod => {
  const card = document.createElement('div');
  card.classList.add('card');
  card.innerHTML = `
    <img src="/img/${prod.imagen}" alt="${prod.nombre}" class="img-producto">
    <h3>${prod.nombre}</h3>
    <p>Precio: Q${prod.precio.toFixed(2)}</p>
    <p>Stock: ${prod.stock} unidades</p>
    <button onclick="agregarAlCarrito(${prod.id})">Agregar al Carrito</button>
  `;
  contenedor.appendChild(card);
});

function agregarAlCarrito(id) {
  const producto = productos.find(p => p.id === id);
  const item = carrito.find(p => p.id === id);

  if (item) {
    item.cantidad++;
  } else {
    carrito.push({ ...producto, cantidad: 1 });
  }

  actualizarCarrito();
}


const listaCarrito = document.getElementById('listaCarrito');
const totalCarrito = document.getElementById('total');
const contador = document.getElementById('contador');


function actualizarCarrito() {
  listaCarrito.innerHTML = "";
  let total = 0;

  carrito.forEach(item => {
    const li = document.createElement('li');
    li.innerHTML = `
      ${item.nombre} (x${item.cantidad})
      <span>Q${(item.precio * item.cantidad).toFixed(2)}</span>
      <button onclick="eliminarDelCarrito(${item.id})">❌</button>
    `;
    listaCarrito.appendChild(li);
    total += item.precio * item.cantidad;
  });

  totalCarrito.textContent = `Total: Q${total.toFixed(2)}`;
  contador.textContent = carrito.length;
}


function eliminarDelCarrito(id) {
  carrito = carrito.filter(p => p.id !== id);
  actualizarCarrito();
}


const carritoPanel = document.getElementById('carrito');
const btnCarrito = document.getElementById('btnCarrito');
const btnCerrar = document.getElementById('cerrarCarrito');
const btnVaciar = document.getElementById('vaciarCarrito');

btnCarrito.addEventListener('click', () => carritoPanel.classList.add('abierto'));
btnCerrar.addEventListener('click', () => carritoPanel.classList.remove('abierto'));
btnVaciar.addEventListener('click', () => {
  carrito = [];
  actualizarCarrito();
});