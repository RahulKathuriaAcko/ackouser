package com.acko.user;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    private static List<Map<String, String>> autoPolicies = Arrays.asList(
            ImmutableMap.of("phoneNumber", "8447838484",
                    "planName", "Harry Potter and the Philosopher's Stone",
                    "policyNumber", "223",
                    "registrationNumber", "author-1"),
            ImmutableMap.of("phoneNumber", "1234567891",
                    "planName", "Moby Dick",
                    "policyNumber", "635",
                    "registrationNumber", "author-2"),
            ImmutableMap.of("phoneNumber", "3423456789",
                    "planName", "Interview with the vampire",
                    "policyNumber", "371",
                    "registrationNumber", "author-3")
    );

    private static List<Map<String, String>> electronicsPolicies = Arrays.asList(
                ImmutableMap.of("phoneNumber", "8447838484",
                    "planName", "Harry Potter and the Philosopher's Stone",
                    "policyNumber", "223",
                    "productCategory", "author-1"),
            ImmutableMap.of("phoneNumber", "1234567891",
                    "planName", "Moby Dick",
                    "policyNumber", "635",
                    "productCategory", "author-2"),
            ImmutableMap.of("phoneNumber", "3423456789",
                    "planName", "Interview with the vampire",
                    "policyNumber", "371",
                    "productCategory", "author-3")
    );

    public DataFetcher getAutoQueryDataFetcher() {
        return dataFetchingEnvironment -> {
            String phoneNumber = dataFetchingEnvironment.getArgument("phoneNumber");
            return autoPolicies
                    .stream()
                    .filter(autoPolicy -> autoPolicy.get("phoneNumber").equals(phoneNumber))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getElectroniceQueryDataFetcher() {
        return dataFetchingEnvironment -> {
            String phoneNumber = dataFetchingEnvironment.getArgument("phoneNumber");
            return electronicsPolicies
                    .stream()
                    .filter(electronicsPolicy -> electronicsPolicy.get("phoneNumber").equals(phoneNumber))
                    .findFirst()
                    .orElse(null);
        };
    }
}