package com.gym.crm.registry.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaEventListener {

    private static final Logger logger = LoggerFactory.getLogger(EurekaEventListener.class);

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        logger.info("==> Service REGISTERED: {} ({})",
                event.getInstanceInfo().getAppName(),
                event.getInstanceInfo().getIPAddr());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        logger.debug("Service RENEWED: {} ({})",
                event.getInstanceInfo().getAppName(),
                event.getInstanceInfo().getIPAddr());
    }

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        logger.warn("==> Service CANCELED: {} ({})",
                event.getAppName(),
                event.getServerId());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        logger.info("==> Eureka Registry AVAILABLE");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        logger.info("==> Eureka Server STARTED");
    }
}