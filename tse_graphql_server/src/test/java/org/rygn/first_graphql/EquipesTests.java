package org.rygn.first_graphql;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(EquipeController.class)
@Import(GraphqlConfiguration.class)
class EquipesTests {

	@Autowired
    private GraphQlTester graphQlTester;
	
	public static String expected(String fileName) throws IOException {
        Path path = Paths.get("src/test/resource/" + fileName + "_expected_response.json");
        return new String(Files.readAllBytes(path));
    }

	@Test
	public void testEquipes()throws IOException {
		String documentName = "equipes";

        graphQlTester.documentName(documentName)
          .variable("count", 1)
          .variable("offset", 0)
          .execute()
          .path("$")
          .matchesJson(expected(documentName));
	}
}
