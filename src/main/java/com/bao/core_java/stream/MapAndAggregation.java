package com.bao.core_java.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
class MapAndAggregation {
    @Data
    @AllArgsConstructor
    class Order {
        private String orderId;
        private int deliveryTime;
    }

    @Data
    @AllArgsConstructor
    class ServiceProdiver {
        private String name;
        private List<Order> orders;
    }

    void main() {

        List<Order> uberOrders = List.of(
                new Order("1", 5),
                new Order("2", 20));

        List<Order> lyftOrders = List.of(
                new Order("3", 5),
                new Order("4", 15));

        ServiceProdiver uberProvider = new ServiceProdiver("Uber", uberOrders);
        ServiceProdiver lyftProvider = new ServiceProdiver("Lyft", lyftOrders);
        List<ServiceProdiver> serviceProviders = List.of(uberProvider, lyftProvider);
        Map<String, Double> avgServiceProvider = new HashMap<>();
        serviceProviders.stream().forEach(x -> {
            List<Order> orders = x.getOrders();
            double avgDelieveryTime = orders.stream().map(y -> y.getDeliveryTime()).mapToInt(Integer::intValue).average().orElse(0);
            avgServiceProvider.put(x.getName(), avgDelieveryTime);
        });
        log.info("Service Provider Avg time: {}", avgServiceProvider);

        Map.Entry<String, Double> minEntry = avgServiceProvider.entrySet().stream().min(Map.Entry.comparingByValue()).orElseThrow();
        log.info("Beginner: {}", minEntry);

        // Senior level

        Map.Entry<String, Double> minEntry2 =
                serviceProviders.stream()
                        .collect(Collectors.toMap(
                                ServiceProdiver::getName,
                                sp -> sp.getOrders().stream()
                                        .mapToInt(Order::getDeliveryTime)
                                        .average()
                                        .orElse(0)
                        ))
                        .entrySet()
                        .stream()
                        .min(Map.Entry.comparingByValue())
                        .orElseThrow();

        log.info("Senior: {}", minEntry2);
    }
}
