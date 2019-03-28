package io.github.yoonho.studytime.api.study;

import io.github.yoonho.studytime.service.study.StudyServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class StudyApi {
    private StudyServiceImpl studyService;
}
