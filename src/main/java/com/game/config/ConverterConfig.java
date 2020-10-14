package com.game.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {

	@SuppressWarnings("rawtypes")
	@Autowired
	private List<Converter> converters;

	@Override
	public void addFormatters(FormatterRegistry registry) {
		converters.forEach(registry::addConverter);
	}
}
