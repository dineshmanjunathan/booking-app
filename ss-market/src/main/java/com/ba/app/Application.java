package com.ba.app;

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
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.ba.app.entity.HibernateSequence;
import com.ba.app.model.HibernateSequenceRepository;
import com.ba.app.model.SSConfigRepository;
import com.ba.config.SessionFilter;
import com.ba.scheduler.DailyRewardScheduler;

@SpringBootApplication
@ComponentScan("com.ba.app")
@EnableJpaRepositories
@EnableScheduling
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
    public DailyRewardScheduler bean() {
        return new DailyRewardScheduler();
    }

	/*
	 * @Bean public FilterRegistrationBean<SessionFilter> loggingFilter(){
	 * FilterRegistrationBean<SessionFilter> registrationBean = new
	 * FilterRegistrationBean<>(); registrationBean.setFilter(new SessionFilter());
	 * return registrationBean; }
	 */

}

@Component
class DemoCommandLineRunner implements CommandLineRunner {

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

		/*
		 * SSConfiguration ssConfig1 = new SSConfiguration(); ssConfig1.setCode("1111");
		 * ssConfig1.setDescription("COMPANY INCENTIVE"); ssConfig1.setValue(10.00);
		 * ssConfig1.setComment("COMPANY INCENTIVE (CAN MODIFY)");
		 * 
		 * SSConfiguration ssConfig2 = new SSConfiguration(); ssConfig2.setCode("1112");
		 * ssConfig2.setDescription("GST INCENTIVE"); ssConfig2.setValue(5.00);
		 * ssConfig2.setComment("GST INCENTIVE (CAN MODIFY)");
		 * 
		 * dbConfigRepository.save(ssConfig1); dbConfigRepository.save(ssConfig2);
		 */
	}
}
