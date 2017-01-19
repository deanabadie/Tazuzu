package com.tazuzu.activity.web;

import com.tazuzu.activity.domain.Activity;
import com.tazuzu.activity.service.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nofarb on 19-Jan-17.
 */

@RestController
@RequestMapping("/activities")

public class ActivityController {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createActivity(@RequestBody Activity activity) {
        ActivityService.createActivity(activity);
        return new ResponseEntity<Object>(null, null, HttpStatus.CREATED);
    }

}
