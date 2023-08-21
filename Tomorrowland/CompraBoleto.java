package Tomorrowland;

import java.util.Scanner;

public class CompraBoleto {
    public void iniciarCompra() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Por favor, ingrese su DPI: ");
        String dpi = scanner.nextLine();

        System.out.print("Por favor, ingrese la cantidad de boletos a comprar: ");
        int cantidadBoletos = scanner.nextInt();

        System.out.print("Por favor, ingrese su presupuesto máximo: ");
        double presupuestoMaximo = scanner.nextDouble();

        Ticket ticket = new Ticket();
        if (!ticket.esTicketApto()) {
            System.out.println("Lo siento, su ticket no es apto para comprar boletos.");
            scanner.close();
            return;
        }

        Localidad localidad = new Localidad();

        // Validación de espacio
        if (!localidad.hayEspacio()) {
            System.out.println("Lo siento, la localidad seleccionada no tiene espacio disponible.");
            scanner.close();
            return;
        }

        // Validación de disponibilidad de boletos
        cantidadBoletos = localidad.validarBoletos(cantidadBoletos);
        double totalCompra = localidad.getPrecio() * cantidadBoletos;

        // Validación de precio
        if (totalCompra > presupuestoMaximo) {
            System.out.println("Lo siento, la compra excede su presupuesto máximo de $" + presupuestoMaximo);
            scanner.close();
            return;
        }

        // Procesar compra
        localidad.comprarBoletos(cantidadBoletos);

        System.out.println("Número de ticket: " + ticket.getTicketNumber());
        System.out.println("Localidad asignada: " + localidad.getNombre());
        System.out.println("Precio por boleto: $" + localidad.getPrecio());
        System.out.println("Compra exitosa!");
        System.out.println("Nombre: " + nombre);
        System.out.println("DPI: " + dpi);
        System.out.println("Cantidad de boletos: " + cantidadBoletos);
        System.out.println("Total: $" + totalCompra);

        scanner.close();
    }
}
