package com.projectmanagementapp.controller;

import com.projectmanagementapp.domain.model.IssueStatus;
import com.projectmanagementapp.domain.service.IssueService;
import com.projectmanagementapp.dto.IssueResponse;
import com.projectmanagementapp.exception.GlobalExceptionHandler;
import com.projectmanagementapp.exception.ResourceNotFoundException;
import com.projectmanagementapp.message.CommonMessage;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class IssueControllerTest {

    private static final LocalDateTime NOW = LocalDateTime.of(2026, 7, 5, 10, 0);

    private MockMvc mockMvc;

    @Mock
    private IssueService issueService;

    @BeforeEach
    void setUp() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.afterPropertiesSet();
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter(
            Jackson2ObjectMapperBuilder.json().modulesToInstall(JavaTimeModule.class).build()
        );

        mockMvc = MockMvcBuilders.standaloneSetup(new IssueController(issueService))
            .setControllerAdvice(new GlobalExceptionHandler())
            .setValidator(validator)
            .setMessageConverters(jsonConverter)
            .build();
    }

    @Test
    void findAllPassesFiltersToService() throws Exception {
        when(issueService.findAll(1L, IssueStatus.TODO)).thenReturn(List.of(issueResponse()));

        mockMvc.perform(get("/api/issues")
                .param("projectId", "1")
                .param("status", "TODO"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(10))
            .andExpect(jsonPath("$[0].statusLabel").value("未着手"));

        verify(issueService).findAll(1L, IssueStatus.TODO);
    }

    @Test
    void findByIdReturnsNotFoundWhenIssueDoesNotExist() throws Exception {
        when(issueService.findById(99L)).thenThrow(new ResourceNotFoundException(CommonMessage.ISSUE_NOT_FOUND));

        mockMvc.perform(get("/api/issues/99"))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value(CommonMessage.ISSUE_NOT_FOUND));
    }

    @Test
    void createReturnsCreated() throws Exception {
        when(issueService.create(any())).thenReturn(issueResponse());

        mockMvc.perform(post("/api/issues")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                      "projectId": 1,
                      "title": "課題登録",
                      "description": "説明",
                      "status": "TODO",
                      "priority": "MEDIUM",
                      "assigneeName": "佐藤",
                      "dueDate": "2026-07-31"
                    }
                    """))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.title").value("課題登録"));
    }

    @Test
    void createReturnsBadRequestWhenRequiredFieldsAreMissing() throws Exception {
        mockMvc.perform(post("/api/issues")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                      "projectId": 1,
                      "description": "説明",
                      "status": "TODO",
                      "priority": "MEDIUM"
                    }
                    """))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.details[0]").exists());

        verifyNoInteractions(issueService);
    }

    @Test
    void updateReturnsOk() throws Exception {
        when(issueService.update(eq(10L), any())).thenReturn(issueResponse());

        mockMvc.perform(put("/api/issues/10")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                      "projectId": 1,
                      "title": "課題登録",
                      "description": "説明",
                      "status": "TODO",
                      "priority": "MEDIUM",
                      "assigneeName": "佐藤",
                      "dueDate": "2026-07-31"
                    }
                    """))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(10));
    }

    @Test
    void deleteReturnsNoContent() throws Exception {
        mockMvc.perform(delete("/api/issues/10"))
            .andExpect(status().isNoContent());

        verify(issueService).delete(10L);
    }

    private IssueResponse issueResponse() {
        return new IssueResponse(
            10L,
            1L,
            "APP",
            "アプリ開発",
            "課題登録",
            "説明",
            "TODO",
            "未着手",
            "MEDIUM",
            "中",
            "佐藤",
            LocalDate.of(2026, 7, 31),
            NOW,
            NOW
        );
    }
}
