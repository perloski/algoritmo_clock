import java.util.*;

public class MemoriaClock {
    private final int tamaño;
    private final List<Pagina> memoria;
    private int puntero;

    public MemoriaClock(int tamaño) {
        this.tamaño = tamaño;
        this.memoria = new ArrayList<>(tamaño);
        this.puntero = 0;
    }

    public void accederPagina(int id) {
        // Verificar si ya está en memoria
        for (Pagina p : memoria) {
            if (p.getId() == id) {
                p.setBitUso(true);
                System.out.println(" Página " + id + " ya está en memoria (bitUso = 1)");
                return;
            }
        }

        // Si hay espacio, agregar directamente
        if (memoria.size() < tamaño) {
            memoria.add(new Pagina(id));
            System.out.println(" Página " + id + " agregada (espacio disponible)");
            return;
        }

        // Usar algoritmo Clock si no hay espacio
        while (true) {
            Pagina actual = memoria.get(puntero);
            if (!actual.getBitUso()) {
                System.out.println(" Reemplazando página " + actual.getId() + " por página " + id);
                memoria.set(puntero, new Pagina(id));
                avanzarPuntero();
                break;
            } else {
                actual.setBitUso(false);
                avanzarPuntero();
            }
        }
    }

    private void avanzarPuntero() {
        puntero = (puntero + 1) % tamaño;
    }

    public void mostrarMemoria() {
        System.out.print(" Memoria actual: ");
        for (Pagina p : memoria) {
            System.out.print("[ID: " + p.getId() + " R: " + (p.getBitUso() ? "1" : "0") + "] ");
        }
        System.out.println();
    }

    public void mostrarMemoriaInteractiva() {
    System.out.println("      Memoria");
    System.out.println("     ------------------------");

    for (int i = 0; i < memoria.size(); i++) {
        Pagina p = memoria.get(i);
        String punteroStr = (i == puntero) ? "--" : " ";
        String color = p.getBitUso() ? "\u001B[32m" : "\u001B[31m"; // Verde o rojo
        String reset = "\u001B[0m";

        System.out.println("     " + punteroStr + " [" +
                "ID: " + p.getId() +
                " | R: " + color + (p.getBitUso() ? "1" : "0") + reset + "]  ");
    }

    System.out.println("     ------------------------");
}

}
