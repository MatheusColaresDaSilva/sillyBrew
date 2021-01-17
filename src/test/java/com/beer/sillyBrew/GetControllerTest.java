package com.beer.sillyBrew;

import com.beer.model.Recipe;
import com.beer.repository.RecipeRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class GetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeRepository recipeRepository;

    @Test
    public void testGetOneRecipe() throws Exception {
        Recipe mockRecipe = new Recipe("IPA 1", "Matheus", "IPA", "20", 58L);
        mockRecipe.setId(1);

        Mockito.when(
                recipeRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.ofNullable(mockRecipe));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/recipes/1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{\"estilo\":\"IPA\",\"eficiencia\":58,\"cervejeiro\":\"Matheus\",\"name\":\"IPA 1\",\"tamanhoLote\":\"20\",\"id\":1}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(),true);
    }

    @Test
    public void getOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string((Matchers.equalTo("ON"))));
    }
}
