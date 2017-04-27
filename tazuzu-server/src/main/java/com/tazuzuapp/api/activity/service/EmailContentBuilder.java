package com.tazuzuapp.api.activity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.util.Map;

@Service
public class EmailContentBuilder {

    private TemplateEngine templateEngine;

    @Autowired
    public EmailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @SuppressWarnings("all")
    public String build(Map<String, String> values, String templatePath) {
        Context context = new Context();

        for (Map.Entry<String, String> entry : values.entrySet()) {
            context.setVariable(entry.getKey(), entry.getValue());
        }

        return templateEngine.process(templatePath, context);
    }

}