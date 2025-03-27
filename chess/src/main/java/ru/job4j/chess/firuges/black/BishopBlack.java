package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int x = position.getX();
        int y = position.getY();
        int size = Math.abs(dest.getX() - x);
        Cell[] steps = new Cell[size];
        int deltaX = 1;
        int deltaY = 1;
        if ((x > dest.getX() && y < dest.getY()) || (x > dest.getX() && y > dest.getY())) {
            deltaX = -1;
        }
        if ((x < dest.getX() && y > dest.getY()) || (x > dest.getX() && y > dest.getY())) {
            deltaY = -1;
        }
        for (int index = 0; index < size; index++) {
            x = x + deltaX;
            y = y + deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getY()) != Math.abs(dest.getY())
                && Math.abs(source.getX()) != Math.abs(dest.getX());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
