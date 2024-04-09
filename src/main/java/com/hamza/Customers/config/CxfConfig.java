package com.hamza.Customers.config;

import com.hamza.Customers.Controllers.CustomerSoapController;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CxfConfig {
    private final Bus bus;
    private final CustomerSoapController customerSoapController;

    @Bean
    public EndpointImpl endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, customerSoapController);
        endpoint.publish("/CustomerService");
        return endpoint;
    }
}
