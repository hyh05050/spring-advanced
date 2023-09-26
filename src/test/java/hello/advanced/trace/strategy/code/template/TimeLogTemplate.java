package hello.advanced.trace.strategy.code.template;

import hello.advanced.trace.strategy.code.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {
    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();
        strategy.call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}ms", resultTime );
    }
}
