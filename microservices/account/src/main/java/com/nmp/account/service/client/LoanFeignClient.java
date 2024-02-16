package com.nmp.account.service.client;

import com.nmp.account.dto.LoanDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="loan", url = "http://loan:8090", fallback = LoanFallback.class)
public interface LoanFeignClient {

    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> fetchLoanDetails(@RequestHeader("bank-correlation-id") String correlationID, @RequestParam String mobileNumber);

}
