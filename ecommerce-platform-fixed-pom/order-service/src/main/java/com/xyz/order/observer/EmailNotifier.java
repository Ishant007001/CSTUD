package com.xyz.order.observer;

import com.xyz.common.logger.LoggerUtil;
import org.slf4j.Logger;

public class EmailNotifier implements OrderObserver {
    private static final Logger logger = LoggerUtil.getLogger(EmailNotifier.class);

    @Override
    public void notifyCustomer(String message) {
        logger.info("Sending Email Notification: " + message);
    }
}
