/**
 * 
 */
package com.vir.demo.drug;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vir.demo.drug.dao.DrugDAO;
import com.vir.demo.drug.model.DrugManageDetails;
import com.vir.demo.drug.service.DrugService;
import com.vir.demo.drug.service.IDrugService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(classes = { DrugService.class, DrugDAO.class })
public class DrugServiceTest {

	@Autowired
	private IDrugService drugService;

	/*
	 * @Autowired private DrugDAO drugDao;
	 */

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

	@Test
	public void testUserLogin() throws Exception {
		String userName = "admin";
		String password = "admin";
		// UserLoginDetails response =
		String response = drugService.doLogin(userName, password);
		assertEquals("Login Success", response);

	}

	@Test
	public void testGetDrugDetails() throws Exception {
		DrugManageDetails detailsObj = new DrugManageDetails();

		detailsObj.setDrugName("Abilify");
		detailsObj.setIsActive("N");

		String response = drugService.drugManagement(detailsObj);
		assertEquals("Drug Details Successfully Updated", response);

	}

	@Test
	public void testDrugManagement() throws Exception {
		Map<String, List<String>> response = drugService.getDrugDetails();
		Assert.assertNotNull(response);

	}

	/*
	 * String uri = "/login/"; Map<String, String> loginDetails = new
	 * HashMap<String, String>(); loginDetails.put("userName","testuser");
	 * loginDetails.put("userPassword","password"); String inputJson =
	 * mapToJson(loginDetails); System.out.println("*****"+inputJson); MvcResult
	 * mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	 * .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(inputJson)).
	 * andReturn();
	 * 
	 * int status = mvcResult.getResponse().getStatus();
	 * System.out.println(status); assertEquals(201, status); String content =
	 * mvcResult.getResponse().getContentAsSting();
	 */
	// assertEquals(content, "Product is created successfully");

}
