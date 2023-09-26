package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldLogTraceTest {
    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status = trace.begin("hello");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status = trace.begin("hello");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status, new IllegalStateException());
    }
}