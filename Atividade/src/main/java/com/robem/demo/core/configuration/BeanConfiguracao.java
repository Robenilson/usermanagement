package com.robem.demo.core.configuration;


import com.robem.demo.adapter.ports.ICommetServece;
import com.robem.demo.adapter.ports.IPublicationServece;
import com.robem.demo.core.ports.IRepositoryComment;
import com.robem.demo.core.ports.IReposotryPublication;
import com.robem.demo.core.services.CommentService;
import com.robem.demo.core.services.PublicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {
    @Bean
    ICommetServece commetServeceDefalt(IRepositoryComment repositoryComment) {
        return new CommentService(repositoryComment);
    }

    @Bean
    IPublicationServece publicationDefaulService(IReposotryPublication reposotryPublication) {
        return new PublicationService(reposotryPublication);
    }
}
