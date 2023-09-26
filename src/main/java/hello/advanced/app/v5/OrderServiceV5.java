package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepositoryV5;
    private final LogTrace trace;
    private final TraceTemplate traceTemplate;

    public void orderItem(String itemId) {
        traceTemplate.execute("OrderServiceV5.orderItem()", () -> {
            orderRepositoryV5.save(itemId);
            return null;
        });
    }
}
