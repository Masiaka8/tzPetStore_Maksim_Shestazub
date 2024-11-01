package constants.controller;

import constants.models.CreatePet;
import constants.models.Pet;
import org.apache.http.HttpStatus;

import static constants.endPoint.EndPoint.CREATE_PET;
import static constants.endPoint.EndPoint.UPDATE_PET;
import static constants.endPoint.EndPoint.FIND_PET_BY_ID;
import static constants.patterns.BaseRequest.createPostRequestAndTakeResponse;
import static constants.patterns.BaseRequest.createPutRequestAndTakeResponse;
import static constants.patterns.BaseRequest.createGetRequestAndTakeResponse;

public class PetController {

    public static Pet createPetRequest (CreatePet body) {
        return createPostRequestAndTakeResponse
                (body, CREATE_PET, HttpStatus.SC_OK)
                .extract()
                .response()
                .body()
                .as(Pet.class);
    }

    public static Pet updatePetRequest (CreatePet body) {
        return createPutRequestAndTakeResponse
                (body, UPDATE_PET, HttpStatus.SC_OK)
                .extract()
                .response()
                .body()
                .as(Pet.class);
    }

    public static Pet getPetRequest (int petId) {
        return createGetRequestAndTakeResponse
                (FIND_PET_BY_ID + petId, HttpStatus.SC_OK)
                .extract()
                .response()
                .body()
                .as(Pet.class);
    }
}
