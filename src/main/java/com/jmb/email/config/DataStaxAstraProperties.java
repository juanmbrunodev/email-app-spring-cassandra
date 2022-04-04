package com.jmb.email.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * Purpose of this class is to return the custom properties holding information about the astraDB
 * secure connection bundle.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "datastax.astra")
public class DataStaxAstraProperties {

    private File secureConnectBundle;
}
