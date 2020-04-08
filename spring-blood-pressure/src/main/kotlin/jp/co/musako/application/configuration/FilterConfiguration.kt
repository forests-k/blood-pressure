package jp.co.musako.application.configuration

import jp.co.musako.application.filter.*
import org.springframework.boot.web.servlet.*
import org.springframework.context.annotation.*
import javax.servlet.*


@Configuration
class FilterConfiguration {
  @Bean
  fun loggingFilter(): FilterRegistrationBean<out Filter> {
    val bean = FilterRegistrationBean(LoggingFilter())
    bean.addUrlPatterns("*")
    return bean
  }
}