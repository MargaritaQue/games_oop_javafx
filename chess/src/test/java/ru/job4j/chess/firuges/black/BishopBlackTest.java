package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void position() {
        BishopBlack input = new BishopBlack(Cell.A1);
        assertThat(input.position()).isEqualTo(Cell.A1);
    }

    @Test
    void copy() {
        BishopBlack input = new BishopBlack(Cell.A1);
        assertThat((input.copy(Cell.C1)).position()).isEqualTo(Cell.C1);
    }

    @Test
    void wayC1G5() {
        BishopBlack input = new BishopBlack(Cell.C1);
        Cell[] output = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(input.way(Cell.G5)).isEqualTo(output);
    }

    @Test
    void wayF7B3() {
        BishopBlack input = new BishopBlack(Cell.F7);
        Cell[] output = {Cell.E6,Cell.D5,Cell.C4,Cell.B3};
        assertThat(input.way(Cell.B3)).isEqualTo(output);
    }

    @Test
    void wayF2C5() {
        BishopBlack input = new BishopBlack(Cell.F2);
        Cell[] output = {Cell.E3,Cell.D4,Cell.C5};
        assertThat(input.way(Cell.C5)).isEqualTo(output);
    }

    @Test
    void wayC3E1() {
        BishopBlack input = new BishopBlack(Cell.C3);
        Cell[] output = {Cell.D2,Cell.E1};
        assertThat(input.way(Cell.E1)).isEqualTo(output);
    }

    @Test
    void wayNotC1() {
        BishopBlack input = new BishopBlack(Cell.C3);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            input.way(Cell.C1);
        });
        String expected = "Could not move by diagonal from C3 to C1";
        assertThat(exception.getMessage()).isEqualTo(expected);
    }

    @Test
    void wayNotC3() {
        BishopBlack input = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            input.way(Cell.C3);
        });
        String expected = "Could not move by diagonal from C1 to C3";
        assertThat(exception.getMessage()).isEqualTo(expected);
    }

    @Test
    void wayNotD3() {
        BishopBlack input = new BishopBlack(Cell.C3);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            input.way(Cell.D3);
        });
        String expected = "Could not move by diagonal from C3 to D3";
        assertThat(exception.getMessage()).isEqualTo(expected);
    }

    @Test
    void wayNotC4() {
        BishopBlack input = new BishopBlack(Cell.D4);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            input.way(Cell.C4);
        });
        String expected = "Could not move by diagonal from D4 to C4";
        assertThat(exception.getMessage()).isEqualTo(expected);
    }
}