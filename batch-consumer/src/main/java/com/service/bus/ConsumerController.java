// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.service.bus;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusReceiverAsyncClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    ServiceBusReceiverAsyncClient consumer = new ServiceBusClientBuilder()
        .connectionString("connectionString")
        .receiver()
        .queueName("queue")
        .buildAsyncClient();

    @RequestMapping("/receive")
    public String receiveMessage() {
        consumer
            .receiveMessages()
            .take(5)
            .map(serviceBusReceivedMessageContext -> {
                return serviceBusReceivedMessageContext;
            }).then();

        return "receive completed";
    }

}
