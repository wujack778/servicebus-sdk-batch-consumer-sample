// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.service.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchConsumerApplication.class, args);
    }
}
