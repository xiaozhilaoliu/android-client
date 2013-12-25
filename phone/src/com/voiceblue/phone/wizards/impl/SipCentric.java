/**
 * Copyright (C) 2010-2012 Regis Montoya (aka r3gis - www.r3gis.fr)
 * This file is part of CSipSimple.
 *
 *  CSipSimple is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  If you own a pjsip commercial license you can also redistribute it
 *  and/or modify it under the terms of the GNU Lesser General Public License
 *  as an android library.
 *
 *  CSipSimple is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with CSipSimple.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.voiceblue.phone.wizards.impl;

import android.text.InputType;

import com.voiceblue.phone.api.SipConfigManager;
import com.voiceblue.phone.api.SipProfile;
import com.voiceblue.phone.utils.PreferencesWrapper;

public class SipCentric extends SimpleImplementation {
	
	@Override
	protected String getDomain() {
		return "sip.sipcentric.com";
	}
	
	@Override
	protected String getDefaultName() {
		return "Sipcentric";
	}

	
	//Customization
	@Override
	public void fillLayout(final SipProfile account) {
		super.fillLayout(account);
		
		accountUsername.getEditText().setInputType(InputType.TYPE_CLASS_PHONE);
		
	}
	
	public SipProfile buildAccount(SipProfile account) {
		account = super.buildAccount(account);
		account.reg_timeout = 300;
		account.vm_nbr = "*95";
		account.mwi_enabled = true;
		return account;
	}
	
	@Override
	public void setDefaultParams(PreferencesWrapper prefs) {
		super.setDefaultParams(prefs);
		prefs.setPreferenceBooleanValue(SipConfigManager.USE_COMPACT_FORM, true);
	}
}