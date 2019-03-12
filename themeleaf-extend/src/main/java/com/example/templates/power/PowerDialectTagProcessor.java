package com.example.templates.power;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.templatemode.TemplateMode;

public class PowerDialectTagProcessor extends AbstractAttributeTagProcessor {
    private static final String TEXT_ATTRIBUTE = "code";

    PowerDialectTagProcessor(String prefix) {
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
    protected void doProcess(ITemplateContext context,
                             IProcessableElementTag tag,
                             AttributeName attributeName,
                             String attributeValue,
                             IElementTagStructureHandler structureHandler) {


    }
}
