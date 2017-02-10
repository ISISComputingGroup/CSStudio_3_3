/* 
 * Copyright (c) 2006 Stiftung Deutsches Elektronen-Synchroton, 
 * Member of the Helmholtz Association, (DESY), HAMBURG, GERMANY.
 *
 * THIS SOFTWARE IS PROVIDED UNDER THIS LICENSE ON AN "../AS IS" BASIS. 
 * WITHOUT WARRANTY OF ANY KIND, EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED 
 * TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR PARTICULAR PURPOSE AND 
 * NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE 
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR 
 * THE USE OR OTHER DEALINGS IN THE SOFTWARE. SHOULD THE SOFTWARE PROVE DEFECTIVE 
 * IN ANY RESPECT, THE USER ASSUMES THE COST OF ANY NECESSARY SERVICING, REPAIR OR 
 * CORRECTION. THIS DISCLAIMER OF WARRANTY CONSTITUTES AN ESSENTIAL PART OF THIS LICENSE. 
 * NO USE OF ANY SOFTWARE IS AUTHORIZED HEREUNDER EXCEPT UNDER THIS DISCLAIMER.
 * DESY HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, 
 * OR MODIFICATIONS.
 * THE FULL LICENSE SPECIFYING FOR THE SOFTWARE THE REDISTRIBUTION, MODIFICATION, 
 * USAGE AND OTHER RIGHTS AND OBLIGATIONS IS INCLUDED WITH THE DISTRIBUTION OF THIS 
 * PROJECT IN THE FILE LICENSE.HTML. IF THE LICENSE IS NOT INCLUDED YOU MAY FIND A COPY 
 * AT HTTP://WWW.DESY.DE/LEGAL/LICENSE.HTM
 */
package org.csstudio.sds.ui.wizards;

import java.io.InputStream;

import org.csstudio.sds.internal.persistence.PersistenceUtil;
import org.csstudio.sds.model.DisplayModel;
import org.csstudio.sds.ui.internal.editor.DisplayEditor;
import org.csstudio.ui.util.wizards.WizardNewFileCreationPage;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * Wizard page for the creation of new SDS files.
 * 
 * @author Alexander Will
 * @version $Revision: 1.3 $
 * 
 */
public final class NewDisplayWizardPage extends WizardNewFileCreationPage {
	/**
	 * Creates a new SDS file creation wizard page.
	 * 
	 * @param pageName
	 *            the name of the page
	 * @param selection
	 *            the current resource selection
	 */
	public NewDisplayWizardPage(final String pageName,
			final IStructuredSelection selection) {
		super(pageName, selection);
		setTitle("Create a new display");
		setDescription("Create a new display in the selected project or folder.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected InputStream getInitialContents() {
		return PersistenceUtil.createStream(new DisplayModel());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewFileLabel() {
		return "Display name:";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFileExtension() {
		return DisplayEditor.SDS_FILE_EXTENSION;//$NON-NLS-1$
	}
}
