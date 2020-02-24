package com.lti.daos;

import com.lti.entities.Claim;
import com.lti.exceptions.HrException;

public interface ClaimDao {

	public Claim addClaim(Claim claim) throws HrException;
}
