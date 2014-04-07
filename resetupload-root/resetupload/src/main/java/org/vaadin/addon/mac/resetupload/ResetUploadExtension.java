package org.vaadin.addon.mac.resetupload;

import org.vaadin.addon.mac.resetupload.client.ResetUploadClientRpc;

import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.Upload;

public class ResetUploadExtension extends AbstractExtension {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7371629305645212254L;

	public ResetUploadExtension(Upload target) {
		super();
		super.extend(target);
	}

	public void resetUpload() {
		ResetUploadClientRpc rpcProxy = getRpcProxy(ResetUploadClientRpc.class);
		rpcProxy.reset();
	}
}
