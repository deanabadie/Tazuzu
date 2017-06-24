package com.tazuzuapp.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;

@Component
@ConfigurationProperties(prefix = "tazuzu")
public class ApplicationProperties {

    public static class Emails {
        private InternetAddress from;

        private Boolean enabled;

        public Boolean getEnabled() {
            return enabled;
        }

        public Emails setEnabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public InternetAddress getFrom() {
            return from;
        }

        public Emails setFrom(InternetAddress from) {
            this.from = from;
            return this;
        }
    }

    private String applicationUrl;

    private String apiUrl;

    private Emails emails;

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public ApplicationProperties setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
        return this;
    }

    public Emails getEmails() {
        return emails;
    }

    public ApplicationProperties setEmails(Emails emails) {
        this.emails = emails;
        return this;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public ApplicationProperties setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
        return this;
    }
}
