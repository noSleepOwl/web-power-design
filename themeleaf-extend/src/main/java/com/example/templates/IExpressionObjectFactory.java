package com.example.templates;

import com.example.StringUtil;
import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.*;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;
import org.thymeleaf.templatemode.TemplateMode;

class DataMaskingDialectTagProcessor extends AbstractAttributeTagProcessor {

    private static final String TEXT_ATTRIBUTE = "text";

    private static final String PATTERN_ATTRIBUTE = "pattern";

    private static final String DEFAULT_PATTERN = "^.{2}(.*).{2}$";

    public DataMaskingDialectTagProcessor(String prefix) {
        super(
                TemplateMode.HTML, //templateMode: 模板模式，这里使用HTML模板。
                prefix, //prefix: 标签前缀。即xxx:text中的xxx。在此例子中prefix为masking。
                null, //elementName：匹配标签元素名。举例来说如果是div，则我们的自定义标签只能用在div标签中。为null能够匹配所有的标签。
                false, //prefixElementName: 标签名是否要求前缀。
                TEXT_ATTRIBUTE, //attributeName: 自定义标签属性名。这里为text。
                true, //prefixAttributeName：属性名是否要求前缀，如果为true，Thymeleaf会要求使用text属性时必须加上前缀，即masking:text。
                StandardDialect.PROCESSOR_PRECEDENCE, //precedence：标签处理的优先级，此处使用和Thymeleaf标准方言相同的优先级。
                true// removeAttribute：标签处理后是否移除自定义属性。
        );
    }

    @Override
    protected void doProcess(ITemplateContext iTemplateContext,
                             IProcessableElementTag iProcessableElementTag,
                             AttributeName attributeName,
                             String s,
                             IElementTagStructureHandler iElementTagStructureHandler) {
        //s为自定义属性text的内容，如果s为表达式，该函数可以获取表达式的值
        final Object value = getExpressionValue(iTemplateContext, s);

        IAttribute patternAttribute = iProcessableElementTag.getAttribute(PATTERN_ATTRIBUTE);
        if (null == patternAttribute) {
            // 设置标签的内容
            iElementTagStructureHandler.setBody(StringUtil.doMasking(value.toString(), DEFAULT_PATTERN), false);
        } else {
            String patternValue = iProcessableElementTag.getAttribute(PATTERN_ATTRIBUTE).getValue();
            iElementTagStructureHandler.setBody(StringUtil.doMasking(value.toString(), patternValue), false);

        }
        iElementTagStructureHandler.replaceWith(createModel(iTemplateContext, value.toString()), false);
    }

    private IModel createModel(ITemplateContext context, String text) {
        final IModelFactory modelFactory = context.getModelFactory();
        final IModel model = modelFactory.createModel();
        IOpenElementTag start = modelFactory.createOpenElementTag("h1", "style", "background:red");
        model.add(start);
        model.add(modelFactory.createText(text));
        model.add(modelFactory.createCloseElementTag("h1"));
        return model;
    }

    private Object getExpressionValue(ITemplateContext iTemplateContext, String expressionString) {
        final IEngineConfiguration configuration = iTemplateContext.getConfiguration();
        final IStandardExpressionParser parser = StandardExpressions.getExpressionParser(configuration);
        // 解析expression
        final IStandardExpression expression = parser.parseExpression(iTemplateContext, expressionString);
        // 获取expression的执行结果
        return expression.execute(iTemplateContext);
    }
}
