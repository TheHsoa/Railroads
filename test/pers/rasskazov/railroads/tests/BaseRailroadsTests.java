package pers.rasskazov.railroads.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class BaseRailroadsTests {
    protected final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUpSystemErr() {
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void restoreSystemErr() {
        System.setErr(System.err);
    }
}
