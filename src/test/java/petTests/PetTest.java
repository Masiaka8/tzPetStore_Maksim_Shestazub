package petTests;

import com.github.javafaker.Faker;
import constants.controller.PetController;
import constants.models.CreatePet;
import constants.models.Pet;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PetTest {

    SoftAssert softAssert = new SoftAssert();

    private static Faker faker = new Faker();

    @Test
    public void createPetTest() {
        CreatePet requestBody = new CreatePet()
                .setId(faker.number().numberBetween(100000, 999999999))
                .setName(faker.dog().name())
                .setStatus("available");
        Pet testPet = PetController.createPetRequest(requestBody);

        requestBody.setStatus("sold");
        Pet soldTestPet = PetController.updatePetRequest(requestBody);

        Pet findTestPet = PetController.getPetRequest(requestBody.getId());

        softAssert.assertEquals(requestBody.getName(), findTestPet.getName(), "Имя не совпадает");
        softAssert.assertEquals("sold", findTestPet.getStatus(), "Статус не совпадает");
        softAssert.assertAll();
    }
}
