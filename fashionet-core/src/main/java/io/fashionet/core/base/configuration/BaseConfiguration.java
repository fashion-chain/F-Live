package io.fashionet.core.base.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.javafx.binding.StringFormatter;
import io.fashionet.core.base.request.argument.MethodArgumentResolverFactory;
import io.fashionet.core.base.response.exclusion.BaseExclusionStrategyFactory;
import io.fashionet.core.base.utils.RsaUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Configuration
public class BaseConfiguration implements WebMvcConfigurer, ApplicationContextAware {
    private static Gson generalGson = new Gson();
    private static ApplicationContext context;

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON_UTF8);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.addAll(MethodArgumentResolverFactory.resolverList());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new VersionInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new BaseParamsInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.addBasenames("i18n/message");
        return messageSource;
    }

    @Bean
    public RsaUtil rsaUtil() {
        return new RsaUtil();
    }

    public static String getMessage(String code, Object... objs) {
        String codeString;
        Locale locale = LocaleContextHolder.getLocale();
        try {
            codeString = ((MessageSource) getBean("messageSource")).getMessage(code, objs, locale);
        } catch (NoSuchMessageException e) {
            codeString = "cannot find corresponding i18n message";
        }
        return codeString;
    }

    @Bean
    public Gson httpMessageConverter() {
        return new GsonBuilder()
                .setExclusionStrategies(BaseExclusionStrategyFactory.createApiExclusionStrategies())
                .create();
    }

    @Bean
    @Autowired
    public HttpMessageConverters customConverters(Gson httpMessageConverter) {
        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        gsonHttpMessageConverter.setGson(httpMessageConverter);
        messageConverters.add(gsonHttpMessageConverter);
        return new HttpMessageConverters(true, messageConverters);
    }

    public static String getActiveProfile() {
        String[] profiles = context.getEnvironment().getActiveProfiles();
        return profiles[profiles.length-1];
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static Gson generalGson() {
        return generalGson;
    }
}
