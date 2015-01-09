package com.mangofactory.swagger.plugins.operation;

import com.mangofactory.schema.plugins.DocumentationType;
import com.mangofactory.spring.web.plugins.OperationBuilderPlugin;
import com.mangofactory.spring.web.plugins.OperationContext;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;

@Component
public class OperationNotesReader implements OperationBuilderPlugin {
  @Override
  public void apply(OperationContext context) {

    HandlerMethod handlerMethod = context.getHandlerMethod();
    ApiOperation methodAnnotation = handlerMethod.getMethodAnnotation(ApiOperation.class);
    if (null != methodAnnotation && StringUtils.hasText(methodAnnotation.notes())) {
      context.operationBuilder().notes(methodAnnotation.notes());
    }
  }

  @Override
  public boolean supports(DocumentationType delimiter) {
    return true;
  }
}
