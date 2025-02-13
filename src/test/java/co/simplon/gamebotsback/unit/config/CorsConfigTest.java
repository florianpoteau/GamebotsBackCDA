package co.simplon.gamebotsback.unit.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CorsConfigTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void testCorsConfiguration() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.options("/test")
                                .header("Origin", "http://localhost:3000")
                                .header("Access-Control-Request-Method", "GET,POST,PUT,DELETE,OPTIONS")
                                .header("Access-Control-Request-Headers", "Content-Type"))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(
                                                MockMvcResultMatchers.header().string("Access-Control-Allow-Origin",
                                                                "http://localhost:3000"))
                                .andExpect(MockMvcResultMatchers.header().string("Access-Control-Allow-Methods",
                                                "GET,POST,PUT,DELETE,OPTIONS"))
                                .andExpect(MockMvcResultMatchers.header().string("Access-Control-Allow-Headers",
                                                "Content-Type"))
                                .andExpect(MockMvcResultMatchers.header().string("Access-Control-Allow-Credentials",
                                                "true"));
        }
}

