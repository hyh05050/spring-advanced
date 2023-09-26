package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        log.info("비지니스 로직1 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}ms", resultTime );
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        log.info("비지니스 로직2 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}ms", resultTime );
    }

    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
    }

    @Test
    void strategyV2() {
        //전략을 한번 정하고 실행, 전략을 바꾸려면 setter가 필요하던가 새로운 context가 필요
        //익명 내부 클래스
        Strategy strategyImpl = new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직1 실행");
            }
        };
        ContextV1 context1 = new ContextV1(strategyImpl);
        context1.execute();

        //익명내부클래스 즉시생성 및 전달
        ContextV1 context2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직2 실행");
            }
        });
        context2.execute();

        //람다식, 인터페이스의 메서드 한개만 있어야 사용가능
        ContextV1 context3 = new ContextV1(() -> log.info("비지니스 로직3 실행"));
        context3.execute();
    }
}
