package com.syed;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.syed.model.Movie;
import com.syed.service.MovieManagementService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/test-servlet-context.xml" })
@WebAppConfiguration
public class MyControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private MovieManagementService movieManagementService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    Movie movie1,movie2,movie3;
    Movie createdMovie;
    Locale locale;

    
    
   
    @Before
    public void setUp() {
	movie1 = new Movie(1, "Dangal","amir","Hindi");
	movie2 = new Movie(2,"Sultan","Salman","English");
	
	movie3= new Movie();
	movie3.setMoviename("Titanic");
	movie3.setLeadactor("Leonardo");
	movie3.setLanguage("English");
    createdMovie=new Movie(3,"Titanic","Leonardo","Engliish");

	MockitoAnnotations.initMocks(this);

	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	locale = new Locale("en", "IN");
    } 
    
    
    
    @Test
    public void test_listMovies() throws Exception {
        List<Movie> movies = Arrays.asList(movie1,movie2);

        when(movieManagementService.listMovies()).thenReturn(movies);

        mockMvc.perform(get("/movies/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].moviename", is("Dangal")))
                .andExpect(jsonPath("$[0].leadactor", is("amir")))
                .andExpect(jsonPath("$[0].language", is("Hindi")))
                .andExpect(jsonPath("$[1].id", is(2)))
                 .andExpect(jsonPath("$[1].moviename", is("Sultan")))
                .andExpect(jsonPath("$[1].leadactor", is("Salman")))
                .andExpect(jsonPath("$[1].language", is("English")));
                

        verify(movieManagementService,times(1)).listMovies();
        verifyNoMoreInteractions(movieManagementService);
    }

    
    
    
    

    @Test
    public void test_createMovie() throws Exception {

	when(movieManagementService.createMovie(any(Movie.class))).thenReturn(createdMovie);

	mockMvc.perform(post("/movies/create").contentType(MediaType.APPLICATION_JSON_UTF8)
		.content(new ObjectMapper().writeValueAsBytes(movie3))).andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(jsonPath("$.id", equalTo(createdMovie.getId())))
		.andExpect(jsonPath("$.moviename", equalTo(createdMovie.getMoviename())))
		.andExpect(jsonPath("$.leadactor", equalTo(createdMovie.getLeadactor())))
		.andExpect(jsonPath("$.language", equalTo(createdMovie.getLanguage())));
		

	verify(movieManagementService).createMovie(movie3);
	verifyNoMoreInteractions(movieManagementService);

    }
    
    
    
    
    @Test
    public void test_getMovieById() throws Exception {
       
        when(movieManagementService.getMovieById(1)).thenReturn(movie1);
        mockMvc.perform(get("/movies/get/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.moviename", is("Dangal")))
                .andExpect(jsonPath("$.leadactor", is("amir")))
                .andExpect(jsonPath("$.language", is("Hindi")))  ;             
               
        verify(movieManagementService, times(1)).getMovieById(1);
        verifyNoMoreInteractions(movieManagementService);
    }
    
    
   
    
    
}
