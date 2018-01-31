package app.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.List;
import java.util.Arrays;

import app.dto.Classroom;
import app.service.ClassroomService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ClassroomController.class, secure = false)

public class ClassroomControllerTest {
    
    // Mock Data
    Classroom classroom1 = new Classroom(1, "1A", "Mary Joseph", 0);
    Classroom classroom2 = new Classroom(2, "2A", "Sean Connery", 0);
    Classroom newClassroom = new Classroom(3, "3A", "Will Ferell", 0);
    List<Classroom> mockClassrooms = Arrays.asList(classroom1, classroom2);
    
    @Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClassroomService classroomService;
	
	@Test
	public void getAllStudents() throws Exception {
	    Mockito.when(classroomService.getClassroomsService()).thenReturn(mockClassrooms);
	    
	    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/classrooms").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
		
		String expected = "[{\"classroomId\":1,\"classroomName\":\"1A\",\"teacherInCharge\":\"Mary Joseph\",\"studentsInClass\":0},{\"classroomId\":2,\"classroomName\":\"2A\",\"teacherInCharge\":\"Sean Connery\",\"studentsInClass\":0}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void getSpecificClassroom() throws Exception {
	    Mockito.when(classroomService.getClassroomDetailsService(Mockito.anyInt())).thenReturn(classroom1);
	    
	    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/classroom/1").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
		
		String expected = "{\"classroomId\":1,\"classroomName\":\"1A\",\"teacherInCharge\":\"Mary Joseph\",\"studentsInClass\":0}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void addClassRoom() throws Exception {
	    Mockito.when(classroomService.addClassroomService(Mockito.any(Classroom.class))).thenReturn(true);
	    
	    String inputJSON = "{\"classroomId\":3,\"classroomName\":\"3A\",\"teacherInCharge\":\"Will Ferell\",\"studentsInClass\":0}";
	    
	    RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/classroom/").accept(MediaType.APPLICATION_JSON)
            .content(inputJSON).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
		
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		assertEquals("true", result.getResponse().getContentAsString());
	}

	@Test
	public void updateClassroom() throws Exception {
	    Mockito.when(classroomService.updateClassroomByIDService(Mockito.anyInt(), Mockito.any(Classroom.class))).thenReturn(true);
	    
	    String inputJSON = "{\"classroomId\":3,\"classroomName\":\"3CA\",\"teacherInCharge\":\"Will Ferell\",\"studentsInClass\":0}";
	    
	    RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/classroom/").accept(MediaType.APPLICATION_JSON)
            .content(inputJSON).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
		
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		assertEquals("true", result.getResponse().getContentAsString());
	}
}