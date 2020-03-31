/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.pmml;

import java.io.IOException;

import org.drools.core.io.impl.InputStreamResource;
import org.kie.api.KieBase;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.internal.utils.KieHelper;

import static org.junit.Assert.assertNotNull;
import static org.kie.test.util.filesystem.FileUtils.getFileInputStream;

public class PMMLKieBaseUtil {

    public static KieBase createKieBaseWithPMML(String fileName) throws IOException {
        Resource res = new InputStreamResource(getFileInputStream(fileName));
        KieBase kieBase = new KieHelper().addResource(res, ResourceType.PMML).build();
        assertNotNull(kieBase);
        return kieBase;
    }
}