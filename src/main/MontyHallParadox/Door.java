package main.MontyHallParadox;

public class Door {
    private final int id;
    private boolean hasPrize;

    public Door(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean hasPrize() {
        return hasPrize;
    }

    public void setPrize(boolean hasPrize) {
        this.hasPrize = hasPrize;
    }
}
