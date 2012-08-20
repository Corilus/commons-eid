/*
 * Commons eID Project.
 * Copyright (C) 2008-2012 FedICT.
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

package be.fedict.commons.eid.consumer.jca;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProxyKeyStore extends KeyStoreSpi {

	private static final Log LOG = LogFactory.getLog(ProxyKeyStore.class);

	public ProxyKeyStore() {
		LOG.debug("constructor");
	}

	@Override
	public Key engineGetKey(String alias, char[] password)
			throws NoSuchAlgorithmException, UnrecoverableKeyException {
		LOG.debug("engineGetKey");
		if ("Signature".equals(alias)) {
			return new ProxyPrivateKey();
		}
		return null;
	}

	@Override
	public Certificate[] engineGetCertificateChain(String alias) {
		LOG.debug("engineGetCertificateChain");
		return null;
	}

	@Override
	public Certificate engineGetCertificate(String alias) {
		LOG.debug("engineGetCertificate");
		return null;
	}

	@Override
	public Date engineGetCreationDate(String alias) {
		LOG.debug("engineGetCreationDate");
		if ("Signature".equals(alias)) {
			return new Date();
		}
		return null;
	}

	@Override
	public void engineSetKeyEntry(String alias, Key key, char[] password,
			Certificate[] chain) throws KeyStoreException {
		LOG.debug("engineSetKeyEntry");
	}

	@Override
	public void engineSetKeyEntry(String alias, byte[] key, Certificate[] chain)
			throws KeyStoreException {
		LOG.debug("engineSetKeyEntry");
	}

	@Override
	public void engineSetCertificateEntry(String alias, Certificate cert)
			throws KeyStoreException {
		LOG.debug("engineSetCertificateEntry");
	}

	@Override
	public void engineDeleteEntry(String alias) throws KeyStoreException {
		LOG.debug("engineDeleteEntry");
	}

	@Override
	public Enumeration<String> engineAliases() {
		LOG.debug("engineAliases");
		Vector<String> aliases = new Vector<String>();
		aliases.add("Signature");
		return aliases.elements();
	}

	@Override
	public boolean engineContainsAlias(String alias) {
		LOG.debug("engineContainsAlias");
		if ("Signature".equals(alias)) {
			return true;
		}
		return false;
	}

	@Override
	public int engineSize() {
		LOG.debug("engineSize");
		return 0;
	}

	@Override
	public boolean engineIsKeyEntry(String alias) {
		LOG.debug("engineIsKeyEntry");
		if ("Signature".equals(alias)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean engineIsCertificateEntry(String alias) {
		LOG.debug("engineIsCertificateEntry");
		return false;
	}

	@Override
	public String engineGetCertificateAlias(Certificate cert) {
		LOG.debug("engineGetCertificateAlias");
		return null;
	}

	@Override
	public void engineStore(OutputStream stream, char[] password)
			throws IOException, NoSuchAlgorithmException, CertificateException {
		LOG.debug("engineStore");
	}

	@Override
	public void engineLoad(InputStream stream, char[] password)
			throws IOException, NoSuchAlgorithmException, CertificateException {
		LOG.debug("engineLoad");
	}
}