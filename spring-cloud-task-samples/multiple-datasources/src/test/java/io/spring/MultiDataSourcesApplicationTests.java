/*
 * Copyright 2015-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring;

import org.junit.Rule;
import org.junit.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.system.OutputCaptureRule;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Michael Minella
 */
public class MultiDataSourcesApplicationTests {

	@Rule
	public OutputCaptureRule outputCapture = new OutputCaptureRule();

	@Test
	public void testTimeStampApp() throws Exception {

		SpringApplication.run(MultipleDataSourcesApplication.class, new String[0]);

		String output = this.outputCapture.toString();

		assertThat(output.contains("There are 2 DataSources within this application"))
			.as("Unable to find CommandLineRunner output: " + output).isTrue();
		assertThat(output.contains("Creating: TaskExecution{"))
			.as("Unable to find start task message: " + output).isTrue();
		assertThat(output.contains("Updating: TaskExecution"))
			.as("Unable to find update task message: " + output).isTrue();
	}
}