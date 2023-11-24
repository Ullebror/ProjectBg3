package project.bg3;

//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import org.hamcrest.Matchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ArmorControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	@WithMockUser(username = "admin", password = "password", authorities = "ADMIN")
	public void testArmorRestWithMockuser() throws Exception {

		this.mvc.perform(get("/armor"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name", Matchers.equalTo("Helldusk Armour")));
	}
	
	@Test
	public void testArmorRestWithoutUser() throws Exception {
		this.mvc.perform(get("/armor"))
				.andExpect(status().is(302));
	}

	@Test
	@WithMockUser(username = "admin", password = "password", authorities = "ADMIN")
	public void getArmorlistWithMockUser() throws Exception {
		this.mvc.perform(get("/armorlist"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void getAddArmorWithoutUser() throws Exception {
		this.mvc.perform(get("/addarmor"))
				.andExpect(status().is(302));
	}
	
	@Test
	@WithMockUser(username = "admin", password = "password", authorities = "ADMIN")
	public void getEditArmorWithMockUser() throws Exception {
		this.mvc.perform(get("/editarmor/1"))
				.andExpect(status().isOk());
	}
	

}