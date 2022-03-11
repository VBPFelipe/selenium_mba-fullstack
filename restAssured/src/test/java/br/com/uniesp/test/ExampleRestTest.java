package br.com.uniesp.test;

import br.com.uniesp.entidate.PessoaRequest;
import br.com.uniesp.entidate.PessoaResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ExampleRestTest {

    @BeforeEach
    void configApi() {
        baseURI = "https://reqres.in/api";
    }

    @Test
    @DisplayName("Valida Requisicao GET OK")
    @Tag("test-contrato")
    void methodGet() {
        given().log().all().when()
                .contentType(ContentType.JSON)
                .get("/users?page={id}", 2)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/methodGetTest.json")).log().all();
    }


    @Test
    @DisplayName("Valida Req Post User")
    @Tag("test-contrato")
    void createUserSucessPost() {

        PessoaRequest pessoaRequest = new PessoaRequest("Felipe", "Systems Analist And Developer");
        PessoaResponse pr = given().contentType(ContentType.JSON)
                .body(pessoaRequest)
                .when().post("/users")
                .then().statusCode(HttpStatus.SC_CREATED)
                .and().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/methodPost.json"))
                .log().all().extract().response().as(PessoaResponse.class);

        Assertions.assertNotNull(pr);
        Assertions.assertNotNull(pr.getId());
        Assertions.assertEquals(pessoaRequest.getNome(), pr.getNome());
    }

    @Test
    @DisplayName("Valida Req Put User")
    @Tag("test-contrato")
    void updateUserSucessPut(){
        PessoaRequest pessoaRequest = new PessoaRequest("Felipe Vanderlei Brasil Pinheiro", "Systems Analist And Developer");

        given()
                .and().log().all()
                .contentType(ContentType.JSON)
                .body(pessoaRequest)
                .when()
                .put("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/methodPut.json"))
                .log().all();
    }

    @Test
    @DisplayName("Valida Req Delete User")
    @Tag("test-contrato")
    void deleteUserSucessDelete(){
        given()
                .and().log().all()
                .contentType(ContentType.JSON)
                .delete("users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .and().log().all();
    }
}
