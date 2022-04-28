package org.o2f.configuration;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class BaseConfigModel {
    /**
     * Very simple configuration class
     * This class needs to be implemented in a static block
     */

    @NonNull String env;

    String baseUrl;
    String browser;
    ReportConfigModel reportConfigModel;

    @Value
    @Builder(toBuilder = true)
    public static class ReportConfigModel {

        @NonNull String reportPath;

    }

}
