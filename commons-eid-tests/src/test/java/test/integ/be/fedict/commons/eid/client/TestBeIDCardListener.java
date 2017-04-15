/*
 * Commons eID Project.
 * Copyright (C) 2008-2013 FedICT.
 * Copyright (C) 2017 e-Contract.be BVBA.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version
 * 3.0 as published by the Free Software Foundation.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, see 
 * http://www.gnu.org/licenses/.
 */

package test.integ.be.fedict.commons.eid.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.fedict.commons.eid.client.FileType;
import be.fedict.commons.eid.client.event.BeIDCardListener;

public class TestBeIDCardListener implements BeIDCardListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestBeIDCardListener.class);

	@Override
	public void notifyReadProgress(final FileType fileType, final int offset, final int estimatedMaxSize) {
		LOGGER.debug("read progress of {}: {} of {}", fileType.name(), offset, estimatedMaxSize);
	}

	@Override
	public void notifySigningBegin(final FileType keyType) {
		LOGGER.debug("signing with {} key has begun",
				(keyType == FileType.AuthentificationCertificate ? "authentication" : "non-repudiation"));
	}

	@Override
	public void notifySigningEnd(final FileType keyType) {
		LOGGER.debug("signing with {} key has ended",
				(keyType == FileType.AuthentificationCertificate ? "authentication" : "non-repudiation"));
	}
}
