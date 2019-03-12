package com.example.templates.util;

import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IAttribute;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;

import java.util.Optional;

public class Tools {
    public static Object getExpressionValue(ITemplateContext context, String expressionString) {
        final IEngineConfiguration configuration = context.getConfiguration();
        final IStandardExpressionParser parser = StandardExpressions.getExpressionParser(configuration);
        // 解析expression
        final IStandardExpression expression = parser.parseExpression(context, expressionString);
        // 获取expression的执行结果
        return expression.execute(context);
    }

    public static String getAttributeValue(IProcessableElementTag tag, String name, String defaultValue) {
        return Optional.ofNullable(tag.getAttribute(name))
                .map(IAttribute::getValue)
                .orElse(defaultValue);
    }
}
