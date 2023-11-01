package com.bayamasa.myspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@SpringBootApplication
public class MySpringApplication implements CommandLineRunner {

  private final RequestMappingHandlerAdapter adapter;

  public MySpringApplication(RequestMappingHandlerAdapter adapter) {
    this.adapter = adapter;
  }

  public static void main(String[] args) {
    SpringApplication.run(MySpringApplication.class, args);
  }

  @Override
  public void run(String... args) {
    System.out.println("List of registered HttpMessageConverters:");
//		StringHttpMessageConverterとMappingJackson2HttpMessageConverterが重複されて登録されているのは仕様らしい
//		https://github.com/spring-projects/spring-boot/issues/27319
    for (HttpMessageConverter<?> converter : adapter.getMessageConverters()) {
      System.out.println(converter.getClass().getName());
      System.out.println(converter.getSupportedMediaTypes());
    }
  }
}
