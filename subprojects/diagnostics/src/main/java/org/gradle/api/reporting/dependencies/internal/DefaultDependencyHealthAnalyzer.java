/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.reporting.dependencies.internal;

import java.util.Arrays;
import java.util.List;

public class DefaultDependencyHealthAnalyzer implements DependencyHealthAnalyzer {
    @Override
    public HealthReport analyze(String group, String name, String version) {
        return new DefaultHealthReport();
    }

    private static class DefaultHealthReport implements HealthReport {
        @Override
        public List<Cve> getCves() {
            return Arrays.asList(new DefaultCve());
        }
    }

    private static class DefaultCve implements Cve {
        private final String id;
        private final double score;

        private DefaultCve() {
            id = "CVE-2020-12345";
            score = 5;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public double getScore() {
            return score;
        }
    }
}