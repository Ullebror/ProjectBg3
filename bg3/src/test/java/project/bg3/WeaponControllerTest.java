package project.bg3;

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

@SpringBootTest
@AutoConfigureMockMvc
class WeaponControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	@WithMockUser(username = "admin", password = "password", authorities = "ADMIN")
	public void testWeaponRestWithMockuser() throws Exception {

		this.mvc.perform(get("/weapons"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name", Matchers.equalTo("Nyrulna")));
	}
	
	@Test
	public void testArmorRestWithoutUser() throws Exception {
		this.mvc.perform(get("/weapons"))
				.andExpect(status().is(302));
	}

	@Test
	@WithMockUser(username = "admin", password = "password", authorities = "ADMIN")
	public void getWeaponlistWithMockUser() throws Exception {
		this.mvc.perform(get("/weaponlist"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void getAddWeaponWithoutUser() throws Exception {
		this.mvc.perform(get("/addweapon"))
				.andExpect(status().is(302));
	}
	
	@Test
	@WithMockUser(username = "admin", password = "password", authorities = "ADMIN")
	public void getEditWeaponWithMockUser() throws Exception {
		this.mvc.perform(get("/editweapon/1"))
				.andExpect(status().isOk());
	}
	

}