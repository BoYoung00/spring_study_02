package com.in28minutes.learmspringframework.examples.c1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Component
@Service // 데이터 업데이트, 검사, 프로세스 흐름 관리
public class BusinessCalculationService {
    private DataService dataService;
    public BusinessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }
    public int findMax() {
        return Arrays.stream(dataService.retrieveData())
                .max().orElse(0);
    }

}
