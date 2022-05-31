package org.o2f.configuration;

public class YamlConfigParser {

    private String browser;
    private String app_url;

    public String getBrowser() {
        return browser;
    }

    public String getApp_url() {
        return app_url;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public void setApp_url(String app_url) {
        this.app_url = app_url;
    }
}
