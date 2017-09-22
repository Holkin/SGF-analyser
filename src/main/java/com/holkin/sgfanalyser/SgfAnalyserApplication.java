package com.holkin.sgfanalyser;

import com.holkin.sgfanalyser.ui.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SgfAnalyserApplication {

	@Autowired
	private Window window;

	public static void main(String[] args) {
		new SpringApplicationBuilder(SgfAnalyserApplication.class).headless(false).run(args);
	}
}
