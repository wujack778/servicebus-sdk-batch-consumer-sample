// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.service.bus;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {

    ServiceBusSenderClient sender = new ServiceBusClientBuilder()
        .connectionString("connectionString")
        .sender()
        .queueName("queue")
        .buildClient();

    @RequestMapping("/send")
    public String sendMessages() {
        for (int i = 0; i < 10; i++) {
            sender.sendMessage(new ServiceBusMessage("message: " + i));
        }
        return "all right";
    }

}
