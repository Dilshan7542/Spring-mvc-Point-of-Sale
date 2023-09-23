package org.thogakade.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.thogakade.entity.Customer;

import java.util.List;


@Configuration
@Import(JPAConfig.class)
public class WebRootConfig {

}
