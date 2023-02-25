package com.openfeature.demo;

import com.openfeature.demo.provider.InMemoryFeatureProvider;
import dev.openfeature.sdk.Client;
import dev.openfeature.sdk.OpenFeatureAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIResource {

    private final OpenFeatureAPI openFeatureAPI;

    @Autowired
    public APIResource(@Qualifier("inMemory") OpenFeatureAPI OFApi) {
        this.openFeatureAPI = OFApi;
    }

    @GetMapping("/hello")
    public String getHello() {
        final Client client = openFeatureAPI.getClient();
        // expect evaluation to be happened in the InMemoryFeature Provider. It's not the case.
        if (client.getBooleanValue("welcome-message", false)) {
            return "Hello, welcome to this OpenFeature-enabled website!";
        }

        return "Hello!";
    }
}
