package com.example.demoaerospike.config;

import com.example.demoaerospike.repositories.AerospikeUserRepository;
import com.aerospike.client.Host;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
import java.util.Collection;
import java.util.Collections;
@Configuration
@EnableConfigurationProperties(AerospikeConfigurationProperties.class)
@EnableAerospikeRepositories(basePackageClasses = AerospikeUserRepository.class)
@Slf4j
public class AerospikeConfiguration extends AbstractAerospikeDataConfiguration {
    @Autowired
    private AerospikeConfigurationProperties aerospikeConfigurationProperties;
    @Override
    protected Collection<Host> getHosts() {
        log.info("aerospikeConfigurationProperties.getHost():{}",aerospikeConfigurationProperties.getHost());
        log.info("aerospikeConfigurationProperties.getPort():{}",aerospikeConfigurationProperties.getPort());
        return Collections.singleton(new Host(aerospikeConfigurationProperties.getHost(),
                aerospikeConfigurationProperties.getPort()));
    }
    @Override
    protected String nameSpace() {
        log.info("aerospikeConfigurationProperties.getNamespace():{}",aerospikeConfigurationProperties.getNamespace());
        return aerospikeConfigurationProperties.getNamespace();
    }
}