package com.ss.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.ss.app.entity.SSConfiguration;
import com.ss.app.entity.HibernateSequence;
import com.ss.app.model.SSConfigRepository;
import com.ss.app.model.HibernateSequenceRepository;
import com.ss.config.SessionFilter;

@SpringBootApplication
@ComponentScan("com.ss.app")
@EnableJpaRepositories
public class Application extends SpringBootServletInitializer { 
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	} 
	
//	@Bean
//	public FilterRegistrationBean<SessionFilter> loggingFilter(){
//	    FilterRegistrationBean<SessionFilter> registrationBean  = new FilterRegistrationBean<>();
//	    registrationBean.setFilter(new SessionFilter());
//	    return registrationBean;    
//	}
	
}

@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private HibernateSequenceRepository hibernateSequenceRepository;
	
	@Autowired
	private SSConfigRepository dbConfigRepository;

	@Override
	public void run(String... args) throws Exception {

		HibernateSequence s1 = new HibernateSequence();
		s1.setId(101);
		s1.setPrefixvalue("SS");
		s1.setNextval(1111211);
		s1.setIncrement(1);

		hibernateSequenceRepository.save(s1);
				
	}
}
