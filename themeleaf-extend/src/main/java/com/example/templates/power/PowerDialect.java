package com.example.templates.power;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

public class PowerDialect extends AbstractProcessorDialect {
    private String prefix;

    public PowerDialect(String prefix) {
        super("Power Control Dialect", prefix, StandardDialect.PROCESSOR_PRECEDENCE);
        this.prefix = prefix;
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        // 把所有的自定义tag处理器加入处理器集，这个例子中我们只有这一个自定义处理器
        final Set<IProcessor> processorSet = new HashSet<>();
        PowerDialectTagProcessor dataMaskingDialectTagProcessor = new PowerDialectTagProcessor(prefix);
        processorSet.add(dataMaskingDialectTagProcessor);
        return processorSet;
    }
}
