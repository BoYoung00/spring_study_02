package com.in28minutes.learmspringframework.examples.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository // 데이터 액세스 계층 구성 요소 (데이터 저장, 검색), 데이터와 통신하는 것
@Primary
public class MongoDbDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[] {11,22,33,44,55};
    }
}
