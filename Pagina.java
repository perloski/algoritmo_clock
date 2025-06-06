public class Pagina {
    private final int id;
    private boolean bitUso;

    public Pagina(int id) {
        this.id = id;
        this.bitUso = true;
    }

    public int getId() {
        return id;
    }

    public boolean getBitUso() {
        return bitUso;
    }

    public void setBitUso(boolean bitUso) {
        this.bitUso = bitUso;
    }
}
