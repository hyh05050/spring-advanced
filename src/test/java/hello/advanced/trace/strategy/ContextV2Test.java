package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {
    @Test
    void strategyV1() {
        //매번 전략을 설정!
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(() -> log.info("비지니스 로직2 실행"));
    }
}
