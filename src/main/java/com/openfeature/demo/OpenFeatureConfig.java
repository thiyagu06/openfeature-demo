package com.openfeature.demo;

import com.openfeature.demo.provider.InMemoryFeatureProvider;
import com.openfeature.demo.provider.PropertyBasedFeatureProvider;
import dev.openfeature.sdk.OpenFeatureAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class OpenFeatureConfig {

    @Bean("inMemory")
    public OpenFeatureAPI inMemoryOpenFeature() {
        System.out.println("instantiating the OpenFeature with inMemory Provider");
        OpenFeatureAPI instance = OpenFeatureAPI.getInstance();
        instance.setProvider(new InMemoryFeatureProvider());
        return instance;
    }

    @Bean("propertyBased")
    public OpenFeatureAPI propertyBasedFeature() {
        System.out.println("instantiating the OpenFeature with Property based Provider");
        OpenFeatureAPI instance = OpenFeatureAPI.getInstance();
        instance.setProvider(new PropertyBasedFeatureProvider());
        return instance;
    }
}
