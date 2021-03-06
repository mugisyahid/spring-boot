/*
 * Copyright 2012-2017 the original author or authors.
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

package org.springframework.boot.actuate.health;

import org.springframework.boot.actuate.endpoint.DefaultEnablement;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

/**
 * {@link Endpoint} to expose application {@link Status}.
 *
 * @author Stephane Nicoll
 * @since 2.0.0
 */
@Endpoint(id = "status", defaultEnablement = DefaultEnablement.ENABLED)
public class StatusEndpoint {

	private final HealthIndicator healthIndicator;

	/**
	 * Create a new {@link StatusEndpoint} instance.
	 * @param healthIndicator the health indicator
	 */
	public StatusEndpoint(HealthIndicator healthIndicator) {
		this.healthIndicator = healthIndicator;
	}

	@ReadOperation
	public Health health() {
		return Health.status(this.healthIndicator.health().getStatus()).build();
	}

}
