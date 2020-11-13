package io.github.sarahtoscano.clientes.config;

import org.apache.tomcat.jni.Local;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class InternacionalizacaoConfig {

    @Bean
    //Definição do arquivo de mensagens
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages"); //Define o arquivo de leitura da chave
        messageSource.setDefaultEncoding("ISO-8859-1"); //padrao p ler acento e cedilha
        messageSource.setDefaultLocale(Locale.getDefault());
        return messageSource;
    }
    @Bean
    //validacao das especificacoes
    public LocalValidatorFactoryBean validatorFactoryBean(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
