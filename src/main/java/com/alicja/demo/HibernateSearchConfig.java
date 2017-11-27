package com.alicja.demo;

import com.alicja.demo.db.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@EnableAutoConfiguration
@Configuration
public class HibernateSearchConfig {

    @Autowired
    private EntityManager bentitiyManager;


    @Bean
    TaskServiceImp taskServiceImp(){
        TaskServiceImp taskServiceImp = new TaskServiceImp(bentitiyManager);
        taskServiceImp.initializeHibernateSearch();
        return taskServiceImp;
    }

/*    @Bean
    public TemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.addDialect(new Java8TimeDialect());
        springTemplateEngine.setTemplateResolver(templateResolver);
        return springTemplateEngine;
    }*/

}
