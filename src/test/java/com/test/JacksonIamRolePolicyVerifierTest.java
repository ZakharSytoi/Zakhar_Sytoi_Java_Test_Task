package com.test;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JacksonIamRolePolicyVerifierTest {

    private final String VALID_POLICY_WITH_VALID_RESOURCE_WILDCARD = "src/test/resources/valid_policy_with_valid_resource_wildcard.json";
    private final String POLICY_WITHOUT_STATEMENT_FIELD = "src/test/resources/policy_without_statement_field.json";
    private final String POLICY_WITH_STATEMENT_WITHOUT_RESOURCE_FIELD = "src/test/resources/policy_with_statement_without_resource_field.json";
    private final String POLICY_WITH_INVALID_RESOURCE_FIELD = "src/test/resources/policy_with_invalid_resource.json";
    private final String NON_EXISTING_FILE = "nonexistent_file.json";



    IamRolePolicyVerifier verifier = new JacksonIamRolePolicyVerifier();
    @Test
    public void givenValidPolicyWithValidResourceWildcard_whenVerifyResourceField_thenReturnsTrue() throws IOException {
        // Given
        File iamRolePolicyFile = new File(VALID_POLICY_WITH_VALID_RESOURCE_WILDCARD);

        // When
        boolean result = verifier.verifyIamRolePolicyResourceField(iamRolePolicyFile);

        // Then
        assertTrue(result);
    }

    @Test
    public void givenPolicyWithoutStatementField_whenVerifyResourceField_thenReturnsFalse() throws IOException {
        // Given
        File iamRolePolicyFile = new File(POLICY_WITHOUT_STATEMENT_FIELD);

        // When
        boolean result = verifier.verifyIamRolePolicyResourceField(iamRolePolicyFile);

        // Then
        assertFalse(result);
    }

    @Test
    public void givenPolicyWithStatementWithoutResourceField_whenVerifyResourceField_thenReturnsFalse() throws IOException {
        // Given
        File iamRolePolicyFile = new File(POLICY_WITH_STATEMENT_WITHOUT_RESOURCE_FIELD);

        // When
        boolean result = verifier.verifyIamRolePolicyResourceField(iamRolePolicyFile);

        // Then
        assertFalse(result);
    }

    @Test
    public void givenPolicyWithInvalidResourceField_whenVerifyResourceField_thenReturnsFalse() throws IOException {
        // Given
        File iamRolePolicyFile = new File(POLICY_WITH_INVALID_RESOURCE_FIELD);

        // When
        boolean result = verifier.verifyIamRolePolicyResourceField(iamRolePolicyFile);

        // Then
        assertFalse(result);
    }

    @Test
    public void givenNonexistentFile_whenVerifyResourceField_thenThrowsIOException() {
        // Given
        File nonExistentFile = new File(NON_EXISTING_FILE);

        // When/Then
        assertThrows(IOException.class, () -> verifier.verifyIamRolePolicyResourceField(nonExistentFile));
    }
}