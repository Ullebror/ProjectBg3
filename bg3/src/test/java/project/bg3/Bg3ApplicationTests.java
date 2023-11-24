package project.bg3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import project.bg3.web.ArmorController;
import project.bg3.web.Bg3Controller;
import project.bg3.web.UserController;
import project.bg3.web.WeaponController;

@SpringBootTest
@AutoConfigureMockMvc
class Bg3ApplicationTests {
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ArmorController acontroller;
	@Autowired
	private Bg3Controller bgcontroller;
	@Autowired
	private UserController ucontroller;
	@Autowired
	private WeaponController wcontroller;
	
	
	@Test
	void contextLoads() throws Exception {
		assertThat(acontroller).isNotNull();
		assertThat(bgcontroller).isNotNull();
		assertThat(ucontroller).isNotNull();
		assertThat(wcontroller).isNotNull();
	}
	
	@Test
	@WithMockUser(username = "admin", password = "password", authorities = "ADMIN")
	public void getItemlistWithMockUser() throws Exception {
		this.mvc.perform(get("/itemlist"))
				.andExpect(status().isOk());
	} 
	
	@Test
	@WithMockUser(username = "admin", password = "password", authorities = "ADMIN")
	public void testAbilityRestWithMockuser() throws Exception {

		this.mvc.perform(get("/ability"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].attribute", Matchers.equalTo("Strength")));
	}
	
	@Test
	@WithMockUser(username = "admin", password = "password", authorities = "ADMIN")
	public void testRarityRestWithMockuser() throws Exception {

		this.mvc.perform(get("/rarity"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].rarity", Matchers.equalTo("Legendary")));
	}

}
