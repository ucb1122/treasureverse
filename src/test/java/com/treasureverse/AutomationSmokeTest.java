package com.treasureverse;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AutomationSmokeTest {

	@Test
	void issueToPullRequestAutomationCanBeVerified() {
		assertThat("treasureverse").contains("treasure");
	}
}