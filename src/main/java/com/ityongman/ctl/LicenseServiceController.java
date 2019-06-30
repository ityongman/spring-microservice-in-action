package com.ityongman.ctl;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ityongman.model.License;

@RestController
@RequestMapping(value="/v1/orgs/{orgId}/licenses")
public class LicenseServiceController {
	
	@RequestMapping(value="/{licenseId}", method=RequestMethod.GET)
	public License getLicense(@PathVariable String orgId, @PathVariable String licenseId) {
		return new License()
				.withId(licenseId)
				.withLicenseType("Seat")
				.withOrganizationId(orgId)
				.withProductName("TestOrg");
	}
}
