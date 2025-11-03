package com.gym.crm.registry.health;

import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("customEurekaHealthIndicator")
public class EurekaHealthIndicator implements HealthIndicator {

    private final PeerAwareInstanceRegistry registry;

    public EurekaHealthIndicator(PeerAwareInstanceRegistry registry) {
        this.registry = registry;
    }

    @Override
    public Health health() {
        try {
            int registeredApps = registry.getApplications().size();
            int totalInstances = registry.getApplications().getRegisteredApplications()
                    .stream()
                    .mapToInt(app -> app.getInstances().size())
                    .sum();

            return Health.up()
                    .withDetail("registered-applications", registeredApps)
                    .withDetail("total-instances", totalInstances)
                    .build();
        } catch (Exception e) {
            return Health.down()
                    .withDetail("error", e.getMessage())
                    .build();
        }
    }
}