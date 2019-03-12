package com.example.springstartertester;

import com.slee.owl.powerdesign.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    final ExampleService exampleService;

    @Autowired
    public TestService(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    public void sout() {
        String res = exampleService.wrap("测试");
        System.out.println(res);
    }


}
