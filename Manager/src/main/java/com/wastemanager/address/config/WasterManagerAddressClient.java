package com.wastemanager.address.config;

import com.wastemanager.response.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="${address.name}", url = "#{eurekaClient.getNextServerFromEureka('${discovery.gateway}', false).getHomePageUrl()}${address.name}")
public interface WasterManagerAddressClient {

    @GetMapping("/v1/api/{id}")
    ResponseEntity<ResponseModel> getWasteManagerAddressEntity(@PathVariable Long id);

}
