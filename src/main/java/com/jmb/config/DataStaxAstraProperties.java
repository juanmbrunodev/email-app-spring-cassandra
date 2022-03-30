package com.jmb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.File;

/**
 * Purpose of this class is to return the custom properties holding information about the astraDB
 * secure connection bundle.
 */
@Data
@ConfigurationProperties(prefix = "datastax.astra")
public class DataStaxAstraProperties {

    private File secureConnectBundle;
}
