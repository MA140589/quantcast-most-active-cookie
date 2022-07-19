package com.quadcast.most.active.cookie.init;

import com.quadcast.most.active.cookie.executor.ProcessExecutor;
import com.quadcast.most.active.cookie.executor.ProcessExecutorImpl;
import com.quadcast.most.active.cookie.executor.ProcessRunner;
import com.quadcast.most.active.cookie.service.MostActiveCookieService;
import com.quadcast.most.active.cookie.service.MostActiveCookieServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessConfig {

  @Bean
  public CommandLineRunner commandLineRunner(
      ApplicationContext applicationContext, ProcessExecutor processExecutor) {
    return new ProcessRunner(applicationContext, processExecutor);
  }

  @Bean
  public MostActiveCookieService cookieFilter() {
    return new MostActiveCookieServiceImpl();
  }

  @Bean
  public ProcessExecutor processExecutor(MostActiveCookieService mostActiveCookieService) {
    return new ProcessExecutorImpl(mostActiveCookieService);
  }
}
