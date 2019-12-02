package com.example.simpleresttemplate.simpleresttemplate;

import com.example.simpleresttemplate.model.Account;
import com.example.simpleresttemplate.model.BulkAccount;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SimpleRestTemplateApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	HttpHeaders headers = new HttpHeaders();

	@Test
	void usecase_1() throws URISyntaxException {
		URI uri = new URI("http://localhost:" + port + "/accounts/");
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		HttpEntity<Account> requestEntity = new HttpEntity<>(null, headers);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	void usecase_2() throws URISyntaxException {
		URI uri = new URI("http://localhost:" + port + "/accounts/");
		Account account = new Account("Mapple");

		HttpEntity<Account> entity = new HttpEntity<Account>(account, headers);
		ResponseEntity<String> responseEntityAddAccount = restTemplate.exchange(
				uri, HttpMethod.POST, entity,
				new ParameterizedTypeReference<String>() {
				});
		assertEquals(HttpStatus.CREATED, responseEntityAddAccount.getStatusCode());

		ResponseEntity<BulkAccount> responseEntityBulkAccount = restTemplate.exchange(
				uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<BulkAccount>() {
				});
		assertEquals(HttpStatus.OK, responseEntityBulkAccount.getStatusCode());
		assertEquals(3, responseEntityBulkAccount.getBody().getAccountList().size());
	}
}


