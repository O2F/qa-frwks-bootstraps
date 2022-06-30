package org.o2f.configuration;

import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy;

public class ParallelCustomStrategyJunit implements ParallelExecutionConfiguration, ParallelExecutionConfigurationStrategy {

    @Override
    public int getParallelism() {
        return 5;
    }

    @Override
    public int getMinimumRunnable() {
        return 1;
    }

    @Override
    public int getMaxPoolSize() {
        return 5;
    }

    @Override
    public int getCorePoolSize() {
        return 5;
    }

    @Override
    public int getKeepAliveSeconds() {
        return 60;
    }

    @Override
    public ParallelExecutionConfiguration createConfiguration(final ConfigurationParameters configurationParameters) {
        return this;
    }
}
