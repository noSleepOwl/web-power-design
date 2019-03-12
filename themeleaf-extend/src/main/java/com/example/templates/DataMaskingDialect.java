package com.example.templates;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

public class DataMaskingDialect extends AbstractProcessorDialect {
    private static final String PREFIX = "masking";

    public DataMaskingDialect() {
        // 方言名称，前缀，处理优先级
        super("Data Masking Dialect", PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String s) {
        // 把所有的自定义tag处理器加入处理器集，这个例子中我们只有这一个自定义处理器
        final Set<IProcessor> processorSet = new HashSet<>();
        DataMaskingDialectTagProcessor dataMaskingDialectTagProcessor = new DataMaskingDialectTagProcessor(PREFIX);
        processorSet.add(dataMaskingDialectTagProcessor);
        return processorSet;
    }
}