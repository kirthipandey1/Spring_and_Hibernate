package com.luv2code.springdemo;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mylogger.properties")
public class MyLoggerConfig {

	@Value("${root.logger.level}")
	private String rootloggerlevel;
	
	@Value("${printed.logger.level}")
	private String printedloggerlevel;
	
	@PostConstruct
	public void initLogger() {
		
		Level rootLevel = Level.parse(rootloggerlevel);
		Level printedLevel = Level.parse(printedloggerlevel);
		
		Logger applicationContextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());
		
		Logger loggerParent = applicationContextLogger.getParent();
		
		loggerParent.setLevel(rootLevel);
		
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(printedLevel);
		consoleHandler.setFormatter(new SimpleFormatter());
		
		loggerParent.addHandler(consoleHandler);
	}
}
