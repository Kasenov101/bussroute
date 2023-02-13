package com.nadex.bussroute.сontroller;

import com.nadex.bussroute.service.manager.finder.RouteFinderImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RouteController.class)
class RouteControllerTest {

    @MockBean
    RouteFinderImpl finder;

    @Autowired
    private MockMvc mvc;

    @Test
    void getDirectRoute_WhenFirstParamIsZero_ShouldThrowException() throws Exception {
        when(finder.find(anyInt(),anyInt())).thenReturn(false);

        mvc.perform(post("/api/direct")
                        .param("from","0")
                        .param("to", "25"))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("from must be greater than 0")));
    }

    @Test
    void getDirectRoute_WhenSecondParamIsZero_ShouldThrowException() throws Exception {
        when(finder.find(anyInt(),anyInt())).thenReturn(false);

        mvc.perform(post("/api/direct")
                        .param("from","20")
                        .param("to", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("to must be greater than 0")));
    }

    @Test
    void getDirectRoute_WhenFirstParamLessThanZero_ShouldThrowException() throws Exception {
        when(finder.find(anyInt(),anyInt())).thenReturn(false);

        mvc.perform(post("/api/direct")
                        .param("from","-25")
                        .param("to", "25"))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("from must be greater than 0")));
    }

    @Test
    void getDirectRoute_WhenSecondParamLessThanZero_ShouldThrowException() throws Exception {
        when(finder.find(anyInt(),anyInt())).thenReturn(false);

        mvc.perform(post("/api/direct")
                        .param("from","20")
                        .param("to", "-36"))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("to must be greater than 0")));
    }

    @Test
    void getDirectRoute_WhenFirstParamGreaterThanIntMax_ShouldThrowException() throws Exception {
        when(finder.find(anyInt(),anyInt())).thenReturn(false);

        mvc.perform(post("/api/direct")
                        .param("from", "2147483648")
                        .param("to", "25"))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("from must be less than 2 147 483 647")));
    }

    @Test
    void getDirectRoute_WhenSecondParamGreaterThanIntMax_ShouldThrowException() throws Exception {
        when(finder.find(anyInt(),anyInt())).thenReturn(false);

        mvc.perform(post("/api/direct")
                        .param("from", "30")
                        .param("to", "2147483648"))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("to must be less than 2 147 483 647")));
    }



}