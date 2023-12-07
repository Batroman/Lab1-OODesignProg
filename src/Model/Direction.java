package src.Model;

public enum Direction {
    N, E, S, W;

    public Direction goLeft() {
        return values()[(ordinal() + 1) % values().length];
    }

    public Direction goRight(){
        return values()[(ordinal() + 3) % values().length];
    }

}
