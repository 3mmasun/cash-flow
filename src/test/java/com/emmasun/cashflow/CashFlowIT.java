package com.emmasun.cashflow;

import com.emmasun.cashflow.entity.Expense;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = CashFlowApplication.class)
@ActiveProfiles("TEST")
@DirtiesContext()
class CashFlowIT {

	@Test
	public void shouldReturnStatus200_whenGetExpensesRequest() throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url("http://localhost:7777/api/expenses")
                .build();
		String expectedJson = getResource("/expenses.json");

        Response response = client.newCall(request).execute();
		assertThat(response.code()).isEqualTo(HttpStatus.SC_OK);
		JSONAssert.assertEquals(expectedJson, response.body().string(), false);
		response.close();
	}

	private String getResource(String fileName) {
		try {
			InputStream is = requireNonNull(Expense.class.getResourceAsStream(fileName));
			return StreamUtils.copyToString(is, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException("resource not found", e);
		}
	}

}
