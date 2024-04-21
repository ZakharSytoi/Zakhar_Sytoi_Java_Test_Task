package com.test;

import java.io.File;
import java.io.IOException;

public interface IamRolePolicyVerifier {
    boolean verifyIamRolePolicyResourceField(File iamRolePolicyJSONfile) throws IOException;
}
