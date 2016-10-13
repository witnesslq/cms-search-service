package com.zyhao.openec.api.v1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class DemoControllerV1 {

    private DemoServiceV1 demoService;

    @Autowired
    public DemoControllerV1(DemoServiceV1 demoService) {
        this.demoService = demoService;
    }
    
//    @RequestMapping(path = "/demo", method = RequestMethod.POST)
//    public ResponseEntity postDemo() throws Exception {
//        return Optional.ofNullable(demoService.getDemo())
//                .map(checkoutResult -> new ResponseEntity<>(checkoutResult, HttpStatus.OK))
//                .orElseThrow(() -> new Exception("Could not catalog"));
//    }

    @RequestMapping(path = "/demo", method = RequestMethod.GET)
    public ResponseEntity getDemo() throws Exception {
        return Optional.ofNullable(demoService.getDemo())
                .map(varname -> new ResponseEntity<>(varname, HttpStatus.OK))
                .orElseThrow(() -> new Exception("Could not find user"));
    }
}
