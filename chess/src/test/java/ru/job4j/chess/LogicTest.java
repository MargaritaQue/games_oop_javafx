package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        BishopBlack input = new BishopBlack(Cell.C1);
        Logic logic = new Logic();
        logic.add(input);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.C1, Cell.H1);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to H1");
    }

    @Test
    public void whenMoveOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        BishopBlack f = new BishopBlack(Cell.C3);
        BishopBlack s = new BishopBlack(Cell.E5);
        Logic logic = new Logic();
        logic.add(f);
        logic.add(s);
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.C3, Cell.E5);
        });
        assertThat(exception.getMessage()).isEqualTo("Occupied cell exception");
    }
}
