package com.sip.ams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;
import com.sip.ams.services.ProviderService;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProviderApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		/*Provider p1= new Provider((long) 1,"TEST","TEST");
		Provider p2= new Provider((long) 1,"TEST","TEST");
		Provider p3= new Provider((long) 1,"TEST","TEST");
		List<Provider> provider =Arrays.asList(p1,p2,p3);*/
		
		
		//Stream.of(provider).forEach(p -> ProviderRepository.save(new Provider()));
		
		
		SpringApplication.run(ServiceProviderApplication.class, args);
	}
	
	@Autowired
	ProviderService providerService;
	
	@Override
	public void run(String... args) throws Exception {
		List<Provider> providers =Arrays.asList(
				new Provider(null,"Nokia","TEST"),
				new Provider(null,"Samsung","TEST")
				);
		
		Stream<Provider> sproviders =providers.stream();
		
		sproviders.forEach((Provider p) -> { providerService.saveProvider(p);});
		
		providerService.findAllProvider().forEach(System.out::println);
		
	}

	
	
	
	
}
