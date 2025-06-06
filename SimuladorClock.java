public class SimuladorClock {
    public static void main(String[] args) throws InterruptedException {
        MemoriaClock memoria = new MemoriaClock(3);
        int[] referencias = {1, 2, 3, 2, 4, 1, 5, 2};

        for (int id : referencias) {
            clearConsole();
            System.out.println("Accediendo a página: " + id + "\n");
            memoria.accederPagina(id);
            memoria.mostrarMemoriaInteractiva();
            Thread.sleep(2000); // Espera 2 segundos
        }
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // ignorar
        }
    }
}
