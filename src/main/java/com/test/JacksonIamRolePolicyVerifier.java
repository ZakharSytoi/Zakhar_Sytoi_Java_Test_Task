package com.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * JacksonIamRolePolicyVerifier is an implementation of the IamRolePolicyVerifier interface
 * that verifies the resource field of an IAM role policy JSON file using Jackson ObjectMapper.
 */
public class JacksonIamRolePolicyVerifier implements IamRolePolicyVerifier {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Verifies the resource field of an IAM role policy JSON file.
     *
     * @param iamRolePolicyJSONfile The IAM role policy JSON file to be verified.
     * @return True if the resource field in all statements is "*", false otherwise.
     * @throws IOException If an I/O error occurs while reading the JSON file.
     */
    @Override
    public boolean verifyIamRolePolicyResourceField(File iamRolePolicyJSONfile) throws IOException {
        JsonNode rootNode = objectMapper.readTree(iamRolePolicyJSONfile);
        JsonNode statementArrayNode = rootNode.at("/PolicyDocument/Statement");
        if (statementArrayNode.isEmpty() || !statementArrayNode.isArray()) return false;

        for (JsonNode statementNode : statementArrayNode) {
            JsonNode resourceField = statementNode.get("Resource");
            if (resourceField == null) return false;
            String resourceText = resourceField.asText();
            if (!resourceText.equals("*")) return false;
        }

        return true;
    }
}
